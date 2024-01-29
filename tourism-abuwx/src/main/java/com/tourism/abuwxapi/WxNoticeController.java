package com.tourism.abuwxapi;
import com.tourism.common.core.domain.AjaxResult;
import com.tourism.system.domain.SysNotice;
import com.tourism.system.service.ISysNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 微信小程序获取通知公告接口
 */
@RestController
@RequestMapping("/wxapi")
public class WxNoticeController {

    @Autowired
    ISysNoticeService iNoticeService;
    @GetMapping("/loadNotice")
    public AjaxResult loadNotice(){
        List<SysNotice> notices = iNoticeService.selectAllNotice();
        return AjaxResult.success(notices);
    }
}
