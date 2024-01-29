package com.tourism.abuwx.service.impl;

import java.util.List;
import com.tourism.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourism.abuwx.mapper.AbucoderItemsMapper;
import com.tourism.abuwx.domain.AbucoderItems;
import com.tourism.abuwx.service.IAbucoderItemsService;

/**
 * 推荐项目管理Service业务层处理
 */
@Service
public class AbucoderItemsServiceImpl implements IAbucoderItemsService 
{
    @Autowired
    private AbucoderItemsMapper abucoderItemsMapper;

    /**
     * 查询推荐项目管理
     * 
     * @param id 推荐项目管理主键
     * @return 推荐项目管理
     */
    @Override
    public AbucoderItems selectAbucoderItemsById(Long id)
    {
        return abucoderItemsMapper.selectAbucoderItemsById(id);
    }

    /**
     * 查询推荐项目管理列表
     * 
     * @param abucoderItems 推荐项目管理
     * @return 推荐项目管理
     */
    @Override
    public List<AbucoderItems> selectAbucoderItemsList(AbucoderItems abucoderItems)
    {
        return abucoderItemsMapper.selectAbucoderItemsList(abucoderItems);
    }

    /**
     * 新增推荐项目管理
     * 
     * @param abucoderItems 推荐项目管理
     * @return 结果
     */
    @Override
    public int insertAbucoderItems(AbucoderItems abucoderItems)
    {
        abucoderItems.setCreateTime(DateUtils.getNowDate());
        return abucoderItemsMapper.insertAbucoderItems(abucoderItems);
    }

    /**
     * 修改推荐项目管理
     * 
     * @param abucoderItems 推荐项目管理
     * @return 结果
     */
    @Override
    public int updateAbucoderItems(AbucoderItems abucoderItems)
    {
        abucoderItems.setUpdateTime(DateUtils.getNowDate());
        return abucoderItemsMapper.updateAbucoderItems(abucoderItems);
    }

    /**
     * 批量删除推荐项目管理
     * 
     * @param ids 需要删除的推荐项目管理主键
     * @return 结果
     */
    @Override
    public int deleteAbucoderItemsByIds(Long[] ids)
    {
        return abucoderItemsMapper.deleteAbucoderItemsByIds(ids);
    }

    /**
     * 删除推荐项目管理信息
     * 
     * @param id 推荐项目管理主键
     * @return 结果
     */
    @Override
    public int deleteAbucoderItemsById(Long id)
    {
        return abucoderItemsMapper.deleteAbucoderItemsById(id);
    }
}
