package com.tourism.abuwx.service.impl;

import java.util.List;
import com.tourism.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourism.abuwx.mapper.AbucoderProgramsMapper;
import com.tourism.abuwx.domain.AbucoderPrograms;
import com.tourism.abuwx.service.IAbucoderProgramsService;

/**
 * 推荐开源项目Service业务层处理
 */
@Service
public class AbucoderProgramsServiceImpl implements IAbucoderProgramsService 
{
    @Autowired
    private AbucoderProgramsMapper abucoderProgramsMapper;

    /**
     * 查询推荐开源项目
     * 
     * @param id 推荐开源项目主键
     * @return 推荐开源项目
     */
    @Override
    public AbucoderPrograms selectAbucoderProgramsById(Long id)
    {
        return abucoderProgramsMapper.selectAbucoderProgramsById(id);
    }

    /**
     * 查询推荐开源项目列表
     * 
     * @param abucoderPrograms 推荐开源项目
     * @return 推荐开源项目
     */
    @Override
    public List<AbucoderPrograms> selectAbucoderProgramsList(AbucoderPrograms abucoderPrograms)
    {
        return abucoderProgramsMapper.selectAbucoderProgramsList(abucoderPrograms);
    }

    /**
     * 新增推荐开源项目
     * 
     * @param abucoderPrograms 推荐开源项目
     * @return 结果
     */
    @Override
    public int insertAbucoderPrograms(AbucoderPrograms abucoderPrograms)
    {
        abucoderPrograms.setCreateTime(DateUtils.getNowDate());
        return abucoderProgramsMapper.insertAbucoderPrograms(abucoderPrograms);
    }

    /**
     * 修改推荐开源项目
     * 
     * @param abucoderPrograms 推荐开源项目
     * @return 结果
     */
    @Override
    public int updateAbucoderPrograms(AbucoderPrograms abucoderPrograms)
    {
        abucoderPrograms.setUpdateTime(DateUtils.getNowDate());
        return abucoderProgramsMapper.updateAbucoderPrograms(abucoderPrograms);
    }

    /**
     * 批量删除推荐开源项目
     * 
     * @param ids 需要删除的推荐开源项目主键
     * @return 结果
     */
    @Override
    public int deleteAbucoderProgramsByIds(Long[] ids)
    {
        return abucoderProgramsMapper.deleteAbucoderProgramsByIds(ids);
    }

    /**
     * 删除推荐开源项目信息
     * 
     * @param id 推荐开源项目主键
     * @return 结果
     */
    @Override
    public int deleteAbucoderProgramsById(Long id)
    {
        return abucoderProgramsMapper.deleteAbucoderProgramsById(id);
    }
}
