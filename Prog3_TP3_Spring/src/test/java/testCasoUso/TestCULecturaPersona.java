package testCasoUso;

import casosDeUso.BuscarPersonaCU;
import dominio.Persona;
import exceptions.exceptionPersona.ExceptionPersona;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.ILeerPersona;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestCULecturaPersona {

    @Mock
    ILeerPersona ileerPersona;

    @Order(1)
    @Test
    public void test01_busquedaPersona_existeYesLeida()throws ExceptionPersona {
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona estaPersona = Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "89753122", 1.73, 56.31);

        //Act
        Mockito.when(ileerPersona.buscarPersonaPorDni("89753122")).thenReturn(true);

        BuscarPersonaCU simularBusqueda = new BuscarPersonaCU(ileerPersona);
        //Assert
        assertTrue(simularBusqueda.buscarPersona("89753122"));
    }

    @Order(2)
    @Test
    public void test02_busquedaPersona_personaNoExiste() throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona estaPersona = Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "89753122", 1.73, 56.31);

        //Act
        Mockito.when(ileerPersona.buscarPersonaPorDni("89753122")).thenReturn(false);

        BuscarPersonaCU simularBusqueda = new BuscarPersonaCU(ileerPersona);
        //Assert
        assertFalse(simularBusqueda.buscarPersona("89753122"));
    }
}
