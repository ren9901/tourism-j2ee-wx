package com.tourism.abuwx.service;

import java.util.List;
import com.tourism.abuwx.domain.AbucoderWxappConfig;

/**
 * 小程序配置Service接口
 */
public interface IAbucoderWxappConfigService 
{
    /**
     * 查询小程序配置
     * 
     * @param id 小程序配置主键
     * @return 小程序配置
     */
    public AbucoderWxappConfig selectAbucoderWxappConfigById(Long id);

    /**
     * 查询小程序配置列表
     * 
     * @param abucoderWxappConfig 小程序配置
     * @return 小程序配置集合
     */
    public List<AbucoderWxappConfig> selectAbucoderWxappConfigList(AbucoderWxappConfig abucoderWxappConfig);

    /**
     * 新增小程序配置
     * 
     * @param abucoderWxappConfig 小程序配置
     * @return 结果
     */
    public int insertAbucoderWxappConfig(AbucoderWxappConfig abucoderWxappConfig);

    /**
     * 修改小程序配置
     * 
     * @param abucoderWxappConfig 小程序配置
     * @return 结果
     */
    public int updateAbucoderWxappConfig(AbucoderWxappConfig abucoderWxappConfig);

    /**
     * 批量删除小程序配置
     * 
     * @param ids 需要删除的小程序配置主键集合
     * @return 结果
     */
    public int deleteAbucoderWxappConfigByIds(Long[] ids);

    /**
     * 删除小程序配置信息
     * 
     * @param id 小程序配置主键
     * @return 结果
     */
    public int deleteAbucoderWxappConfigById(Long id);

    /**
     * 查询开启的小程序配置信息
     * @return
     */
    public AbucoderWxappConfig selectAbucoderWxappConfig();
}
