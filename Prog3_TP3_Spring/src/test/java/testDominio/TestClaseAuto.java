package testDominio;

import dominio.Auto;
import exceptions.exceptionAuto.ExceptionAuto;
import exceptions.exceptionAuto.ExceptionAutoAtributoNulo;
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
    public void test01_crearAutoCorrectamente()throws ExceptionAuto {
        Auto nuevoAuto = Auto.factoryAuto("Fiat","147","Blanco",1.1,"XYZ 134",3,1996);
        assertNotNull(nuevoAuto);
    }

    @Order(2)
    @Test
    public void test02_excepcionAuto_marcaNula(){
        assertThrows(ExceptionAutoAtributoNulo.class, ()-> {
            Auto nuevoAuto = Auto.factoryAuto(null,"147","Blanco",1.1,"XYZ 134",3,1996);
        });
    }

    @Order(3)
    @Test
    public void test03_excepcionAuto_modeloNulo(){
        assertThrows(ExceptionAutoAtributoNulo.class, ()-> {
            Auto nuevoAuto = Auto.factoryAuto("Fiat",null,"Blanco",1.1,"XYZ 134",3,1996);
        });
    }
}
