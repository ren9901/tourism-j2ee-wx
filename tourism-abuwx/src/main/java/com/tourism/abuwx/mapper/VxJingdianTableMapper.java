package com.tourism.abuwx.mapper;

import java.util.List;
import com.tourism.abuwx.domain.VxJingdianTable;

/**
 * 景区表Mapper接口
 * 
 * @author tourism
 * @date 2024-01-30
 */
public interface VxJingdianTableMapper 
{
    /**
     * 查询景区表
     * 
     * @param id 景区表主键
     * @return 景区表
     */
    public VxJingdianTable selectVxJingdianTableById(Long id);

    /**
     * 查询景区表列表
     * 
     * @param vxJingdianTable 景区表
     * @return 景区表集合
     */
    public List<VxJingdianTable> selectVxJingdianTableList(VxJingdianTable vxJingdianTable);

    /**
     * 新增景区表
     * 
     * @param vxJingdianTable 景区表
     * @return 结果
     */
    public int insertVxJingdianTable(VxJingdianTable vxJingdianTable);

    /**
     * 修改景区表
     * 
     * @param vxJingdianTable 景区表
     * @return 结果
     */
    public int updateVxJingdianTable(VxJingdianTable vxJingdianTable);

    /**
     * 删除景区表
     * 
     * @param id 景区表主键
     * @return 结果
     */
    public int deleteVxJingdianTableById(Long id);

    /**
     * 批量删除景区表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVxJingdianTableByIds(Long[] ids);
}
