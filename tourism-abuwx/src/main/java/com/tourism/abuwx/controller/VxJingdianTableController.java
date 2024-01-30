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
import com.tourism.abuwx.domain.VxJingdianTable;
import com.tourism.abuwx.service.IVxJingdianTableService;
import com.tourism.common.utils.poi.ExcelUtil;
import com.tourism.common.core.page.TableDataInfo;

/**
 * 景区表Controller
 * 
 * @author tourism
 * @date 2024-01-30
 */
@RestController
@RequestMapping("/abuwx/jingdianTable")
public class VxJingdianTableController extends BaseController
{
    @Autowired
    private IVxJingdianTableService vxJingdianTableService;

    /**
     * 查询景区表列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:jingdianTable:list')")
    @GetMapping("/list")
    public TableDataInfo list(VxJingdianTable vxJingdianTable)
    {
        startPage();
        List<VxJingdianTable> list = vxJingdianTableService.selectVxJingdianTableList(vxJingdianTable);
        return getDataTable(list);
    }

    /**
     * 导出景区表列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:jingdianTable:export')")
    @Log(title = "景区表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VxJingdianTable vxJingdianTable)
    {
        List<VxJingdianTable> list = vxJingdianTableService.selectVxJingdianTableList(vxJingdianTable);
        ExcelUtil<VxJingdianTable> util = new ExcelUtil<VxJingdianTable>(VxJingdianTable.class);
        util.exportExcel(response, list, "景区表数据");
    }

    /**
     * 获取景区表详细信息
     */
    @PreAuthorize("@ss.hasPermi('abuwx:jingdianTable:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(vxJingdianTableService.selectVxJingdianTableById(id));
    }

    /**
     * 新增景区表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:jingdianTable:add')")
    @Log(title = "景区表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VxJingdianTable vxJingdianTable)
    {
        return toAjax(vxJingdianTableService.insertVxJingdianTable(vxJingdianTable));
    }

    /**
     * 修改景区表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:jingdianTable:edit')")
    @Log(title = "景区表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VxJingdianTable vxJingdianTable)
    {
        return toAjax(vxJingdianTableService.updateVxJingdianTable(vxJingdianTable));
    }

    /**
     * 删除景区表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:jingdianTable:remove')")
    @Log(title = "景区表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(vxJingdianTableService.deleteVxJingdianTableByIds(ids));
    }
}
