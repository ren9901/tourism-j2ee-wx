package com.tourism.abuwx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tourism.common.annotation.Excel;
import com.tourism.common.core.domain.BaseEntity;

/**
 * 推荐开源项目对象 abucoder_programs
 */
public class AbucoderPrograms extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String programName;

    /** 标签 */
    @Excel(name = "标签")
    private String programTag;

    /** 图片 */
    @Excel(name = "图片")
    private String programImg;

    /** 项目介绍 */
    private String programContent;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProgramName(String programName) 
    {
        this.programName = programName;
    }

    public String getProgramName() 
    {
        return programName;
    }
    public void setProgramTag(String programTag) 
    {
        this.programTag = programTag;
    }

    public String getProgramTag() 
    {
        return programTag;
    }
    public void setProgramImg(String programImg) 
    {
        this.programImg = programImg;
    }

    public String getProgramImg() 
    {
        return programImg;
    }
    public void setProgramContent(String programContent) 
    {
        this.programContent = programContent;
    }

    public String getProgramContent() 
    {
        return programContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("programName", getProgramName())
            .append("programTag", getProgramTag())
            .append("programImg", getProgramImg())
            .append("programContent", getProgramContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
