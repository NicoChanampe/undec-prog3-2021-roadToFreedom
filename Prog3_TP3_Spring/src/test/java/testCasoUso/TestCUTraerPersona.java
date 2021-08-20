package testCasoUso;

import casosDeUso.TraerPersonaCU;
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
import repositorio.ITraerPersona;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestCUTraerPersona {
    @Mock
    ITraerPersona iTraerPersona;

    @Order(1)
    @Test
    public void test01_personaExiste_yEsTraida() throws ExceptionPersona {
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona otroGato = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"99884301",1.73,56.6);
        TraerPersonaCU simulacro = new TraerPersonaCU(iTraerPersona);

        //Act
        Mockito.when(iTraerPersona.damePersonaSegunDni("99884301")).thenReturn(otroGato);

        //Assert
        assertEquals(otroGato,simulacro.traerPersona("99884301"));
    }
}
