package com.example.sprinjsp.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sprinjsp.modelo.Empleado;
import com.example.sprinjsp.modelo.Tarea;
import com.example.sprinjsp.servicio.IEmpleadoServicio;
import com.example.sprinjsp.servicio.ITareaServicio;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping

public class controlador {
    
    @Autowired
    private IEmpleadoServicio servicio;
    @Autowired
    private ITareaServicio servicio1; 

    @GetMapping("/listarEmpleados")
    public String listarEmpleados (Model model) {
        List<Empleado> empleados= servicio.listar();
        model.addAttribute("empleados", empleados);
        return "empleados";
    }
    @GetMapping("/agregarEmpleado")
    public String agregarEmpleado(Model model){
        model.addAttribute("empleado", new Empleado());
        return "agregarEmpleado";
    }
    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(Empleado p) {
        servicio.guardar(p);        
        return "redirect:/listarEmpleados";
    }

    @GetMapping("/editarEmpleado/{id}")
    public String editarEmpleado(@PathVariable int id, RedirectAttributes atributos){
        Optional<Empleado> empleado = servicio.listarId(id);
        atributos.addFlashAttribute("empleado", empleado);
        return "redirect:/mostrarEmpleado";
    }
    @GetMapping("/mostrarEmpleado")
    public String mostrarEmpleado(@ModelAttribute("empleado") Empleado p, Model model){
        model.addAttribute("empleado", p);
        return "agregarEmpleado";
    }

    @GetMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable int id){
        servicio.borrar(id);
        return "redirect:/listarEmpleados";
    }




    @GetMapping("/listarTareas")
    public String listarTareas(Model model) {
        List<Tarea> tareas = servicio1.listar();
        model.addAttribute("tareas", tareas);
        return "tareas"; 
    }

    @GetMapping("/agregarTarea")
    public String agregarTarea(Model model) {
        model.addAttribute("tarea", new Tarea()); 
        return "agregarTarea";
    }

    @PostMapping("/guardarTarea")
    public String guardarTarea(@ModelAttribute("tarea") Tarea p) { 
        servicio1.guardar(p);
        return "redirect:/listarTareas";
    }
    

    @GetMapping("/editarTarea/{id}")
    public String editarTarea(@PathVariable int id, RedirectAttributes atributos) {
        Optional<Tarea> tarea = servicio1.listarId(id); 
        atributos.addFlashAttribute("tarea", tarea); 
        return "redirect:/mostrarTarea"; 
    }

    @GetMapping("/mostrarTarea")
    public String mostrarTarea(@ModelAttribute("tarea") Tarea p, Model model) { 
        model.addAttribute("tarea", p); 
        return "agregarTarea"; 
    }

    @GetMapping("/eliminarTarea/{id}")
    public String eliminarTarea(@PathVariable int id) {
        servicio1.borrar(id);
        return "redirect:/listarTareas";
    }


    @GetMapping("/buscar")
    public String buscar(@RequestParam("tipo") String tipo, @RequestParam("q") String query, Model model) {
    if (tipo.equals("empleado")) {
        List<Empleado> empleadosEncontrados = servicio.buscarPorNombre(query);
        model.addAttribute("empleados", empleadosEncontrados);
        return "BuscarEmpleado"; 
    } else if (tipo.equals("tarea")) {
        List<Tarea> tareasEncontradas = servicio1.buscarPorDescripcion(query);
        model.addAttribute("tareas", tareasEncontradas);
        return "BuscarTarea"; 
    }
    return "error";
}

}
