package pe.com.cibertec.LP2_T2_Charqui_Yuriko.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "tb_empleado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoEntity {
    @Id
    @Column(name = "dni_empleado", nullable = false,columnDefinition = "CHAR(8)",
    length = 8,unique = true)
    private String dniempleado;

    @Column (name = "nombre_empleado", nullable = false, length = 45)
    private String nombre;

    @Column (name = "apellido_empleado", nullable = false, length = 45)
    private String apellido;

    @Column (name = "fecha_nacimiento", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @Column (name = "direccion", nullable = false, length = 45)
    private String direccion;

    @Column (name = "correo", nullable = false, length = 45)
    private String correo;

    @ManyToOne
    @JoinColumn (name = "area_id")
    private AreaEntity area;
}
