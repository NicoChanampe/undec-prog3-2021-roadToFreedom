package testDominio;

import dominio.Libro;
import exceptions.exceptionLibro.ExceptionLibro;
import exceptions.exceptionLibro.ExceptionLibroAtributoNulo;
import exceptions.exceptionLibro.ExceptionLibroAtributoVacio;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestClaseLibro {
    @Order(1)
    @Test
    public void test01_creacionLibro_datosCorrectosyCompletos_libroCreado()throws ExceptionLibro{
        Libro nuevoLibro = Libro.factoryLibro(1L, "1530-1113-5004-4","Las Crónicas de Narnia: El Principe Caspian", "J. C. Lewis", "LA NACION", 2008,"280",650.59);
        assertNotNull(nuevoLibro);
    }

    @Order(2)
    @Test
    public void test02_creacionLibro_paginaIgualACero_libroCreado()throws ExceptionLibro{
        Libro nuevoLibro = Libro.factoryLibro(1L, "1530-1113-5004-4","Las Crónicas de Narnia: El Principe Caspian", "J. C. Lewis", "LA NACION", 2008,"0",650.59);
        assertNotNull(nuevoLibro);
        assertEquals("No descrito",nuevoLibro.obtenerCantidadPaginas());
    }

    @Order(3)
    @Test
    public void test03_creacionLibro_sinPrecio_libroCreado()throws ExceptionLibro{
        Libro nuevoLibro = Libro.factoryLibro(1L, "1530-1113-5004-4","Las Crónicas de Narnia: El Principe Caspian", "J. C. Lewis", "LA NACION", 2008,"0");
        assertNotNull(nuevoLibro);
        assertEquals(0.0,nuevoLibro.obtenerPrecio());
    }

    @Order(4)
    @Test
    public void test04_creacionLibro_autorVacio_libroCreado()throws ExceptionLibro {
        Libro nuevoLibro = Libro.factoryLibro(1L, "1530-1113-5004-4","Claves para aprobar programacion 3", "", "UNdeC", 2021,"125",430.69);
        assertNotNull(nuevoLibro);
        assertEquals("Sin autor",nuevoLibro.obtenerAutor());
    }

    @Order(5)
    @Test
    public void test05_creacionLibro_algunAtributoNulo_excepcionLibroAtributoNulo(){
        assertThrows(ExceptionLibroAtributoNulo.class,()->Libro.factoryLibro(1L, null,"Claves para aprobar programacion 3", "", "UNdeC", 2021,"125",430.69));

        assertThrows(ExceptionLibroAtributoNulo.class,()->Libro.factoryLibro(1L, "1530-1113-5004-4",null, "", "UNdeC", 2021,"125",430.69));

        assertThrows(ExceptionLibroAtributoNulo.class,()->Libro.factoryLibro(1L, "1530-1113-5004-4","Claves para aprobar programacion 3", null, "UNdeC", 2021,"125",430.69));

        assertThrows(ExceptionLibroAtributoNulo.class,()->Libro.factoryLibro(1L, "1530-1113-5004-4","Claves para aprobar programacion 3", "", null, 2021,"125",430.69));

        assertThrows(ExceptionLibroAtributoNulo.class,()->Libro.factoryLibro(1L, "1530-1113-5004-4","Claves para aprobar programacion 3", "", "UNdeC", null,"125",430.69));

        assertThrows(ExceptionLibroAtributoNulo.class,()->Libro.factoryLibro(1L, "1530-1113-5004-4","Claves para aprobar programacion 3", "", "UNdeC", 2021,null,430.69));

        assertThrows(ExceptionLibroAtributoNulo.class,()->Libro.factoryLibro(1L, "1530-1113-5004-4","Claves para aprobar programacion 3", "", "UNdeC", 2021,"125",null));
    }

    @Order(6)
    @Test
    public void test06_creacionLibro_isbnVacio_exceptionLibroAtributoVacio(){
        assertThrows(ExceptionLibroAtributoVacio.class,()-> Libro.factoryLibro(1L, "","Claves para aprobar programacion 3", "", "UNdeC", 2021,"125",430.69));
    }
}
