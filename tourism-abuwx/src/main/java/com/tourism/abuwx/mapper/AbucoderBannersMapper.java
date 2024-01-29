package com.tourism.abuwx.mapper;

import java.util.List;
import com.tourism.abuwx.domain.AbucoderBanners;

/**
 * 轮播图管理Mapper接口
 */
public interface AbucoderBannersMapper 
{
    /**
     * 查询轮播图管理
     * 
     * @param id 轮播图管理主键
     * @return 轮播图管理
     */
    public AbucoderBanners selectAbucoderBannersById(Long id);

    /**
     * 查询轮播图管理列表
     * 
     * @param abucoderBanners 轮播图管理
     * @return 轮播图管理集合
     */
    public List<AbucoderBanners> selectAbucoderBannersList(AbucoderBanners abucoderBanners);

    /**
     * 新增轮播图管理
     * 
     * @param abucoderBanners 轮播图管理
     * @return 结果
     */
    public int insertAbucoderBanners(AbucoderBanners abucoderBanners);

    /**
     * 修改轮播图管理
     * 
     * @param abucoderBanners 轮播图管理
     * @return 结果
     */
    public int updateAbucoderBanners(AbucoderBanners abucoderBanners);

    /**
     * 删除轮播图管理
     * 
     * @param id 轮播图管理主键
     * @return 结果
     */
    public int deleteAbucoderBannersById(Long id);

    /**
     * 批量删除轮播图管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAbucoderBannersByIds(Long[] ids);
}
