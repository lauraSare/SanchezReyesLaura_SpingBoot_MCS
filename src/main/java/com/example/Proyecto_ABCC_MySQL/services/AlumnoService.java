package com.example.Proyecto_ABCC_MySQL.services;

import org.springframework.stereotype.Service;
import com.example.Proyecto_ABCC_MySQL.models.AlumnoModel;
import com.example.Proyecto_ABCC_MySQL.repositories.AlumnoRepository;
import java.util.List;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
    }

    public List<AlumnoModel> findAlumnos(){
        return alumnoRepository.findAll();
    }

    public void guardarAlumno(AlumnoModel alumno){
        alumnoRepository.save(alumno);
    }

    public AlumnoModel findById(Integer id){
        return alumnoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Alumno no encontrado, id: " + id));
    }

    public void eliminarAlumno(Integer id){
        alumnoRepository.deleteById(id);
    }
}