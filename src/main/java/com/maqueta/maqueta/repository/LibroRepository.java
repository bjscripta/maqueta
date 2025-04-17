package com.maqueta.maqueta.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.maqueta.maqueta.model.Libro;

@Repository //indica que la clase es un repositorio
public class LibroRepository {

    //crear una lista de la clase Libro llamada libros
    private List<Libro> libros = new ArrayList<>();

    //metodo que muestra todo los libros (OBTENER)
    public List<Libro> mostrarLibros(){
        return libros;
    }

    //busca libro por id
    public Libro buscarPorId(int id){
        for (Libro l : libros) {
            if(l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    //busca libro por isbn
    public Libro buscarPorIsbn(String isbn){
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    //agregar libro (GUARDAR)
    public Libro agregarLibro(Libro libro) { 
        libros.add(libro);
        return libro;
    }

    //actualizar un libro (ACTUALIZAR)
    public Libro actualizarLibro(Libro l){
        int id = 0;
        int posicion = 0;
        //recorre el tamaño de la lista buscando el libro
        for(int i = 0; i < libros.size(); i++){
            if(libros.get(i).getId() == l.getId()){
                id = l.getId();
                posicion = 1;
            }
        }

        //crea un libro con nuevos parametros
        Libro libro1 =  new Libro();
        libro1.setId(id);
        libro1.setTitulo(l.getTitulo());
        libro1.setAutor(l.getAutor());
        libro1.setFechaPublicacion(l.getFechaPublicacion());
        libro1.setEditorial(l.getEditorial());
        libro1.setIsbn(l.getIsbn());
        libros.set(posicion, libro1);
        return libro1;

    }

    //eliminar libro (ELIMINAR)
    public void eliminarLibro(int id){
        Libro libro =  buscarPorId(id);
        if(libro != null){
            libros.remove(libro);
        }
    }
}
