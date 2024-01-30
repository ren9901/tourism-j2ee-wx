package com.tourism.abuwx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tourism.common.annotation.Excel;
import com.tourism.common.core.domain.BaseEntity;

/**
 * 微信用户和收藏景点关联对象 wxuser_collent
 * 
 * @author tourism
 * @date 2024-01-30
 */
public class WxuserCollent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 微信用户ID */
    private Long wxuserId;

    /** 景点ID */
    private Long jingdianId;

    public void setWxuserId(Long wxuserId) 
    {
        this.wxuserId = wxuserId;
    }

    public Long getWxuserId() 
    {
        return wxuserId;
    }
    public void setJingdianId(Long jingdianId) 
    {
        this.jingdianId = jingdianId;
    }

    public Long getJingdianId() 
    {
        return jingdianId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("wxuserId", getWxuserId())
            .append("jingdianId", getJingdianId())
            .toString();
    }
}
