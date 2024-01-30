package com.tourism.abuwx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tourism.common.annotation.Excel;
import com.tourism.common.core.domain.BaseEntity;

/**
 * 评论对象 comment_table
 * 
 * @author tourism
 * @date 2024-01-30
 */
public class CommentTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 景点ID */
    private Long jingdianId;

    /** 评论用户ID */
    private Long wxuserId;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String content;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setJingdianId(Long jingdianId) 
    {
        this.jingdianId = jingdianId;
    }

    public Long getJingdianId() 
    {
        return jingdianId;
    }
    public void setWxuserId(Long wxuserId) 
    {
        this.wxuserId = wxuserId;
    }

    public Long getWxuserId() 
    {
        return wxuserId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("jingdianId", getJingdianId())
            .append("wxuserId", getWxuserId())
            .append("content", getContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
