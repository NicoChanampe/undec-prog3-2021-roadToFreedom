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
    public void test02_crearAuto_colorVacioAutoCreadoCorrectamente()throws ExceptionAuto {
        Auto nuevoAuto = Auto.factoryAuto(1,"Fiat","147","",1.1,"XYZ 134",3,1996);
        assertNotNull(nuevoAuto);
    }
    @Order(3)
    @Test
    public void test03_creacionObjetoAuto_excepcionAtributoNulo(){
        assertThrows(ExceptionAutoAtributoNulo.class, ()-> Auto.factoryAuto(1,null,"147","Blanco",1.1,"XYZ 134",3,1996));

        assertThrows(ExceptionAutoAtributoNulo.class, ()-> Auto.factoryAuto(1,"Fiat",null,"Blanco",1.1,"XYZ 134",3,1996));

        assertThrows(ExceptionAutoAtributoNulo.class, ()-> Auto.factoryAuto(1,"Fiat","147",null,1.1,"XYZ 134",3,1996));

        assertThrows(ExceptionAutoAtributoNulo.class, ()-> Auto.factoryAuto(1,"Fiat","147","Blanco",null,"XYZ 134",3,1996));

        assertThrows(ExceptionAutoAtributoNulo.class, ()-> Auto.factoryAuto(1,"Fiat","147","Blanco",1.1,"XYZ 134",null,1996));

        assertThrows(ExceptionAutoAtributoNulo.class, ()-> Auto.factoryAuto(1,"Fiat","147","Blanco",1.1,null,3,1996));

        assertThrows(ExceptionAutoAtributoNulo.class, ()-> Auto.factoryAuto(1,"Fiat","147","Blanco",1.1,"XYZ 134",3,null));
    }

    @Order(4)
    @Test
    public void test04_creacionObjetoAuto_excepcionAtributoVacio(){
        assertThrows(ExceptionAutoAtributoVacia.class, ()-> Auto.factoryAuto(1,"","147","blanco",1.1,"XYZ 123",3,1996));

        assertThrows(ExceptionAutoAtributoVacia.class, ()-> Auto.factoryAuto(1,"Fiat","","blanco",1.1,"XYZ 123",3,1996));

        assertThrows(ExceptionAutoAtributoVacia.class, ()-> Auto.factoryAuto(1,"Fiat","147","blanco",1.1,"",3,1996));
    }

    @Order(5)
    @Test
    public void test05_creacionObjetoAuto_excepcionCilindradaNegativa(){
        assertThrows(ExceptionAutoCilindradaNegativa.class, ()-> Auto.factoryAuto(1,"Fiat","147","blanco",-1.1,"XTZ 123",3,1996));
    }

    @Order(6)
    @Test
    public void test06_creacionObjetoAuto_excepcionCantidadInvalida_de_puertas(){
        assertThrows(ExceptionAutoNumeroPuertasInvalido.class, ()-> Auto.factoryAuto(1,"Fiat","147","blanco",1.1,"XTZ 123",6,1996));
    }

    @Order(7)
    @Test
    public void test07_creacionObjetoAuto_excepcionAnioInvalido(){
        assertThrows(ExceptionAutoAñoInvalido.class, ()-> Auto.factoryAuto(1,"Fiat","147","blanco",1.1,"XTZ 123",5,1613));

        assertThrows(ExceptionAutoAñoInvalido.class, ()-> Auto.factoryAuto(1,"Fiat","147","blanco",1.1,"XTZ 123",5,4160));
    }

    @Order(8)
    @Test
    public void test08_actualizarDatosAuto_datosSeActualizan()throws ExceptionAuto{
        //Arrange
        Auto esteAuto = Auto.factoryAuto(1,"Fiat","147","Blanco",1.1,"XYZ 134",3,1996);
        Auto autoActualizado = Auto.factoryAuto(1,"Fiat","147","Azul",1.4,"XYZ 134",3,1996);

        //Act
        esteAuto.actualizarAuto(autoActualizado);

        //Assert
        assertEquals(autoActualizado.obtenerColor(),esteAuto.obtenerColor());
        assertEquals(autoActualizado.obtenerCilindrada(),esteAuto.obtenerCilindrada());
    }

    @Order(9)
    @Test
    public void test09_actualizarDatosAuto_pasamarcaModelo_y_colorCambiados_colorSeActualiza()throws ExceptionAuto{
        //Arrange
        Auto esteAuto = Auto.factoryAuto(1,"Fiat","147","",1.1,"XYZ 134",3,1996);
        Auto autoActualizado = Auto.factoryAuto(1,"Ferrari","360","Blanco",1.1,"XYZ 134",3,1996);

        //Act
        esteAuto.actualizarAuto(autoActualizado);

        //Assert
        assertEquals(autoActualizado.obtenerColor(),esteAuto.obtenerColor());
        assertEquals("Fiat",esteAuto.obtenerMarca());
        assertEquals("147",esteAuto.obtenerModelo());
    }
}