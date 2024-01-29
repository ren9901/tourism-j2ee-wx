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
import com.tourism.abuwx.domain.AbucoderBanners;
import com.tourism.abuwx.service.IAbucoderBannersService;
import com.tourism.common.utils.poi.ExcelUtil;
import com.tourism.common.core.page.TableDataInfo;

/**
 * 轮播图管理Controller
 */
@RestController
@RequestMapping("/abuwx/banners")
public class AbucoderBannersController extends BaseController
{
    @Autowired
    private IAbucoderBannersService abucoderBannersService;

    /**
     * 查询轮播图管理列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:banners:list')")
    @GetMapping("/list")
    public TableDataInfo list(AbucoderBanners abucoderBanners)
    {
        startPage();
        List<AbucoderBanners> list = abucoderBannersService.selectAbucoderBannersList(abucoderBanners);
        return getDataTable(list);
    }

    /**
     * 导出轮播图管理列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:banners:export')")
    @Log(title = "轮播图管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AbucoderBanners abucoderBanners)
    {
        List<AbucoderBanners> list = abucoderBannersService.selectAbucoderBannersList(abucoderBanners);
        ExcelUtil<AbucoderBanners> util = new ExcelUtil<AbucoderBanners>(AbucoderBanners.class);
        util.exportExcel(response, list, "轮播图管理数据");
    }

    /**
     * 获取轮播图管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('abuwx:banners:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(abucoderBannersService.selectAbucoderBannersById(id));
    }

    /**
     * 新增轮播图管理
     */
    @PreAuthorize("@ss.hasPermi('abuwx:banners:add')")
    @Log(title = "轮播图管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AbucoderBanners abucoderBanners)
    {
        return toAjax(abucoderBannersService.insertAbucoderBanners(abucoderBanners));
    }

    /**
     * 修改轮播图管理
     */
    @PreAuthorize("@ss.hasPermi('abuwx:banners:edit')")
    @Log(title = "轮播图管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AbucoderBanners abucoderBanners)
    {
        return toAjax(abucoderBannersService.updateAbucoderBanners(abucoderBanners));
    }

    /**
     * 删除轮播图管理
     */
    @PreAuthorize("@ss.hasPermi('abuwx:banners:remove')")
    @Log(title = "轮播图管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(abucoderBannersService.deleteAbucoderBannersByIds(ids));
    }
}
