package com.ln.demo.equip.provider.system.dao;

import java.util.List;
import java.util.Map;

import com.ln.demo.equip.api.system.entity.Equip;
import com.ln.demo.common.data.PageRequest;

/**
 * 角色DAO接口
 * 
 * @author Lining
 * @date 2017/10/27
 */
public interface EquipDAO {

    /**
     * 统计设备数
     * 
     * @param condition
     *            查询条件
     * @return
     */
    int countEquip (Map<String, Object> parameters);

    /**
     * 分页查询设备信息
     * 
     * @param pageRequest
     *            分页请求参数
     * @return
     */
    List<Equip> listEquip(PageRequest pageRequest);
    
    /**
     * 添加设备
     * @param role
     */
    void saveEquip(Equip equip);
    
    /**
     * 根据id得到设备
     * @param id
     * @return
     */
    Equip getById(int id);
    
    /**
     * 更新设备
     * @param role
     * @return
     */
    int updateEquip(Equip equip);
    
    /**
     * 删除设备
     * @param id
     * @return
     */
    int removeEquip(int id);
    
    /**
     * 得到所有设备
     * @return
     */
    List<Equip> listAllEquip();

}
