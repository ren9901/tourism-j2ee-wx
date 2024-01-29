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
import com.tourism.abuwx.domain.AbucoderPrograms;
import com.tourism.abuwx.service.IAbucoderProgramsService;
import com.tourism.common.utils.poi.ExcelUtil;
import com.tourism.common.core.page.TableDataInfo;

/**
 * 推荐开源项目Controller
 */
@RestController
@RequestMapping("/abuwx/programs")
public class AbucoderProgramsController extends BaseController
{
    @Autowired
    private IAbucoderProgramsService abucoderProgramsService;

    /**
     * 查询推荐开源项目列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:programs:list')")
    @GetMapping("/list")
    public TableDataInfo list(AbucoderPrograms abucoderPrograms)
    {
        startPage();
        List<AbucoderPrograms> list = abucoderProgramsService.selectAbucoderProgramsList(abucoderPrograms);
        return getDataTable(list);
    }

    /**
     * 导出推荐开源项目列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:programs:export')")
    @Log(title = "推荐开源项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AbucoderPrograms abucoderPrograms)
    {
        List<AbucoderPrograms> list = abucoderProgramsService.selectAbucoderProgramsList(abucoderPrograms);
        ExcelUtil<AbucoderPrograms> util = new ExcelUtil<AbucoderPrograms>(AbucoderPrograms.class);
        util.exportExcel(response, list, "推荐开源项目数据");
    }

    /**
     * 获取推荐开源项目详细信息
     */
    @PreAuthorize("@ss.hasPermi('abuwx:programs:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(abucoderProgramsService.selectAbucoderProgramsById(id));
    }

    /**
     * 新增推荐开源项目
     */
    @PreAuthorize("@ss.hasPermi('abuwx:programs:add')")
    @Log(title = "推荐开源项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AbucoderPrograms abucoderPrograms)
    {
        return toAjax(abucoderProgramsService.insertAbucoderPrograms(abucoderPrograms));
    }

    /**
     * 修改推荐开源项目
     */
    @PreAuthorize("@ss.hasPermi('abuwx:programs:edit')")
    @Log(title = "推荐开源项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AbucoderPrograms abucoderPrograms)
    {
        return toAjax(abucoderProgramsService.updateAbucoderPrograms(abucoderPrograms));
    }

    /**
     * 删除推荐开源项目
     */
    @PreAuthorize("@ss.hasPermi('abuwx:programs:remove')")
    @Log(title = "推荐开源项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(abucoderProgramsService.deleteAbucoderProgramsByIds(ids));
    }
}
