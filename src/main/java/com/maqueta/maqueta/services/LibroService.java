package com.maqueta.maqueta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maqueta.maqueta.model.Libro;
import com.maqueta.maqueta.repository.LibroRepository;

@Service //se usa para definir una clase como una capa de negocio
public class LibroService {

    @Autowired //inyecta automaticamente las dependencias en spring
    private LibroRepository libroRepository;

    public List<Libro> getLibros(){
        return libroRepository.mostrarLibros();
    }

    public Libro saveLibro(Libro libro){
        return libroRepository.agregarLibro(libro);
    }

    public Libro getLibro(int id){
        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro){
        return libroRepository.actualizarLibro(libro);
    }

    public String deleteLibro(int id){
        libroRepository.eliminarLibro(id);
        return "Producto eliminado";
    }

    public int totalLibros(){
        return libroRepository.mostrarLibros().size();
    }

    public Libro buscarLibroPorIsbn(String isbn){
        return libroRepository.buscarPorIsbn(isbn);
    }

    public List<Libro> buscarLibrosPorAno(int año){
        return libroRepository.buscarPorAno(año);
    }
    
    public List<Libro> buscarLibrosPorAutor(String autor){
        return libroRepository.buscarPorAutor(autor);
    }
}
