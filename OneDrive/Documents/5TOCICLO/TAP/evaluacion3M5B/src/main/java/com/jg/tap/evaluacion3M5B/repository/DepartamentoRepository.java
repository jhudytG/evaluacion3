/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jg.tap.evaluacion3M5B.repository;

import com.jg.tap.evaluacion3M5B.model.Departamento;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author jhudy
 */
public interface DepartamentoRepository extends  MongoRepository<Departamento, Long>{
    
}
    
