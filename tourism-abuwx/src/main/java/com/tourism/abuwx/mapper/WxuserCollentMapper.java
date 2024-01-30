package com.tourism.abuwx.mapper;

import java.util.List;
import com.tourism.abuwx.domain.WxuserCollent;

/**
 * 微信用户和收藏景点关联Mapper接口
 * 
 * @author tourism
 * @date 2024-01-30
 */
public interface WxuserCollentMapper 
{
    /**
     * 查询微信用户和收藏景点关联
     * 
     * @param wxuserId 微信用户和收藏景点关联主键
     * @return 微信用户和收藏景点关联
     */
    public WxuserCollent selectWxuserCollentByWxuserId(Long wxuserId);

    /**
     * 查询微信用户和收藏景点关联列表
     * 
     * @param wxuserCollent 微信用户和收藏景点关联
     * @return 微信用户和收藏景点关联集合
     */
    public List<WxuserCollent> selectWxuserCollentList(WxuserCollent wxuserCollent);

    /**
     * 新增微信用户和收藏景点关联
     * 
     * @param wxuserCollent 微信用户和收藏景点关联
     * @return 结果
     */
    public int insertWxuserCollent(WxuserCollent wxuserCollent);

    /**
     * 修改微信用户和收藏景点关联
     * 
     * @param wxuserCollent 微信用户和收藏景点关联
     * @return 结果
     */
    public int updateWxuserCollent(WxuserCollent wxuserCollent);

    /**
     * 删除微信用户和收藏景点关联
     * 
     * @param wxuserId 微信用户和收藏景点关联主键
     * @return 结果
     */
    public int deleteWxuserCollentByWxuserId(Long wxuserId);

    /**
     * 批量删除微信用户和收藏景点关联
     * 
     * @param wxuserIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWxuserCollentByWxuserIds(Long[] wxuserIds);
}
