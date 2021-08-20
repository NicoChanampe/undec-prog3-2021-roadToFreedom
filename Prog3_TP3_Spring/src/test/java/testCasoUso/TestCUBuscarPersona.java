package testCasoUso;

import casosDeUso.BuscarPersonaCU;
import exceptions.exceptionPersona.ExceptionPersona;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.IBuscarPersona;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestCUBuscarPersona {

    @Mock
    IBuscarPersona ileerPersona;

    @Order(1)
    @Test
    public void test01_busquedaPersona_existeYesLeida()throws ExceptionPersona {
        //Arrange
        BuscarPersonaCU simularBusqueda = new BuscarPersonaCU(ileerPersona);

        //Act
        Mockito.when(ileerPersona.buscarPersonaPorDni("89753122")).thenReturn(true);

        //Assert
        assertTrue(simularBusqueda.buscarPersona("89753122"));
    }

    @Order(2)
    @Test
    public void test02_busquedaPersona_personaNoExiste() throws ExceptionPersona{
        //Arrange
        BuscarPersonaCU simularBusqueda = new BuscarPersonaCU(ileerPersona);

        //Act
        Mockito.when(ileerPersona.buscarPersonaPorDni("89753122")).thenReturn(false);

        //Assert
        assertFalse(simularBusqueda.buscarPersona("89753122"));
    }
}
