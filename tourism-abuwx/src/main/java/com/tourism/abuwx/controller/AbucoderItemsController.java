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
import com.tourism.abuwx.domain.AbucoderItems;
import com.tourism.abuwx.service.IAbucoderItemsService;
import com.tourism.common.utils.poi.ExcelUtil;
import com.tourism.common.core.page.TableDataInfo;

/**
 * 推荐项目管理Controller
 */
@RestController
@RequestMapping("/abuwx/items")
public class AbucoderItemsController extends BaseController
{
    @Autowired
    private IAbucoderItemsService abucoderItemsService;

    /**
     * 查询推荐项目管理列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:items:list')")
    @GetMapping("/list")
    public TableDataInfo list(AbucoderItems abucoderItems)
    {
        startPage();
        List<AbucoderItems> list = abucoderItemsService.selectAbucoderItemsList(abucoderItems);
        return getDataTable(list);
    }

    /**
     * 导出推荐项目管理列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:items:export')")
    @Log(title = "推荐项目管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AbucoderItems abucoderItems)
    {
        List<AbucoderItems> list = abucoderItemsService.selectAbucoderItemsList(abucoderItems);
        ExcelUtil<AbucoderItems> util = new ExcelUtil<AbucoderItems>(AbucoderItems.class);
        util.exportExcel(response, list, "推荐项目管理数据");
    }

    /**
     * 获取推荐项目管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('abuwx:items:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(abucoderItemsService.selectAbucoderItemsById(id));
    }

    /**
     * 新增推荐项目管理
     */
    @PreAuthorize("@ss.hasPermi('abuwx:items:add')")
    @Log(title = "推荐项目管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AbucoderItems abucoderItems)
    {
        return toAjax(abucoderItemsService.insertAbucoderItems(abucoderItems));
    }

    /**
     * 修改推荐项目管理
     */
    @PreAuthorize("@ss.hasPermi('abuwx:items:edit')")
    @Log(title = "推荐项目管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AbucoderItems abucoderItems)
    {
        return toAjax(abucoderItemsService.updateAbucoderItems(abucoderItems));
    }

    /**
     * 删除推荐项目管理
     */
    @PreAuthorize("@ss.hasPermi('abuwx:items:remove')")
    @Log(title = "推荐项目管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(abucoderItemsService.deleteAbucoderItemsByIds(ids));
    }
}
