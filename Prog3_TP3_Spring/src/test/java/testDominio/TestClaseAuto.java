package testDominio;

import dominio.Auto;
import exceptions.exceptionAuto.*;
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
        Auto nuevoAuto = Auto.factoryAuto(1,"Fiat","147","Blanco",1.1,"XYZ 134",3,1996);
        assertNotNull(nuevoAuto);
    }

    @Order(2)
    @Test
    public void test02_excepcionAuto_marcaNula(){
        assertThrows(ExceptionAutoAtributoNulo.class, ()-> Auto.factoryAuto(1,null,"147","Blanco",1.1,"XYZ 134",3,1996));
    }

    @Order(3)
    @Test
    public void test03_excepcionAuto_modeloNulo(){
        assertThrows(ExceptionAutoAtributoNulo.class, ()-> Auto.factoryAuto(1,"Fiat",null,"Blanco",1.1,"XYZ 134",3,1996));
    }

    @Order(4)
    @Test
    public void test04_excepcionAuto_colorNulo(){
        assertThrows(ExceptionAutoAtributoNulo.class, ()-> Auto.factoryAuto(1,"Fiat","147",null,1.1,"XYZ 134",3,1996));
    }

    @Order(5)
    @Test
    public void test05_excepcionAuto_patenteNula(){
        assertThrows(ExceptionAutoAtributoNulo.class, ()-> Auto.factoryAuto(1,"Fiat","147","blanco",1.1,null,3,1996));
    }

    @Order(6)
    @Test
    public void test06_excepcionAuto_marcaVacia(){
        assertThrows(ExceptionAutoAtributoVacia.class, ()-> Auto.factoryAuto(1,"","147","blanco",1.1,"XYZ 123",3,1996));
    }

    @Order(7)
    @Test
    public void test07_excepcionAuto_modeloVacio(){
        assertThrows(ExceptionAutoAtributoVacia.class, ()-> Auto.factoryAuto(1,"Fiat","","blanco",1.1,"XYZ 123",3,1996));
    }

    @Order(8)
    @Test
    public void test08_excepcionAuto_patenteVacia(){
        assertThrows(ExceptionAutoAtributoVacia.class, ()-> Auto.factoryAuto(1,"Fiat","147","blanco",1.1,"",3,1996));
    }

    @Order(9)
    @Test
    public void test09_excepcionAuto_cilindradaNegativa(){
        assertThrows(ExceptionAutoCilindradaNegativa.class, ()-> Auto.factoryAuto(1,"Fiat","147","blanco",-1.1,"XTZ 123",3,1996));
    }

    @Order(10)
    @Test
    public void test10_excepcionAuto_cantidadInvalida_de_puertas(){
        assertThrows(ExceptionAutoNumeroPuertasInvalido.class, ()-> Auto.factoryAuto(1,"Fiat","147","blanco",1.1,"XTZ 123",6,1996));
    }

    @Order(11)
    @Test
    public void test11_excepcionAuto_añoInvalido(){
        assertThrows(ExceptionAutoAñoInvalido.class, ()-> Auto.factoryAuto(1,"Fiat","147","blanco",1.1,"XTZ 123",5,1613));

        assertThrows(ExceptionAutoAñoInvalido.class, ()-> Auto.factoryAuto(1,"Fiat","147","blanco",1.1,"XTZ 123",5,4160));
    }
}