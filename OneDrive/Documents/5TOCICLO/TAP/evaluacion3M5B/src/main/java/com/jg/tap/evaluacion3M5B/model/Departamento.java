/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jg.tap.evaluacion3M5B.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jhudy
 */
@Document(collation = "Departamento")
@Data
public class Departamento {
    @Id
    private Long id;
    private String nombre;
    private String director;
    private String descripcion;
    
}
