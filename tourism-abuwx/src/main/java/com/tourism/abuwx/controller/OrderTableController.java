package com.tourism.abuwx.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tourism.common.annotation.Log;
import com.tourism.common.core.controller.BaseController;
import com.tourism.common.core.domain.AjaxResult;
import com.tourism.common.enums.BusinessType;
import com.tourism.abuwx.domain.OrderTable;
import com.tourism.abuwx.service.IOrderTableService;
import com.tourism.common.utils.poi.ExcelUtil;
import com.tourism.common.core.page.TableDataInfo;

/**
 * 订单Controller
 * 
 * @author tourism
 * @date 2024-01-30
 */
@RestController
@RequestMapping("/abuwx/orderTabel")
public class OrderTableController extends BaseController
{
    @Autowired
    private IOrderTableService orderTableService;

    /**
     * 查询订单列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:orderTabel:list')")
    @GetMapping("/list")
    public TableDataInfo list(OrderTable orderTable)
    {
        startPage();
        List<OrderTable> list = orderTableService.selectOrderTableList(orderTable);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:orderTabel:export')")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrderTable orderTable)
    {
        List<OrderTable> list = orderTableService.selectOrderTableList(orderTable);
        ExcelUtil<OrderTable> util = new ExcelUtil<OrderTable>(OrderTable.class);
        util.exportExcel(response, list, "订单数据");
    }

    /**
     * 获取订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('abuwx:orderTabel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(orderTableService.selectOrderTableById(id));
    }

    /**
     * 新增订单
     */
    @PreAuthorize("@ss.hasPermi('abuwx:orderTabel:add')")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderTable orderTable)
    {
        return toAjax(orderTableService.insertOrderTable(orderTable));
    }

    /**
     * 修改订单
     */
    @PreAuthorize("@ss.hasPermi('abuwx:orderTabel:edit')")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderTable orderTable)
    {
        return toAjax(orderTableService.updateOrderTable(orderTable));
    }

    /**
     * 删除订单
     */
    @PreAuthorize("@ss.hasPermi('abuwx:orderTabel:remove')")
    @Log(title = "订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderTableService.deleteOrderTableByIds(ids));
    }
}
