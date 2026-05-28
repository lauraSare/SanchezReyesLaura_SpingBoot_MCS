package com.example.Proyecto_ABCC_MySQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Proyecto_ABCC_MySQL.models.AlumnoModel;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoModel, Integer> {

}