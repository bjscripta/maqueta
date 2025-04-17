package com.maqueta.maqueta.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.maqueta.maqueta.model.Libro;

@Repository //indica que la clase es un repositorio
public class LibroRepository {

    //crear una lista de la clase Libro llamada libros
    private List<Libro> libros = new ArrayList<>();

    public LibroRepository(){
        libros.add(new Libro(1, "9789569646638", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R. R. Martin"));
        libros.add(new Libro(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez"));
        libros.add(new Libro(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
        libros.add(new Libro(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
        libros.add(new Libro(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
        libros.add(new Libro(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
        libros.add(new Libro(7, "9780321127426", "Effective Java", "Addison-Wesley", 2008, "Joshua Bloch"));
        libros.add(new Libro(8, "9780134685991", "Clean Architecture", "PrenticeHall", 2017, "Robert C. Martin"));
        libros.add(new Libro(9, "9780201633610", "Design Patterns", "Addison-Wesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        libros.add(new Libro(10, "9780132350884", "TEST1", "bjm jr",2005, "bjOSAMA"));
    }

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

    //cuenta cuanto es el total de libros
    public int totalLibros(){
        return libros.size();
    }

    //buscar lib por año 
    public List<Libro> buscarPorAno(int año){
        List<Libro> librosPorAno = new ArrayList<>();
        for (Libro l : libros) {
            if (l.getFechaPublicacion() == año) {
                librosPorAno.add(l);
            }
        }
        return librosPorAno;
    }

    public List<Libro> buscarPorAutor(String autor){
        List<Libro> librosPorAutor = new ArrayList<>();
        for (Libro l : libros) {
            if(l.getAutor().equals(autor)){
                librosPorAutor.add(l);
            }
        }
        return librosPorAutor;
    }
    
}
