package testCasoUso;

import casosDeUso.ModificarPersonaCU;
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
import repositorio.IModificarPersona;
import repositorio.ITraerPersona;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestCUModificarPersona {
    @Mock
    ITraerPersona iTraerPersona;
    @Mock
    IModificarPersona iModificarPersona;

    @Order(1)
    @Test
    public void test01_modificarPersona_pesoSeModificaCorrectamente()throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"87630115",1.69,59.7);
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //Act
        Mockito.when(iTraerPersona.damePersonaSegunDni("87630115")).thenReturn(nuevaPersona);
        nuevaPersona.setPeso(63.52);
        Mockito.when(iModificarPersona.modificarPeso(nuevaPersona)).thenReturn(true);
        //Assert
        assertEquals(63.52,nuevaPersona.getPeso());
        assertTrue(simulacro.modificarPesoPersona("87630115",63.52));

    }
}
