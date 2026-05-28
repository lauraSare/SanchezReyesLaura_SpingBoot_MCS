package com.example.Proyecto_ABCC_MySQL.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.example.Proyecto_ABCC_MySQL.services.AlumnoService;
import com.example.Proyecto_ABCC_MySQL.models.AlumnoModel;
import java.util.List;

@Controller
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }

    @GetMapping("/")
    public String listaAlumnos(Model model){
        List<AlumnoModel> listaAlumnos = alumnoService.findAlumnos();
        model.addAttribute("alumnos", listaAlumnos);
        return "index";
    }

    @GetMapping("/nuevoAlumno")
    public String mostrarFormNuevo(Model model){
        model.addAttribute("alumno", new AlumnoModel());
        return "nuevoAlumno";
    }

    @PostMapping("/guardarAlumno")
    public String guardarAlumno(@ModelAttribute("alumno") AlumnoModel alumno){
        alumnoService.guardarAlumno(alumno);
        return "redirect:/";
    }

    @GetMapping("/editarAlumno/{id}")
    public String mostrarFormEditar(@PathVariable Integer id, Model model){
        model.addAttribute("alumno", alumnoService.findById(id));
        return "editarAlumno";
    }

    @GetMapping("/eliminarAlumno/{id}")
    public String eliminarAlumno(@PathVariable Integer id){
        alumnoService.eliminarAlumno(id);
        return "redirect:/";
    }
}