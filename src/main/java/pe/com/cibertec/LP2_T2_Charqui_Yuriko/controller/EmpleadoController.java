package pe.com.cibertec.LP2_T2_Charqui_Yuriko.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.cibertec.LP2_T2_Charqui_Yuriko.model.AreaEntity;
import pe.com.cibertec.LP2_T2_Charqui_Yuriko.model.EmpleadoEntity;
import pe.com.cibertec.LP2_T2_Charqui_Yuriko.service.AreaService;
import pe.com.cibertec.LP2_T2_Charqui_Yuriko.service.EmpleadoService;

import java.util.List;

public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private AreaService areaService;

    @GetMapping ("/")
    public String listarEmpleado (Model model){
        List<EmpleadoEntity>listaEmpleado = empleadoService.buscarEmpleado();
        model.addAttribute("listaemple", listaEmpleado);
        return "listar_empleado";
    }
    @GetMapping("/registrar_empleado")
    public String mostrarRegistrarEmpleado(Model model){
        List<AreaEntity> listarArea = areaService.listaArea();
        model.addAttribute("area", listarArea);
        model.addAttribute("empleado", new EmpleadoEntity());
        return "registrar_empleado";
    }

    @PostMapping("/registrar_empleado")
    public String registrarEmpleado(@ModelAttribute("empleado")EmpleadoEntity user, Model model) {
        empleadoService.crearEmpleado(user);
        if (empleadoService.buscarPorCorreo(user.getCorreo()) != null) {
            model.addAttribute("errorMessage", "El correo ya existe, usar otro");
            model.addAttribute("user", user);
            return "registrar_empleado";
        }
        empleadoService.crearEmpleado(user);
        return "redirect:/";
    }
    

    @GetMapping("/editar_empleado/{dni_empleado}")
    public String mostrarEditarEmpleado (@PathVariable("dni_empleado") String dniempleado, Model model){
        EmpleadoEntity empleadoEncontrado = empleadoService.buscarEmpleadoPorDNI(dniempleado);
        model.addAttribute("user", empleadoEncontrado);
        return "editar_empleado";
    }
    @PostMapping("/editar_empleado/{dni_empleado}")
        public String editarEmpleado (@PathVariable("dni_empleado") String dniempleado,
        @ModelAttribute("user") EmpleadoEntity user, Model model){
            empleadoService.actualizarEmpleado(dniempleado, user);
            return "redirect:/";
        }
    @GetMapping("/delete/{dniempleado}")
    public String deleteEmpleado(@PathVariable("dniempleado")String dniempleado){
        empleadoService.eliminarEmpleado(dniempleado);
        return "redirect:/";
    }
    @GetMapping("/detalle_empleado/{dniempleado}")
    public String verdetalle(Model model, @PathVariable("dniempleado")String dniempleado){
            EmpleadoEntity empleadoEncontrado = empleadoService.buscarEmpleadoPorDNI (dniempleado);
            model.addAttribute("user",empleadoEncontrado);
            return "redirect:/";
    }
}
