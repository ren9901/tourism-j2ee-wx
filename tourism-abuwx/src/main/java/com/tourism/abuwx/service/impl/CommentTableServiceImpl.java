package com.tourism.abuwx.service.impl;

import java.util.List;
import com.tourism.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourism.abuwx.mapper.CommentTableMapper;
import com.tourism.abuwx.domain.CommentTable;
import com.tourism.abuwx.service.ICommentTableService;

/**
 * 评论Service业务层处理
 * 
 * @author tourism
 * @date 2024-01-30
 */
@Service
public class CommentTableServiceImpl implements ICommentTableService 
{
    @Autowired
    private CommentTableMapper commentTableMapper;

    /**
     * 查询评论
     * 
     * @param id 评论主键
     * @return 评论
     */
    @Override
    public CommentTable selectCommentTableById(Long id)
    {
        return commentTableMapper.selectCommentTableById(id);
    }

    /**
     * 查询评论列表
     * 
     * @param commentTable 评论
     * @return 评论
     */
    @Override
    public List<CommentTable> selectCommentTableList(CommentTable commentTable)
    {
        return commentTableMapper.selectCommentTableList(commentTable);
    }

    /**
     * 新增评论
     * 
     * @param commentTable 评论
     * @return 结果
     */
    @Override
    public int insertCommentTable(CommentTable commentTable)
    {
        commentTable.setCreateTime(DateUtils.getNowDate());
        return commentTableMapper.insertCommentTable(commentTable);
    }

    /**
     * 修改评论
     * 
     * @param commentTable 评论
     * @return 结果
     */
    @Override
    public int updateCommentTable(CommentTable commentTable)
    {
        commentTable.setUpdateTime(DateUtils.getNowDate());
        return commentTableMapper.updateCommentTable(commentTable);
    }

    /**
     * 批量删除评论
     * 
     * @param ids 需要删除的评论主键
     * @return 结果
     */
    @Override
    public int deleteCommentTableByIds(Long[] ids)
    {
        return commentTableMapper.deleteCommentTableByIds(ids);
    }

    /**
     * 删除评论信息
     * 
     * @param id 评论主键
     * @return 结果
     */
    @Override
    public int deleteCommentTableById(Long id)
    {
        return commentTableMapper.deleteCommentTableById(id);
    }

    @Override
    public List<CommentTable> getCommentListByJdID(Long jdid) {
        return commentTableMapper.getCommentListByJdID(jdid);
    }
}
