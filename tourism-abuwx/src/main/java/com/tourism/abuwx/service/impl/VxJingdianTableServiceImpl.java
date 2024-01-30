package com.tourism.abuwx.service.impl;

import java.util.List;
import com.tourism.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourism.abuwx.mapper.VxJingdianTableMapper;
import com.tourism.abuwx.domain.VxJingdianTable;
import com.tourism.abuwx.service.IVxJingdianTableService;

/**
 * 景区表Service业务层处理
 * 
 * @author tourism
 * @date 2024-01-30
 */
@Service
public class VxJingdianTableServiceImpl implements IVxJingdianTableService 
{
    @Autowired
    private VxJingdianTableMapper vxJingdianTableMapper;

    /**
     * 查询景区表
     * 
     * @param id 景区表主键
     * @return 景区表
     */
    @Override
    public VxJingdianTable selectVxJingdianTableById(Long id)
    {
        return vxJingdianTableMapper.selectVxJingdianTableById(id);
    }

    /**
     * 查询景区表列表
     * 
     * @param vxJingdianTable 景区表
     * @return 景区表
     */
    @Override
    public List<VxJingdianTable> selectVxJingdianTableList(VxJingdianTable vxJingdianTable)
    {
        return vxJingdianTableMapper.selectVxJingdianTableList(vxJingdianTable);
    }

    /**
     * 新增景区表
     * 
     * @param vxJingdianTable 景区表
     * @return 结果
     */
    @Override
    public int insertVxJingdianTable(VxJingdianTable vxJingdianTable)
    {
        vxJingdianTable.setCreateTime(DateUtils.getNowDate());
        return vxJingdianTableMapper.insertVxJingdianTable(vxJingdianTable);
    }

    /**
     * 修改景区表
     * 
     * @param vxJingdianTable 景区表
     * @return 结果
     */
    @Override
    public int updateVxJingdianTable(VxJingdianTable vxJingdianTable)
    {
        vxJingdianTable.setUpdateTime(DateUtils.getNowDate());
        return vxJingdianTableMapper.updateVxJingdianTable(vxJingdianTable);
    }

    /**
     * 批量删除景区表
     * 
     * @param ids 需要删除的景区表主键
     * @return 结果
     */
    @Override
    public int deleteVxJingdianTableByIds(Long[] ids)
    {
        return vxJingdianTableMapper.deleteVxJingdianTableByIds(ids);
    }

    /**
     * 删除景区表信息
     * 
     * @param id 景区表主键
     * @return 结果
     */
    @Override
    public int deleteVxJingdianTableById(Long id)
    {
        return vxJingdianTableMapper.deleteVxJingdianTableById(id);
    }
}
