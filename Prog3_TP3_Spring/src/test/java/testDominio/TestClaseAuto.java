package testDominio;

import dominio.Auto;
import exceptions.exceptionAuto.ExceptionAuto;
import exceptions.exceptionAuto.ExceptionAutoAtributoNulo;
import exceptions.exceptionAuto.ExceptionAutoAtributoVacia;
import exceptions.exceptionAuto.ExceptionAutoCilindradaNegativa;
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

    @Order(4)
    @Test
    public void test04_excepcionAuto_colorNulo(){
        assertThrows(ExceptionAutoAtributoNulo.class, ()-> {
            Auto nuevoAuto = Auto.factoryAuto("Fiat","147",null,1.1,"XYZ 134",3,1996);
        });
    }

    @Order(5)
    @Test
    public void test05_excepcionAuto_patenteNula(){
        assertThrows(ExceptionAutoAtributoNulo.class, ()-> {
            Auto nuevoAuto = Auto.factoryAuto("Fiat","147","blanco",1.1,null,3,1996);
        });
    }

    @Order(6)
    @Test
    public void test06_excepcionAuto_marcaVacia(){
        assertThrows(ExceptionAutoAtributoVacia.class, ()-> {
            Auto nuevoAuto = Auto.factoryAuto("","147","blanco",1.1,"XYZ 123",3,1996);
        });
    }

    @Order(7)
    @Test
    public void test07_excepcionAuto_modeloVacio(){
        assertThrows(ExceptionAutoAtributoVacia.class, ()-> {
            Auto nuevoAuto = Auto.factoryAuto("Fiat","","blanco",1.1,"XYZ 123",3,1996);
        });
    }

    @Order(8)
    @Test
    public void test08_excepcionAuto_patenteVacia(){
        assertThrows(ExceptionAutoAtributoVacia.class, ()-> {
            Auto nuevoAuto = Auto.factoryAuto("Fiat","147","blanco",1.1,"",3,1996);
        });
    }

    @Order(9)
    @Test
    public void test09_excepcionAuto_cilindradaNegativa(){
        assertThrows(ExceptionAutoCilindradaNegativa.class, ()-> {
            Auto nuevoAuto = Auto.factoryAuto("Fiat","147","blanco",-1.1,"XTZ 123",3,1996);
        });
    }
}