package com.tourism.abuwx.service.impl;

import com.tourism.abuwx.domain.VxJingdianTable;
import com.tourism.abuwx.domain.WxuserCollent;
import com.tourism.abuwx.mapper.VxJingdianTableMapper;
import com.tourism.abuwx.mapper.WxuserCollentMapper;
import com.tourism.abuwx.service.IVxJingdianTableService;
import com.tourism.common.exception.ServiceException;
import com.tourism.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 景区表Service业务层处理
 *
 * @author tourism
 * @date 2024-01-30
 */
@Service
public class VxJingdianTableServiceImpl implements IVxJingdianTableService {
    @Autowired
    private VxJingdianTableMapper vxJingdianTableMapper;

    @Autowired
    private WxuserCollentMapper wxuserCollentMapper;

    /**
     * 查询景区表
     *
     * @param id 景区表主键
     * @return 景区表
     */
    @Override
    public VxJingdianTable selectVxJingdianTableById(Long id) {
        return vxJingdianTableMapper.selectVxJingdianTableById(id);
    }

    /**
     * 查询景区表列表
     *
     * @param vxJingdianTable 景区表
     * @return 景区表
     */
    @Override
    public List<VxJingdianTable> selectVxJingdianTableList(VxJingdianTable vxJingdianTable) {
        return vxJingdianTableMapper.selectVxJingdianTableList(vxJingdianTable);
    }

    /**
     * 新增景区表
     *
     * @param vxJingdianTable 景区表
     * @return 结果
     */
    @Override
    public int insertVxJingdianTable(VxJingdianTable vxJingdianTable) {
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
    public int updateVxJingdianTable(VxJingdianTable vxJingdianTable) {
        vxJingdianTable.setUpdateTime(DateUtils.getNowDate());
        return vxJingdianTableMapper.updateVxJingdianTable(vxJingdianTable);
    }

    @Override
    public int operateDzVxJingdianTable(VxJingdianTable vxJingdianTable) {
        VxJingdianTable vo = vxJingdianTableMapper.selectVxJingdianTableById(vxJingdianTable.getId());
        int dznumInt = Integer.parseInt(vo.getDznum());
        dznumInt++;
        vxJingdianTable.setDznum(Integer.toString(dznumInt));
        vxJingdianTable.setUpdateTime(DateUtils.getNowDate());
        return vxJingdianTableMapper.operateDzVxJingdianTable(vxJingdianTable);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int operateScVxJingdianTable(VxJingdianTable vxJingdianTable, Long wxuserId) {
        // 收藏加入关联表
        WxuserCollent wxuserCollent = new WxuserCollent();
        wxuserCollent.setWxuserId(wxuserId);
        List<WxuserCollent> collentList = wxuserCollentMapper.selectWxuserCollentList(wxuserCollent);
        for (WxuserCollent collent : collentList) {
            if(collent.getJingdianId().equals(vxJingdianTable.getId())){
                throw new ServiceException("该景点已经收藏！");
            }
        }
        // 添加
        wxuserCollent.setJingdianId(vxJingdianTable.getId());
        wxuserCollentMapper.insertWxuserCollent(wxuserCollent);

        // 收藏数+1
        VxJingdianTable vo = vxJingdianTableMapper.selectVxJingdianTableById(vxJingdianTable.getId());
        int collectNumInt = Integer.parseInt(vo.getCollectNum());
        collectNumInt++;
        vxJingdianTable.setCollectNum(Integer.toString(collectNumInt));
        vxJingdianTable.setUpdateTime(DateUtils.getNowDate());
        return vxJingdianTableMapper.operateDzVxJingdianTable(vxJingdianTable);
    }

    /**
     * 批量删除景区表
     *
     * @param ids 需要删除的景区表主键
     * @return 结果
     */
    @Override
    public int deleteVxJingdianTableByIds(Long[] ids) {
        return vxJingdianTableMapper.deleteVxJingdianTableByIds(ids);
    }

    /**
     * 删除景区表信息
     *
     * @param id 景区表主键
     * @return 结果
     */
    @Override
    public int deleteVxJingdianTableById(Long id) {
        return vxJingdianTableMapper.deleteVxJingdianTableById(id);
    }

    /**
     * 获取用户收藏景区列表
     */
    @Override
    public List<VxJingdianTable> selectVxJingdianTableByWxuserId(Long wxuserId) {
        return vxJingdianTableMapper.selectVxJingdianTableByWxuserId(wxuserId);
    }

    /**
     * 执行库存-1
     */
    @Override
    public void updateKc(Long jingdianId) {
        VxJingdianTable vxJingdianVo = vxJingdianTableMapper.selectVxJingdianTableById(jingdianId);
        vxJingdianVo.setKucunNum(vxJingdianVo.getKucunNum()-1);
        vxJingdianTableMapper.updateVxJingdianTable(vxJingdianVo);
    }
}
