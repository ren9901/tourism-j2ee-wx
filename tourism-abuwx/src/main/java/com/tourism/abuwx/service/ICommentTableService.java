package com.tourism.abuwx.service;

import java.util.List;
import com.tourism.abuwx.domain.CommentTable;

/**
 * 评论Service接口
 * 
 * @author tourism
 * @date 2024-01-30
 */
public interface ICommentTableService 
{
    /**
     * 查询评论
     * 
     * @param id 评论主键
     * @return 评论
     */
    public CommentTable selectCommentTableById(Long id);

    /**
     * 查询评论列表
     * 
     * @param commentTable 评论
     * @return 评论集合
     */
    public List<CommentTable> selectCommentTableList(CommentTable commentTable);

    /**
     * 新增评论
     * 
     * @param commentTable 评论
     * @return 结果
     */
    public int insertCommentTable(CommentTable commentTable);

    /**
     * 修改评论
     * 
     * @param commentTable 评论
     * @return 结果
     */
    public int updateCommentTable(CommentTable commentTable);

    /**
     * 批量删除评论
     * 
     * @param ids 需要删除的评论主键集合
     * @return 结果
     */
    public int deleteCommentTableByIds(Long[] ids);

    /**
     * 删除评论信息
     * 
     * @param id 评论主键
     * @return 结果
     */
    public int deleteCommentTableById(Long id);
}
