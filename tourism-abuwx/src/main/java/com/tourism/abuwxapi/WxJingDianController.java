package com.tourism.abuwxapi;

import com.tourism.abuwx.domain.VxJingdianTable;
import com.tourism.abuwx.service.IVxJingdianTableService;
import com.tourism.common.core.controller.BaseController;
import com.tourism.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wxapi/")
public class WxJingDianController extends BaseController {

    @Autowired
    private IVxJingdianTableService jdService;

    /**
     * 查询景区表列表
     */
    @GetMapping("jdList")
    public AjaxResult loadBaneer(VxJingdianTable vxJingdianTable){
        List<VxJingdianTable> jdList = jdService.selectVxJingdianTableList(vxJingdianTable);
        return AjaxResult.success(jdList);
    }

    @GetMapping("jdListTop3")
    public AjaxResult jdListTop3(VxJingdianTable vxJingdianTable){
        List<VxJingdianTable> jdList = jdService.selectVxJingdianTableListTop3(vxJingdianTable);
        return AjaxResult.success(jdList);
    }

    /**
     * 获取景区表详细信息
     */
    @GetMapping(value = "jdInfo/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id){
        return AjaxResult.success(jdService.selectVxJingdianTableById(id));
    }

    /**
     * 获取用户收藏景区列表
     */
    @GetMapping(value = "byUserId/{wxuserId}")
    public AjaxResult getListByUserId(@PathVariable("wxuserId") Long wxuserId){
        List<VxJingdianTable> jdList = jdService.selectVxJingdianTableByWxuserId(wxuserId);
        return AjaxResult.success(jdList);
    }

    /**
     * 点赞
     */
    @PutMapping("operateDz")
    public AjaxResult operateDz(@RequestBody VxJingdianTable vxJingdianTable)
    {
        return toAjax(jdService.operateDzVxJingdianTable(vxJingdianTable));
    }

    /**
     * 收藏
     */
    @PutMapping("operateSc")
    public AjaxResult operateSc(@RequestBody VxJingdianTable vxJingdianTable,@RequestParam Long wxuserId)
    {
        return toAjax(jdService.operateScVxJingdianTable(vxJingdianTable,wxuserId));
    }

    /**
     * 下单（库存-1） 做到订单控制层
     */

}
