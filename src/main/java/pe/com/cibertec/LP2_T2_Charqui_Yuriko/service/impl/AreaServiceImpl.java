package pe.com.cibertec.LP2_T2_Charqui_Yuriko.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.LP2_T2_Charqui_Yuriko.model.AreaEntity;
import pe.com.cibertec.LP2_T2_Charqui_Yuriko.repository.AreaRepository;
import pe.com.cibertec.LP2_T2_Charqui_Yuriko.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
	private AreaRepository areaRepository;
	
	@Override
	public List<AreaEntity> listaArea() {
		return areaRepository.findAll();
	}
	
	@Override
	public void crearArea(AreaEntity areaEntity) {
		areaRepository.save(areaEntity);
		
	}

}
