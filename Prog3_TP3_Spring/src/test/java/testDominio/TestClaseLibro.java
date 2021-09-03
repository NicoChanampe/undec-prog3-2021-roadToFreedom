package testDominio;

import dominio.Libro;
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
    public void test01_creacionLibro_datosCorrectosyCompletos_libroCreado(){
        Libro nuevoLibro = Libro.factoryLibro(1L, "1530-1113-5004-4","Las Crónicas de Narnia: El Principe Caspian", "J. C. Lewis", "LA NACION", 2008,"280",650.59);
        assertNotNull(nuevoLibro);
    }

    @Order(2)
    @Test
    public void test02_creacionLibro_paginaIgualACero_libroCreado(){
        Libro nuevoLibro = Libro.factoryLibro(1L, "1530-1113-5004-4","Las Crónicas de Narnia: El Principe Caspian", "J. C. Lewis", "LA NACION", 2008,"0",650.59);
        assertNotNull(nuevoLibro);
        assertEquals("No descrito",nuevoLibro.obtenerCantidadPaginas());
    }

    @Order(3)
    @Test
    public void test03_creacionLibro_sinPrecio_libroCreado(){
        Libro nuevoLibro = Libro.factoryLibro(1L, "1530-1113-5004-4","Las Crónicas de Narnia: El Principe Caspian", "J. C. Lewis", "LA NACION", 2008,"0");
        assertNotNull(nuevoLibro);
        assertEquals(0.0,nuevoLibro.obtenerPrecio());
    }
}
