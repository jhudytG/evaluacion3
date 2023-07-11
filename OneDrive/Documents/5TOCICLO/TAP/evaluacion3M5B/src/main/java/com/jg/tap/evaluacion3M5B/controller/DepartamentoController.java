/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jg.tap.evaluacion3M5B.controller;

import com.jg.tap.evaluacion3M5B.model.Departamento;
import com.jg.tap.evaluacion3M5B.service.DepartamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhudy
 */
@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController {
    @Autowired
    DepartamentoService departamentoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Departamento>> listarDepartamentos() {
        return new ResponseEntity<>(departamentoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Departamento> crearDepartamento(@RequestBody Departamento departamento) {
        return new ResponseEntity<>(departamentoService.save(departamento), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Departamento> actualizarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
        Departamento departamentoEncontrado = departamentoService.findById(id);
        if (departamentoEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                departamentoEncontrado.setNombre(departamento.getNombre());
                departamentoEncontrado.setDirector(departamento.getDirector());
                departamentoEncontrado.setDescripcion(departamento.getDescripcion());
                return new ResponseEntity<>(departamentoService.save(departamentoEncontrado), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Departamento> eliminarDepartamento(@PathVariable Long id) {
        departamentoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}