package com.tourism.abuwx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tourism.common.annotation.Excel;
import com.tourism.common.core.domain.BaseEntity;

/**
 * 景区表对象 VX_JINGDIAN_TABLE
 * 
 * @author tourism
 * @date 2024-01-30
 */
public class VxJingdianTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 景区名称 */
    @Excel(name = "景区名称")
    private String name;

    /** 景区图片 */
    @Excel(name = "景区图片")
    private String indexUrl;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private String dznum;

    /** 价格 */
    @Excel(name = "价格")
    private Long price;

    /** 收藏数 */
    @Excel(name = "收藏数")
    private String collectNum;

    /** 库存 */
    @Excel(name = "库存")
    private Long kucunNum;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIndexUrl(String indexUrl) 
    {
        this.indexUrl = indexUrl;
    }

    public String getIndexUrl() 
    {
        return indexUrl;
    }
    public void setDznum(String dznum) 
    {
        this.dznum = dznum;
    }

    public String getDznum() 
    {
        return dznum;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setCollectNum(String collectNum) 
    {
        this.collectNum = collectNum;
    }

    public String getCollectNum() 
    {
        return collectNum;
    }
    public void setKucunNum(Long kucunNum) 
    {
        this.kucunNum = kucunNum;
    }

    public Long getKucunNum() 
    {
        return kucunNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("indexUrl", getIndexUrl())
            .append("dznum", getDznum())
            .append("price", getPrice())
            .append("remark", getRemark())
            .append("collectNum", getCollectNum())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("kucunNum", getKucunNum())
            .toString();
    }
}
