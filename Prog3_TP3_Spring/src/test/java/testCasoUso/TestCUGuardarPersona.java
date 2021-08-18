package testCasoUso;


import casosDeUso.GuardarPersonaCU;
import dominio.Persona;
import exceptions.exceptionPersona.ExceptionPersona;
import exceptions.exceptionPersona.ExceptionPersonaExiste;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.IGuardarPersona;
import repositorio.ILeerPersona;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestCUGuardarPersona {
    @Mock
    ILeerPersona iLeerPersona;
    @Mock
    IGuardarPersona iGuardarPersona;

    @Order(1)
    @Test
    public void test01_guardarPersona_personaNoExisteYesGuardada() throws ExceptionPersona {
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "89753122", 1.73, 56.31);
        GuardarPersonaCU simularGuardarPeople = new GuardarPersonaCU(iGuardarPersona, iLeerPersona);

        //Act
        Mockito.when(iLeerPersona.buscarPersonaPorDni("89753122")).thenReturn(false);
        Mockito.when(iGuardarPersona.guardarPersona(nuevaPersona)).thenReturn(true);

        //assert
        assertTrue(simularGuardarPeople.cargarPersona(nuevaPersona));
    }

    @Order(2)
    @Test
    public void test02_guardarPersona_personaExiste_lanzaExcepcionPersonaExiste()throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "89753122", 1.73, 56.31);
        GuardarPersonaCU simularGuardarPeople = new GuardarPersonaCU(iGuardarPersona, iLeerPersona);

        //Act
        Mockito.when(iLeerPersona.buscarPersonaPorDni("89753122")).thenReturn(true);
        Mockito.verify(iGuardarPersona,Mockito.never()).guardarPersona(nuevaPersona);

        //Assert
        assertThrows(ExceptionPersonaExiste.class, () -> {
           simularGuardarPeople.cargarPersona(nuevaPersona);
        });
    }

    @Order(3)
    @Test
    public void test03_guardarPersona_personaNoExiste_y_errorEnBD() throws ExceptionPersona {
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "89753122", 1.73, 56.31);
        GuardarPersonaCU simularGuardarPeople = new GuardarPersonaCU(iGuardarPersona, iLeerPersona);

        //Act
        Mockito.when(iLeerPersona.buscarPersonaPorDni("89753122")).thenReturn(false);
        Mockito.when(iGuardarPersona.guardarPersona(nuevaPersona)).thenReturn(false);

        //assert
        assertFalse(simularGuardarPeople.cargarPersona(nuevaPersona));
    }

}
