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
import com.tourism.abuwx.domain.CommentTable;
import com.tourism.abuwx.service.ICommentTableService;
import com.tourism.common.utils.poi.ExcelUtil;
import com.tourism.common.core.page.TableDataInfo;

/**
 * 评论Controller
 * 
 * @author tourism
 * @date 2024-01-30
 */
@RestController
@RequestMapping("/abuwx/comment")
public class CommentTableController extends BaseController
{
    @Autowired
    private ICommentTableService commentTableService;

    /**
     * 查询评论列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:table:list')")
    @GetMapping("/list")
    public TableDataInfo list(CommentTable commentTable)
    {
        startPage();
        List<CommentTable> list = commentTableService.selectCommentTableList(commentTable);
        return getDataTable(list);
    }

    /**
     * 导出评论列表
     */
    @PreAuthorize("@ss.hasPermi('abuwx:table:export')")
    @Log(title = "评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CommentTable commentTable)
    {
        List<CommentTable> list = commentTableService.selectCommentTableList(commentTable);
        ExcelUtil<CommentTable> util = new ExcelUtil<CommentTable>(CommentTable.class);
        util.exportExcel(response, list, "评论数据");
    }

    /**
     * 获取评论详细信息
     */
    @PreAuthorize("@ss.hasPermi('abuwx:table:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(commentTableService.selectCommentTableById(id));
    }

    /**
     * 新增评论
     */
    @PreAuthorize("@ss.hasPermi('abuwx:table:add')")
    @Log(title = "评论", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CommentTable commentTable)
    {
        return toAjax(commentTableService.insertCommentTable(commentTable));
    }

    /**
     * 修改评论
     */
    @PreAuthorize("@ss.hasPermi('abuwx:table:edit')")
    @Log(title = "评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CommentTable commentTable)
    {
        return toAjax(commentTableService.updateCommentTable(commentTable));
    }

    /**
     * 删除评论
     */
    @PreAuthorize("@ss.hasPermi('abuwx:table:remove')")
    @Log(title = "评论", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(commentTableService.deleteCommentTableByIds(ids));
    }
}
