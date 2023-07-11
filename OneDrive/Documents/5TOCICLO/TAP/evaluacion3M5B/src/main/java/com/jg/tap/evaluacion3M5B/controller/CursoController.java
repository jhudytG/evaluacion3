/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jg.tap.evaluacion3M5B.controller;

import com.jg.tap.evaluacion3M5B.model.Curso;
import com.jg.tap.evaluacion3M5B.model.Profesor;
import com.jg.tap.evaluacion3M5B.service.CursoService;
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
@RequestMapping("/api/curso")
public class CursoController {
    @Autowired
    CursoService cursoService;
    
    @Autowired
    ProfesorService profesorService;

    @GetMapping("/listar")
    public ResponseEntity<List<Curso>> listarProductos() {
        return new ResponseEntity<>(cursoService.findByAll(), 
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Curso> crearProducto(@RequestBody Curso c,
            @RequestParam Long idProfesor) {
        Profesor profesor = profesorService.findById(idProfesor);
        if (profesor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            c.setProfesor(profesor);
            return new ResponseEntity<>(cursoService.save(c), 
                    HttpStatus.CREATED);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Curso> actualizarProducto(@PathVariable Long id,
            @RequestBody Curso c, @RequestParam Long idProfesor) {
        Curso cursoEncontrado = cursoService.findById(id);
        Profesor profesor = profesorService.findById(idProfesor);
        if (cursoEncontrado == null || profesor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                cursoEncontrado.setNombre(c.getNombre());
                cursoEncontrado.setNivel(c.getNivel());
                cursoEncontrado.setDescripcion(c.getDescripcion());
                cursoEncontrado.setProfesor(profesor);
                return new ResponseEntity<>(cursoService.save(cursoEncontrado), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Curso> eliminarProducto(@PathVariable Long id) {
        cursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
