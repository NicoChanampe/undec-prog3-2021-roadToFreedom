package testDominio;

import dominio.Auto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestClaseAuto {
    @Order(1)
    @Test
    public void test01_crearAutoCorrectamente(){
        Auto nuevoAuto = Auto.factoryAuto("Fiat","147","Blanco",1.1,"XYZ 134",3,1996);
        assertNotNull(nuevoAuto);
    }
}
