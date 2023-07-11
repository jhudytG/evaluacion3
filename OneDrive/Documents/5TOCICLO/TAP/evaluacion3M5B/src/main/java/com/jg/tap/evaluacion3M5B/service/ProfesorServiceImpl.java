/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jg.tap.evaluacion3M5B.service;

import com.jg.tap.evaluacion3M5B.model.Curso;
import com.jg.tap.evaluacion3M5B.model.Profesor;
import com.jg.tap.evaluacion3M5B.repository.CursoRepository;
import com.jg.tap.evaluacion3M5B.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhudy
 */
@Service
public class ProfesorServiceImpl  extends GenericServiceImpl<Profesor, Long> implements ProfesorService{

    @Autowired
    ProfesorRepository profesorRepository;
    
    @Override
    public CrudRepository<Profesor, Long> getDao() {
        return profesorRepository;
    }
    
}