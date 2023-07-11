/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jg.tap.evaluacion3M5B.controller;

import com.jg.tap.evaluacion3M5B.model.Departamento;
import com.jg.tap.evaluacion3M5B.model.Profesor;
import com.jg.tap.evaluacion3M5B.service.DepartamentoService;
import com.jg.tap.evaluacion3M5B.service.ProfesorService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhudy
 */
@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {
    @Autowired
    ProfesorService profesorService;

    @Autowired
    DepartamentoService departamentoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Profesor>> listarProfesores() {
        return new ResponseEntity<>(profesorService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor,
            @RequestParam Long idDepartamento) {
        Departamento departamento = departamentoService.findById(idDepartamento);
        if (departamento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            profesor.setDepartamento(departamento);
            return new ResponseEntity<>(profesorService.save(profesor), HttpStatus.CREATED);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable Long id,
            @RequestBody Profesor profesor, @RequestParam Long idDepartamento) {
        Profesor profesorEncontrado = profesorService.findById(id);
        Departamento departamento = departamentoService.findById(idDepartamento);
        if (profesorEncontrado == null || departamento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                profesorEncontrado.setNombre(profesor.getNombre());
                // Actualizar otros atributos del profesor
                profesorEncontrado.setDepartamento(departamento);
                return new ResponseEntity<>(profesorService.save(profesorEncontrado), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Profesor> eliminarProfesor(@PathVariable Long id) {
        profesorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
