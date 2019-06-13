package com.ln.demo.equip.api.system.service;

import java.util.List;
import java.util.Map;

import com.ln.demo.common.data.Page;
import com.ln.demo.equip.api.system.dto.EquipDTO;

/**
 * 角色服务接口
 * 
 * @author Lining
 * @date 2017/10/27
 */
public interface EquipService {

	/**
	 * 得到设备列表
	 * @param paremeters
	 * @param offset
	 * @param limit
	 * @return
	 */
	Page<EquipDTO> listEquip(Map<String, Object> paremeters, int offset, int limit);
	
	/**
	 * 添加设备
	 * @param dto
	 * @return
	 */
	EquipDTO saveEquip(EquipDTO dto);
	
	/**
	 * 根据id得到设备
	 * @param id
	 * @return
	 */
	EquipDTO getById(int id);
	
	/**
	 * 更新设备
	 * @param dto
	 * @return
	 */
	int updateEquip(EquipDTO dto);
	
	/**
	 * 得到所有设备
	 * @return
	 */
	List<EquipDTO> listAllEquip();
	
	/**
	 * 删除设备
	 * @param id
	 * @return
	 */
	int removeEquip(int id);
    
   

}
