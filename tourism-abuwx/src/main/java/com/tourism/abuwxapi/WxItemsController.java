package com.tourism.abuwxapi;

import com.tourism.abuwx.domain.AbucoderItems;
import com.tourism.abuwx.service.IAbucoderItemsService;
import com.tourism.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 微信小程序获取推荐小程序接口
 */
@RestController
@RequestMapping("/wxapi")
public class WxItemsController {

    @Autowired
    IAbucoderItemsService iAbucoderItemsService;
    @GetMapping("/loadItems")
    public AjaxResult loadItems(AbucoderItems abucoderItems){
        List<AbucoderItems> itemslist = iAbucoderItemsService.selectAbucoderItemsList(abucoderItems);
        return AjaxResult.success(itemslist);
    }
}
