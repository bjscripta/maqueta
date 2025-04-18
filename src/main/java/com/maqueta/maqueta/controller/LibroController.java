package com.maqueta.maqueta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maqueta.maqueta.model.Libro;
import com.maqueta.maqueta.services.LibroService;


@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros(){
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro){
        return libroService.saveLibro(libro);
    }

    @GetMapping("/{id}")
    public Libro buscarLibro(@PathVariable int id){
        return libroService.getLibro(id);
    }   

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro){
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("/{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.deleteLibro(id);
    }

    @GetMapping("/total")
    public int totalLibrosv2(){
        return libroService.totalLibros();
    }

    @GetMapping("/isbn/{isbn}")
    public Libro buscarLibroPorIsbn(@PathVariable String isbn){
        return libroService.buscarLibroPorIsbn(isbn);
    }

    @GetMapping("/ano/{año}")
    public List<Libro> buscarLibrosPorAno(@PathVariable int año){
        return libroService.buscarLibrosPorAno(año);
    }

    @GetMapping("/autor/{autor}")
    public List<Libro> buscarLibrosPorAutor(@PathVariable String autor) {
        return libroService.buscarLibrosPorAutor(autor);
    }

}
