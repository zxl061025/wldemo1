package com.ln.demo.equip.provider.system.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ln.demo.equip.api.system.dto.EquipDTO;
import com.ln.demo.equip.api.system.entity.Equip;
import com.ln.demo.equip.api.system.service.EquipService;
import com.ln.demo.common.data.Page;
import com.ln.demo.common.data.PageRequest;
import com.ln.demo.equip.provider.system.dao.EquipDAO;

/**
 * 角色服务实现类
 * 
 * @author Lining
 * @date 2017/10/27
 */
@Service("equipService")
public class EquipServiceImpl implements EquipService {

	@Autowired
	private EquipDAO equipDAO;
	

    /**
     * 得到设备列表
     * @param parameters
     * @param offset
     * @param limit
     * @return
     */
	@Override
    public Page<EquipDTO> listEquip(Map<String, Object> parameters, int offset, int limit) {
        int total = this.equipDAO.countEquip(parameters);
        List<EquipDTO> dtoList = null;
        if(total > 0) {
            PageRequest pageRequest = new PageRequest(offset, limit, parameters, null);
            List<Equip> list = this.equipDAO.listEquip(pageRequest);
            dtoList = new ArrayList<EquipDTO>(list.size());
            for(Equip equip : list) {
            	EquipDTO dto = new EquipDTO();
                BeanUtils.copyProperties(equip, dto);
                dtoList.add(dto);
            }
        }
        return new Page<EquipDTO>(total, dtoList);
    }
    
	/**
	 * 添加设备
	 * @param dto
	 * @return
	 */
    @Override
    @Transactional
    public EquipDTO saveEquip(EquipDTO dto) {
    	Equip equip = new Equip();
        BeanUtils.copyProperties(dto, equip);
        this.equipDAO.saveEquip(equip);
        dto.setId(equip.getId());
        return dto;
    }
    
    /**
     * 根据id得到设备
     * @param id
     * @return
     */
    @Override
    public EquipDTO getById(int id) {
    	Equip equip = this.equipDAO.getById(id);
        if(equip == null) {
            return null;
        }
        EquipDTO dto = new EquipDTO();
        BeanUtils.copyProperties(equip, dto);
        return dto;
    }
    
    /**
     * 更新设备
     * @param dto
     * @return
     */
    @Override
    @Transactional
    public int updateEquip(EquipDTO dto) {
    	Equip equip = new Equip();
        BeanUtils.copyProperties(dto, equip);
        return this.equipDAO.updateEquip(equip);
    }
    
    /**
     * 得到所有设备
     * @return
     */
    @Override
    public List<EquipDTO> listAllEquip() {
        List<Equip> list = this.equipDAO.listAllEquip();
        List<EquipDTO> dtoList = new ArrayList<EquipDTO>(list.size());
        for(Equip equip : list) {
        	EquipDTO dto = new EquipDTO();
            BeanUtils.copyProperties(equip, dto);
            dtoList.add(dto);
        }
        return dtoList;
    }
    
    /**
     * 删除设备
     * @param id
     * @return
     */
    @Override
    @Transactional
    public int removeEquip(int id) {
        int rows = this.equipDAO.removeEquip(id);
        return rows;
    }
    
   
    
}
