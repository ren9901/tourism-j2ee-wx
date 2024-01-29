package com.tourism.abuwxapi;

import com.tourism.abuwx.domain.AbucoderPrograms;
import com.tourism.abuwx.service.IAbucoderProgramsService;
import com.tourism.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 微信小程序获取推荐项目接口
 */
@RestController
@RequestMapping("/wxapi")
public class WxProgramController {

    @Autowired
    IAbucoderProgramsService iAbucoderProgramsService;
    @GetMapping("/loadProgramms")
    public AjaxResult loadProgramms(AbucoderPrograms abucoderPrograms){
        List<AbucoderPrograms> programmslist = iAbucoderProgramsService.selectAbucoderProgramsList(abucoderPrograms);
        return AjaxResult.success(programmslist);
    }
}
