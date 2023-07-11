/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jg.tap.evaluacion3M5B.service;

import com.jg.tap.evaluacion3M5B.model.Departamento;
import com.jg.tap.evaluacion3M5B.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhudy
 */
@Service
public class DepartamentoServiceImpl extends GenericServiceImpl<Departamento, Long> implements DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Override
    public CrudRepository<Departamento, Long> getDao() {
        return departamentoRepository;
    }

}
