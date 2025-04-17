package com.maqueta.maqueta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Genera getters, setters, ToString , equals, hashCode y constructor
@AllArgsConstructor //Genera constructor con todos los campos
@NoArgsConstructor // Genera constructor vacio

public class Libro {

    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int fechaPublicacion;
    private String autor;

}
