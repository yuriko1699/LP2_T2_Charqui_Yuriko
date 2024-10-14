package pe.com.cibertec.LP2_T2_Charqui_Yuriko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.cibertec.LP2_T2_Charqui_Yuriko.model.EmpleadoEntity;


public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, String> {
	EmpleadoEntity findByCorreo(String correo);
	
}

