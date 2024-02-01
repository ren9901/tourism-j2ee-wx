package com.tourism.abuwx.service;

import java.util.List;
import com.tourism.abuwx.domain.VxJingdianTable;

/**
 * 景区表Service接口
 * 
 * @author tourism
 * @date 2024-01-30
 */
public interface IVxJingdianTableService 
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

    public List<VxJingdianTable> selectVxJingdianTableListTop3(VxJingdianTable vxJingdianTable);
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

    public int operateDzVxJingdianTable(VxJingdianTable vxJingdianTable);

    public int operateScVxJingdianTable(VxJingdianTable vxJingdianTable, Long wxuserId);
    /**
     * 批量删除景区表
     * 
     * @param ids 需要删除的景区表主键集合
     * @return 结果
     */
    public int deleteVxJingdianTableByIds(Long[] ids);

    /**
     * 删除景区表信息
     * 
     * @param id 景区表主键
     * @return 结果
     */
    public int deleteVxJingdianTableById(Long id);

    /**
     * 获取用户收藏景区列表
     */
    public List<VxJingdianTable> selectVxJingdianTableByWxuserId(Long wxuserId);

    /**
     * 执行库存-1
     */
    public void updateKc(Long jingdianId);

}
