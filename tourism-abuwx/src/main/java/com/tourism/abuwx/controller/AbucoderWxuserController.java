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
import com.tourism.abuwx.domain.AbucoderWxuser;
import com.tourism.abuwx.service.IAbucoderWxuserService;
import com.tourism.common.utils.poi.ExcelUtil;
import com.tourism.common.core.page.TableDataInfo;

/**
 * 微信用户Controller
 */
@RestController
@RequestMapping("/abuwx/wxuser")
public class AbucoderWxuserController extends BaseController
{
    @Autowired
    private IAbucoderWxuserService abucoderWxuserService;

    /**
     * 查询微信用户列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:wxuser:list')")
    @GetMapping("/list")
    public TableDataInfo list(AbucoderWxuser abucoderWxuser)
    {
        startPage();
        List<AbucoderWxuser> list = abucoderWxuserService.selectAbucoderWxuserList(abucoderWxuser);
        return getDataTable(list);
    }

    /**
     * 导出微信用户列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:wxuser:export')")
    @Log(title = "微信用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AbucoderWxuser abucoderWxuser)
    {
        List<AbucoderWxuser> list = abucoderWxuserService.selectAbucoderWxuserList(abucoderWxuser);
        ExcelUtil<AbucoderWxuser> util = new ExcelUtil<AbucoderWxuser>(AbucoderWxuser.class);
        util.exportExcel(response, list, "微信用户数据");
    }

    /**
     * 获取微信用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('abuwx:wxuser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(abucoderWxuserService.selectAbucoderWxuserById(id));
    }

    /**
     * 新增微信用户
     */
    @PreAuthorize("@ss.hasPermi('abuwx:wxuser:add')")
    @Log(title = "微信用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AbucoderWxuser abucoderWxuser)
    {
        return toAjax(abucoderWxuserService.insertAbucoderWxuser(abucoderWxuser));
    }

    /**
     * 修改微信用户
     */
    @PreAuthorize("@ss.hasPermi('abuwx:wxuser:edit')")
    @Log(title = "微信用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AbucoderWxuser abucoderWxuser)
    {
        return toAjax(abucoderWxuserService.updateAbucoderWxuser(abucoderWxuser));
    }

    /**
     * 删除微信用户
     */
    @PreAuthorize("@ss.hasPermi('abuwx:wxuser:remove')")
    @Log(title = "微信用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(abucoderWxuserService.deleteAbucoderWxuserByIds(ids));
    }
}
