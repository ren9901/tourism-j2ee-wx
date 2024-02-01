package com.tourism.abuwxapi;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.tourism.abuwx.domain.AbucoderWxuser;
import com.tourism.abuwx.service.IAbucoderWxappConfigService;
import com.tourism.abuwx.service.IAbucoderWxuserService;
import com.tourism.common.config.TourismConfig;
import com.tourism.common.core.domain.AjaxResult;
import com.tourism.common.utils.DateUtils;
import com.tourism.common.utils.file.FileUploadUtils;
import com.tourism.common.utils.file.FileUtils;
import com.tourism.common.utils.http.HttpUtils;
import com.tourism.framework.config.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/wxapi/")
public class WxLoginController {

    /**
     * 测试接口
     * @return
     */
    @GetMapping("test")
    public AjaxResult test(){
        return AjaxResult.success("小程序api调试成功！~");
    }

    @Autowired
    private IAbucoderWxuserService iAbucoderWxuserService;

    @Autowired
    private IAbucoderWxappConfigService wxappConfigService;

    @Autowired
    private ServerConfig serverConfig;

    /**
     * 你自己的微信小程序APPID
     */

    private final static String AppID = "wx2264cb8c1cd32b7e";
    /**
     * 你自己的微信APP密钥
     */
    private final static String AppSecret = "881f703208783949f576297477c3923c";

    /**
     * 登录时获取的 code（微信官方提供的临时凭证）
     * @param object
     * @return
     */
    @PostMapping("/wxlogin")
    public AjaxResult wxLogin(@RequestBody JSONObject object){
        //微信官方提供的微信小程序登录授权时使用的URL地址
        String url  = "https://api.weixin.qq.com/sns/jscode2session";
        System.out.println(object);

        /**
         * 拼接需要的参数
         * appid = AppID 你自己的微信小程序APPID
         * js_code = AppSecret 你自己的微信APP密钥
         * grant_type=authorization_code = code 微信官方提供的临时凭证
         */
        String params = StrUtil.format("appid={}&secret={}&js_code={}&grant_type=authorization_code", AppID, AppSecret, object.get("code"));
        //开始发起网络请求,若依管理系统自带网络请求工具，直接使用即可
        String res = HttpUtils.sendGet(url,params);
        JSONObject jsonObject = JSON.parseObject(res);
        String openid = (String) jsonObject.get("openid");
        if (StrUtil.isEmpty(openid)) {
            return AjaxResult.error("未获取到openid");
        }
        /**先通过openid来查询是否存在*/
        AbucoderWxuser abucoderWxuser = iAbucoderWxuserService.selectAbucoderWxuserOpenID(openid);
        if (abucoderWxuser == null){
            /**如果不存在就插入到我们的数据库里*/
            AbucoderWxuser  wxuser = new AbucoderWxuser();
            wxuser.setOpenid(openid);
            wxuser.setCreateTime(DateUtils.getNowDate());
            iAbucoderWxuserService.insertAbucoderWxuser(wxuser);
            /**返回结果集到前段*/
           return AjaxResult.success(wxuser);
        }else {
            /**返回结果集到前段*/
            return AjaxResult.success(abucoderWxuser);
        }
    }

    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file) throws Exception
    {
        System.out.println(file);
        try
        {
            // 上传文件路径
            String filePath = TourismConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("url", url);
            ajax.put("fileName", fileName);
            ajax.put("newFileName", FileUtils.getName(fileName));
            ajax.put("originalFilename", file.getOriginalFilename());
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 保存昵称与头像信息到用户信息里
     * @param object
     * @return
     */
    @PostMapping("/saveUserInfo")
    @ResponseBody
    public AjaxResult saveUserInfo(@RequestBody JSONObject object){
        System.out.println(object);
        AbucoderWxuser abucoderWxuser = iAbucoderWxuserService.selectAbucoderWxuserOpenID(String.valueOf(object.get("openid")));
        if (StringUtils.hasLength(String.valueOf(object.get("nickName")))){
            abucoderWxuser.setNickname(String.valueOf(object.get("nickName")));
            abucoderWxuser.setCreateBy(String.valueOf(object.get("nickName")));
        }
        if (StringUtils.hasLength(String.valueOf(object.get("avatarUrl")))){
            abucoderWxuser.setAvatar(String.valueOf(object.get("avatarUrl")));
        }
        abucoderWxuser.setUpdateTime(DateUtils.getNowDate());
        iAbucoderWxuserService.updateAbucoderWxuser(abucoderWxuser);
        //返回前段需要的数据
        return AjaxResult.success(abucoderWxuser);
    }

    @GetMapping(value = "getWxInfo/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(iAbucoderWxuserService.selectAbucoderWxuserById(id));
    }


}
