package com.tourism.abuwx.service;

import java.util.List;
import com.tourism.abuwx.domain.AbucoderItems;

/**
 * 推荐项目管理Service接口
 */
public interface IAbucoderItemsService 
{
    /**
     * 查询推荐项目管理
     * 
     * @param id 推荐项目管理主键
     * @return 推荐项目管理
     */
    public AbucoderItems selectAbucoderItemsById(Long id);

    /**
     * 查询推荐项目管理列表
     * 
     * @param abucoderItems 推荐项目管理
     * @return 推荐项目管理集合
     */
    public List<AbucoderItems> selectAbucoderItemsList(AbucoderItems abucoderItems);

    /**
     * 新增推荐项目管理
     * 
     * @param abucoderItems 推荐项目管理
     * @return 结果
     */
    public int insertAbucoderItems(AbucoderItems abucoderItems);

    /**
     * 修改推荐项目管理
     * 
     * @param abucoderItems 推荐项目管理
     * @return 结果
     */
    public int updateAbucoderItems(AbucoderItems abucoderItems);

    /**
     * 批量删除推荐项目管理
     * 
     * @param ids 需要删除的推荐项目管理主键集合
     * @return 结果
     */
    public int deleteAbucoderItemsByIds(Long[] ids);

    /**
     * 删除推荐项目管理信息
     * 
     * @param id 推荐项目管理主键
     * @return 结果
     */
    public int deleteAbucoderItemsById(Long id);
}
