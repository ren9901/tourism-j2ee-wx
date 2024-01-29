package com.tourism.abuwx.service;

import java.util.List;
import com.tourism.abuwx.domain.AbucoderPrograms;

/**
 * 推荐开源项目Service接口
 */
public interface IAbucoderProgramsService 
{
    /**
     * 查询推荐开源项目
     * 
     * @param id 推荐开源项目主键
     * @return 推荐开源项目
     */
    public AbucoderPrograms selectAbucoderProgramsById(Long id);

    /**
     * 查询推荐开源项目列表
     * 
     * @param abucoderPrograms 推荐开源项目
     * @return 推荐开源项目集合
     */
    public List<AbucoderPrograms> selectAbucoderProgramsList(AbucoderPrograms abucoderPrograms);

    /**
     * 新增推荐开源项目
     * 
     * @param abucoderPrograms 推荐开源项目
     * @return 结果
     */
    public int insertAbucoderPrograms(AbucoderPrograms abucoderPrograms);

    /**
     * 修改推荐开源项目
     * 
     * @param abucoderPrograms 推荐开源项目
     * @return 结果
     */
    public int updateAbucoderPrograms(AbucoderPrograms abucoderPrograms);

    /**
     * 批量删除推荐开源项目
     * 
     * @param ids 需要删除的推荐开源项目主键集合
     * @return 结果
     */
    public int deleteAbucoderProgramsByIds(Long[] ids);

    /**
     * 删除推荐开源项目信息
     * 
     * @param id 推荐开源项目主键
     * @return 结果
     */
    public int deleteAbucoderProgramsById(Long id);
}
