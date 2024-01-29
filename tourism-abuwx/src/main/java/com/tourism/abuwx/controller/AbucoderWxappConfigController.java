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
import com.tourism.abuwx.domain.AbucoderWxappConfig;
import com.tourism.abuwx.service.IAbucoderWxappConfigService;
import com.tourism.common.utils.poi.ExcelUtil;
import com.tourism.common.core.page.TableDataInfo;

/**
 * 小程序配置Controller
 */
@RestController
@RequestMapping("/abuwx/wxappconfig")
public class AbucoderWxappConfigController extends BaseController
{
    @Autowired
    private IAbucoderWxappConfigService abucoderWxappConfigService;

    /**
     * 查询小程序配置列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:wxappconfig:list')")
    @GetMapping("/list")
    public TableDataInfo list(AbucoderWxappConfig abucoderWxappConfig)
    {
        startPage();
        List<AbucoderWxappConfig> list = abucoderWxappConfigService.selectAbucoderWxappConfigList(abucoderWxappConfig);
        return getDataTable(list);
    }

    /**
     * 导出小程序配置列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:wxappconfig:export')")
    @Log(title = "小程序配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AbucoderWxappConfig abucoderWxappConfig)
    {
        List<AbucoderWxappConfig> list = abucoderWxappConfigService.selectAbucoderWxappConfigList(abucoderWxappConfig);
        ExcelUtil<AbucoderWxappConfig> util = new ExcelUtil<AbucoderWxappConfig>(AbucoderWxappConfig.class);
        util.exportExcel(response, list, "小程序配置数据");
    }

    /**
     * 获取小程序配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('abuwx:wxappconfig:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(abucoderWxappConfigService.selectAbucoderWxappConfigById(id));
    }

    /**
     * 新增小程序配置
     */
    @PreAuthorize("@ss.hasPermi('abuwx:wxappconfig:add')")
    @Log(title = "小程序配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AbucoderWxappConfig abucoderWxappConfig)
    {
        return toAjax(abucoderWxappConfigService.insertAbucoderWxappConfig(abucoderWxappConfig));
    }

    /**
     * 修改小程序配置
     */
    @PreAuthorize("@ss.hasPermi('abuwx:wxappconfig:edit')")
    @Log(title = "小程序配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AbucoderWxappConfig abucoderWxappConfig)
    {
        return toAjax(abucoderWxappConfigService.updateAbucoderWxappConfig(abucoderWxappConfig));
    }

    /**
     * 删除小程序配置
     */
    @PreAuthorize("@ss.hasPermi('abuwx:wxappconfig:remove')")
    @Log(title = "小程序配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(abucoderWxappConfigService.deleteAbucoderWxappConfigByIds(ids));
    }
}
