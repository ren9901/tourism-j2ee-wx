package com.tourism.abuwx.service.impl;

import java.util.List;
import com.tourism.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourism.abuwx.mapper.OrderTableMapper;
import com.tourism.abuwx.domain.OrderTable;
import com.tourism.abuwx.service.IOrderTableService;

/**
 * 订单Service业务层处理
 * 
 * @author tourism
 * @date 2024-01-30
 */
@Service
public class OrderTableServiceImpl implements IOrderTableService 
{
    @Autowired
    private OrderTableMapper orderTableMapper;

    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    @Override
    public OrderTable selectOrderTableById(Long id)
    {
        return orderTableMapper.selectOrderTableById(id);
    }

    /**
     * 查询订单列表
     * 
     * @param orderTable 订单
     * @return 订单
     */
    @Override
    public List<OrderTable> selectOrderTableList(OrderTable orderTable)
    {
        return orderTableMapper.selectOrderTableList(orderTable);
    }

    /**
     * 新增订单
     * 
     * @param orderTable 订单
     * @return 结果
     */
    @Override
    public int insertOrderTable(OrderTable orderTable)
    {
        orderTable.setCreateTime(DateUtils.getNowDate());
        return orderTableMapper.insertOrderTable(orderTable);
    }

    /**
     * 修改订单
     * 
     * @param orderTable 订单
     * @return 结果
     */
    @Override
    public int updateOrderTable(OrderTable orderTable)
    {
        orderTable.setUpdateTime(DateUtils.getNowDate());
        return orderTableMapper.updateOrderTable(orderTable);
    }

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteOrderTableByIds(Long[] ids)
    {
        return orderTableMapper.deleteOrderTableByIds(ids);
    }

    /**
     * 删除订单信息
     * 
     * @param id 订单主键
     * @return 结果
     */
    @Override
    public int deleteOrderTableById(Long id)
    {
        return orderTableMapper.deleteOrderTableById(id);
    }
}
