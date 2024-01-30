package com.tourism.abuwx.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourism.abuwx.mapper.WxuserCollentMapper;
import com.tourism.abuwx.domain.WxuserCollent;
import com.tourism.abuwx.service.IWxuserCollentService;

/**
 * 微信用户和收藏景点关联Service业务层处理
 * 
 * @author tourism
 * @date 2024-01-30
 */
@Service
public class WxuserCollentServiceImpl implements IWxuserCollentService 
{
    @Autowired
    private WxuserCollentMapper wxuserCollentMapper;

    /**
     * 查询微信用户和收藏景点关联
     * 
     * @param wxuserId 微信用户和收藏景点关联主键
     * @return 微信用户和收藏景点关联
     */
    @Override
    public WxuserCollent selectWxuserCollentByWxuserId(Long wxuserId)
    {
        return wxuserCollentMapper.selectWxuserCollentByWxuserId(wxuserId);
    }

    /**
     * 查询微信用户和收藏景点关联列表
     * 
     * @param wxuserCollent 微信用户和收藏景点关联
     * @return 微信用户和收藏景点关联
     */
    @Override
    public List<WxuserCollent> selectWxuserCollentList(WxuserCollent wxuserCollent)
    {
        return wxuserCollentMapper.selectWxuserCollentList(wxuserCollent);
    }

    /**
     * 新增微信用户和收藏景点关联
     * 
     * @param wxuserCollent 微信用户和收藏景点关联
     * @return 结果
     */
    @Override
    public int insertWxuserCollent(WxuserCollent wxuserCollent)
    {
        return wxuserCollentMapper.insertWxuserCollent(wxuserCollent);
    }

    /**
     * 修改微信用户和收藏景点关联
     * 
     * @param wxuserCollent 微信用户和收藏景点关联
     * @return 结果
     */
    @Override
    public int updateWxuserCollent(WxuserCollent wxuserCollent)
    {
        return wxuserCollentMapper.updateWxuserCollent(wxuserCollent);
    }

    /**
     * 批量删除微信用户和收藏景点关联
     * 
     * @param wxuserIds 需要删除的微信用户和收藏景点关联主键
     * @return 结果
     */
    @Override
    public int deleteWxuserCollentByWxuserIds(Long[] wxuserIds)
    {
        return wxuserCollentMapper.deleteWxuserCollentByWxuserIds(wxuserIds);
    }

    /**
     * 删除微信用户和收藏景点关联信息
     * 
     * @param wxuserId 微信用户和收藏景点关联主键
     * @return 结果
     */
    @Override
    public int deleteWxuserCollentByWxuserId(Long wxuserId)
    {
        return wxuserCollentMapper.deleteWxuserCollentByWxuserId(wxuserId);
    }
}
