package com.tourism.abuwx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tourism.common.annotation.Excel;
import com.tourism.common.core.domain.BaseEntity;

/**
 * 轮播图管理对象 abucoder_banners
 */
public class AbucoderBanners extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 轮播图标题 */
    @Excel(name = "轮播图标题")
    private String bannerTitle;

    /** 轮播图连接 */
    @Excel(name = "轮播图连接")
    private String bannerUrl;

    /** 图片 */
    @Excel(name = "图片")
    private String bannerImg;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBannerTitle(String bannerTitle) 
    {
        this.bannerTitle = bannerTitle;
    }

    public String getBannerTitle() 
    {
        return bannerTitle;
    }
    public void setBannerUrl(String bannerUrl) 
    {
        this.bannerUrl = bannerUrl;
    }

    public String getBannerUrl() 
    {
        return bannerUrl;
    }
    public void setBannerImg(String bannerImg) 
    {
        this.bannerImg = bannerImg;
    }

    public String getBannerImg() 
    {
        return bannerImg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bannerTitle", getBannerTitle())
            .append("bannerUrl", getBannerUrl())
            .append("bannerImg", getBannerImg())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
