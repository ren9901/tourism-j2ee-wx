package com.tourism.abuwx.service.impl;

import java.util.List;
import com.tourism.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourism.abuwx.mapper.AbucoderWxappConfigMapper;
import com.tourism.abuwx.domain.AbucoderWxappConfig;
import com.tourism.abuwx.service.IAbucoderWxappConfigService;

/**
 * 小程序配置Service业务层处理
 */
@Service
public class AbucoderWxappConfigServiceImpl implements IAbucoderWxappConfigService 
{
    @Autowired
    private AbucoderWxappConfigMapper abucoderWxappConfigMapper;

    /**
     * 查询小程序配置
     * 
     * @param id 小程序配置主键
     * @return 小程序配置
     */
    @Override
    public AbucoderWxappConfig selectAbucoderWxappConfigById(Long id)
    {
        return abucoderWxappConfigMapper.selectAbucoderWxappConfigById(id);
    }

    /**
     * 查询小程序配置列表
     * 
     * @param abucoderWxappConfig 小程序配置
     * @return 小程序配置
     */
    @Override
    public List<AbucoderWxappConfig> selectAbucoderWxappConfigList(AbucoderWxappConfig abucoderWxappConfig)
    {
        return abucoderWxappConfigMapper.selectAbucoderWxappConfigList(abucoderWxappConfig);
    }

    /**
     * 新增小程序配置
     * 
     * @param abucoderWxappConfig 小程序配置
     * @return 结果
     */
    @Override
    public int insertAbucoderWxappConfig(AbucoderWxappConfig abucoderWxappConfig)
    {
        abucoderWxappConfig.setCreateTime(DateUtils.getNowDate());
        return abucoderWxappConfigMapper.insertAbucoderWxappConfig(abucoderWxappConfig);
    }

    /**
     * 修改小程序配置
     * 
     * @param abucoderWxappConfig 小程序配置
     * @return 结果
     */
    @Override
    public int updateAbucoderWxappConfig(AbucoderWxappConfig abucoderWxappConfig)
    {
        abucoderWxappConfig.setUpdateTime(DateUtils.getNowDate());
        return abucoderWxappConfigMapper.updateAbucoderWxappConfig(abucoderWxappConfig);
    }

    /**
     * 批量删除小程序配置
     * 
     * @param ids 需要删除的小程序配置主键
     * @return 结果
     */
    @Override
    public int deleteAbucoderWxappConfigByIds(Long[] ids)
    {
        return abucoderWxappConfigMapper.deleteAbucoderWxappConfigByIds(ids);
    }

    /**
     * 删除小程序配置信息
     * 
     * @param id 小程序配置主键
     * @return 结果
     */
    @Override
    public int deleteAbucoderWxappConfigById(Long id)
    {
        return abucoderWxappConfigMapper.deleteAbucoderWxappConfigById(id);
    }

    /**
     * 查询开启的小程序配置信息
     * @return
     */
    @Override
    public AbucoderWxappConfig selectAbucoderWxappConfig() {
        return abucoderWxappConfigMapper.selectAbucoderWxappConfig();
    }
}
