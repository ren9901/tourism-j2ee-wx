package com.tourism.abuwx.service;

import java.util.List;
import com.tourism.abuwx.domain.OrderTable;

/**
 * 订单Service接口
 * 
 * @author tourism
 * @date 2024-01-30
 */
public interface IOrderTableService 
{
    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    public OrderTable selectOrderTableById(Long id);

    /**
     * 查询订单列表
     * 
     * @param orderTable 订单
     * @return 订单集合
     */
    public List<OrderTable> selectOrderTableList(OrderTable orderTable);

    /**
     * 新增订单
     * 
     * @param orderTable 订单
     * @return 结果
     */
    public int insertOrderTable(OrderTable orderTable);

    /**
     * 修改订单
     * 
     * @param orderTable 订单
     * @return 结果
     */
    public int updateOrderTable(OrderTable orderTable);

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单主键集合
     * @return 结果
     */
    public int deleteOrderTableByIds(Long[] ids);

    /**
     * 删除订单信息
     * 
     * @param id 订单主键
     * @return 结果
     */
    public int deleteOrderTableById(Long id);
}
