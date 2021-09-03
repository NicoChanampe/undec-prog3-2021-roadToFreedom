package dominio;

import exceptions.exceptionLibro.ExceptionLibro;
import exceptions.exceptionLibro.ExceptionLibroAtributoNulo;

public class Libro {
    private Long id;
    private String isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private Integer anioEdicion;
    private String paginas;
    private Double precio;

    private Libro(Long id, String isbn, String titulo, String autor, String editorial, Integer anioEdicion, String paginas, Double precio) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioEdicion = anioEdicion;
        this.paginas = paginas;
        this.precio = precio;
    }

    public static Libro factoryLibro(Long id, String isbn, String titulo, String autor, String editorial, Integer anioEdicion, String paginas, Double precio) throws ExceptionLibro {
        if(isbn == null || titulo == null || autor == null || editorial == null || anioEdicion == null || paginas == null || precio == null)
            throw new ExceptionLibroAtributoNulo("Ninguno de los campos puede ser nulo");
        if(paginas.equals("0"))
            paginas = "No descrito";
        if(autor.equals(""))
            autor = "Sin autor";
        return new Libro(id,isbn,titulo,autor,editorial,anioEdicion,paginas,precio);
    }

    public static Libro factoryLibro(Long id, String isbn, String titulo, String autor, String editorial, Integer anioEdicion, String paginas) throws ExceptionLibro{
        return factoryLibro(id,isbn,titulo,autor,editorial,anioEdicion,paginas,0.0);
    }

    public String obtenerCantidadPaginas() {
        return getPaginas();
    }

    public Double obtenerPrecio() {
        return getPrecio();
    }

    public String obtenerAutor() {
        return getAutor();
    }

    private String getPaginas() {
        return paginas;
    }

    private Double getPrecio() {
        return precio;
    }

    private String getAutor() {
        return autor;
    }
}
