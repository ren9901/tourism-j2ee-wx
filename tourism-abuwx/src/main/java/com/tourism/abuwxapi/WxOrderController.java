package com.tourism.abuwxapi;

import com.tourism.abuwx.domain.OrderTable;
import com.tourism.abuwx.service.IOrderTableService;
import com.tourism.abuwx.service.IVxJingdianTableService;
import com.tourism.common.core.controller.BaseController;
import com.tourism.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/wxapi/")
public class WxOrderController extends BaseController {

    @Autowired
    private IOrderTableService orderTableService;
    @Autowired
    private IVxJingdianTableService jdService;

    /**
     * 下单
     */
    @PostMapping("buy")
    public AjaxResult buy(@RequestBody OrderTable orderTable){
        // 执行库存-1
        jdService.updateKc(orderTable.getJingdianId());

        return toAjax(orderTableService.insertOrderTable(orderTable));
    }
}
