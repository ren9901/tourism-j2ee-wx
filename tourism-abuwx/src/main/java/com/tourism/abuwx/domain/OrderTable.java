package com.tourism.abuwx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tourism.common.annotation.Excel;
import com.tourism.common.core.domain.BaseEntity;

/**
 * 订单对象 order_table
 * 
 * @author tourism
 * @date 2024-01-31
 */
public class OrderTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 微信用户ID */
    private Long wxuserId;

    /** 景点ID */
    private Long jingdianId;

    /** 景点名称 */
    @Excel(name = "景点名称")
    private String jdname;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String nickname;

    /** 订单价格 */
    @Excel(name = "订单价格")
    private Long price;

    /** 订单数量 */
    @Excel(name = "订单数量")
    private String orderNum;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
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
    public void setJdname(String jdname) 
    {
        this.jdname = jdname;
    }

    public String getJdname() 
    {
        return jdname;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setOrderNum(String orderNum) 
    {
        this.orderNum = orderNum;
    }

    public String getOrderNum() 
    {
        return orderNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("wxuserId", getWxuserId())
            .append("jingdianId", getJingdianId())
            .append("jdname", getJdname())
            .append("nickname", getNickname())
            .append("price", getPrice())
            .append("orderNum", getOrderNum())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
