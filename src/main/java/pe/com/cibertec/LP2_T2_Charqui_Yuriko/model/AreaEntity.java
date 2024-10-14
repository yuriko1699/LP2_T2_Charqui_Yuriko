package pe.com.cibertec.LP2_T2_Charqui_Yuriko.model;

import jakarta.persistence.*;

@Entity
@Table (name = "tb_area")
public class AreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer areaId;

    @Column (name = "nombre_area", nullable = false,length = 45)
    private String nombreArea;

}
