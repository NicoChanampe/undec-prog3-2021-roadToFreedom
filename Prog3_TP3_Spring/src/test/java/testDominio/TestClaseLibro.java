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
    public void test_creacionLibro_datosCorrectosyCompletos_libroCreado(){
        Libro nuevoLibro = Libro.factoryLibro(1L, "1530-1113-5004-4","Las Crónicas de Narnia: El Principe Caspian", "J. C. Lewis", "LA NACION", 2008,"280",650.59);
        assertNotNull(nuevoLibro);
    }


}
