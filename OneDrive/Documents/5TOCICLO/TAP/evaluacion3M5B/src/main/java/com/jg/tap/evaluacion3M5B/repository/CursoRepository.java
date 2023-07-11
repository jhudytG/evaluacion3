/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jg.tap.evaluacion3M5B.repository;

import com.jg.tap.evaluacion3M5B.model.Curso;
import com.jg.tap.evaluacion3M5B.model.Profesor;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author jhudy
 */
public interface CursoRepository extends MongoRepository<Curso, Long>{
     List<Curso> findByProfesor(Profesor profesor);
}