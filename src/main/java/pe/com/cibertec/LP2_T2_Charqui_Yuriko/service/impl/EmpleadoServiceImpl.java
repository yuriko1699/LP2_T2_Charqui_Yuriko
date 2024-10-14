package pe.com.cibertec.LP2_T2_Charqui_Yuriko.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.LP2_T2_Charqui_Yuriko.model.EmpleadoEntity;
import pe.com.cibertec.LP2_T2_Charqui_Yuriko.repository.EmpleadoRepository;
import pe.com.cibertec.LP2_T2_Charqui_Yuriko.service.EmpleadoService;

public class EmpleadoServiceImpl  implements EmpleadoService{
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public List<EmpleadoEntity> buscarEmpleado() {
		return empleadoRepository.findAll();
	}

	@Override
	public EmpleadoEntity buscarEmpleadoPorDNI(String dniempleado) {
		return empleadoRepository.findById(dniempleado).get();
	}

	@Override
	public Object crearEmpleado(EmpleadoEntity empleadoEntity) {
		return null;
		
	}

	@Override
	public Object actualizarEmpleado(String dniempleado, EmpleadoEntity empleadoEntity) {
		return null;
	}

	@Override
	public void eliminarEmpleado(String dniempleado) {
		EmpleadoEntity empleadoEncontrado = buscarEmpleadoPorDNI(dniempleado);
		if(empleadoEncontrado != null) {
			empleadoRepository.delete(empleadoEncontrado);
		}
	}

	@Override
	public EmpleadoEntity buscarPorCorreo(String correo) {
		return empleadoRepository.findByCorreo(correo);
	}

}
