package pe.com.cibertec.LP2_T2_Charqui_Yuriko.service;

import pe.com.cibertec.LP2_T2_Charqui_Yuriko.model.AreaEntity;
import pe.com.cibertec.LP2_T2_Charqui_Yuriko.model.EmpleadoEntity;

import java.util.List;

public interface AreaService {
    List<AreaEntity>listaArea();
    void crearArea(AreaEntity areaEntity);
}
