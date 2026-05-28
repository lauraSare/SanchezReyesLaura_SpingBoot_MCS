package com.example.Proyecto_ABCC_MySQL.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AlumnoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numControl;
    private String nombre;
    private String primerAp;
    private String segundoAp;
    private String fechaNac;
    private Integer semestre;
    private String carrera;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNumControl() { return numControl; }
    public void setNumControl(String numControl) { this.numControl = numControl; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPrimerAp() { return primerAp; }
    public void setPrimerAp(String primerAp) { this.primerAp = primerAp; }

    public String getSegundoAp() { return segundoAp; }
    public void setSegundoAp(String segundoAp) { this.segundoAp = segundoAp; }

    public String getFechaNac() { return fechaNac; }
    public void setFechaNac(String fechaNac) { this.fechaNac = fechaNac; }

    public Integer getSemestre() { return semestre; }
    public void setSemestre(Integer semestre) { this.semestre = semestre; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }
}