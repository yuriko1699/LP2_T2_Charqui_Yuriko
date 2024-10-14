package pe.com.cibertec.LP2_T2_Charqui_Yuriko.service;

import pe.com.cibertec.LP2_T2_Charqui_Yuriko.model.EmpleadoEntity;

import java.util.List;

public interface EmpleadoService {
    List<EmpleadoEntity>buscarEmpleado();
    EmpleadoEntity buscarEmpleadoPorDNI (String dniempleado);
    void crearEmpleado(EmpleadoEntity empleadoEntity);
    void actualizarEmpleado (String dniempleado, EmpleadoEntity empleadoEntity);
    void eliminarEmpleado (String dniempleado);
    EmpleadoEntity buscarPorCorreo(String correo);

}
