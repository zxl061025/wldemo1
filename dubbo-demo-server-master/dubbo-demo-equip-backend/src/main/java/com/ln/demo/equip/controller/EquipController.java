package com.ln.demo.equip.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ln.demo.equip.api.system.dto.EquipDTO;
import com.ln.demo.equip.api.system.service.EquipService;
import com.ln.demo.common.data.Page;
import com.ln.demo.vo.EquipDetailVO;
import com.ln.demo.vo.EquipListVO;

@RestController
@RequestMapping("/equips")
public class EquipController extends BaseController {
    
    @Autowired
    private EquipService equipService;
	
    @GetMapping("")
	public ResponseEntity<Page<EquipListVO>> getEquipList(@RequestParam(required = false) String name, 
	        int offset, int limit) {
        Map<String, Object> paremeters = new HashMap<String, Object>();
        if (!StringUtils.isBlank(name)) {
            paremeters.put("name", name);
        }
        Page<EquipDTO> result = this.equipService.listEquip(paremeters, offset, limit);
        List<EquipListVO> voList = new ArrayList<EquipListVO>();
        for(EquipDTO dto : result.getRows()) {
        	EquipListVO vo = new EquipListVO();
            BeanUtils.copyProperties(dto, vo);
            voList.add(vo);
        }
        return ResponseEntity.ok(new Page<EquipListVO>(result.getTotal(), voList));
	}
    
    @PostMapping("")
    public ResponseEntity<EquipDetailVO> saveEquip(@RequestBody EquipDetailVO vo) {
    	EquipDTO dto = new EquipDTO();
        BeanUtils.copyProperties(vo, dto);
        this.equipService.saveEquip(dto);
        vo.setId(dto.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(vo);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EquipDetailVO> getById(@PathVariable("id") int id) {
    	EquipDTO dto = this.equipService.getById(id);
        if(dto == null) {
            return ResponseEntity.notFound().build();
        }
        
        EquipDetailVO vo = new EquipDetailVO();
        BeanUtils.copyProperties(dto, vo);
        return ResponseEntity.ok(vo);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateEquip(@PathVariable("id") int id, @RequestBody EquipDetailVO vo) {
    	EquipDTO dto = new EquipDTO();
        BeanUtils.copyProperties(vo, dto);
        int rows = this.equipService.updateEquip(dto);
        return rows == 0 ? ResponseEntity.notFound().build() :
            ResponseEntity.status(HttpStatus.CREATED).body(rows);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<EquipListVO>> listAllEquip() {
        List<EquipDTO> dtoList = this.equipService.listAllEquip();
        if(dtoList.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        List<EquipListVO> voList = new ArrayList<EquipListVO>(dtoList.size());
        for(EquipDTO dto : dtoList) {
        	EquipListVO vo = new EquipListVO();
            BeanUtils.copyProperties(dto, vo);
            voList.add(vo);
        }
        return ResponseEntity.ok(voList);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeEquip(@PathVariable("id") int id) {
        return this.equipService.removeEquip(id) > 0 ?
                ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}