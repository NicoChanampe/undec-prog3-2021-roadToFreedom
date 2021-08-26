package testCasoUso;

import casosDeUso.ModificarPersonaCU;
import dominio.Persona;
import exceptions.exceptionPersona.ExceptionPersona;
import exceptions.exceptionPersona.ExceptionPersonaAlturaErronea;
import exceptions.exceptionPersona.ExceptionPersonaPesoErroneo;
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
    public void test01_modificarPesoPersona_pesoSeModificaCorrectamente()throws ExceptionPersona{
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

    @Order(2)
    @Test
    public void test02_modificarPesoPersona_pesoSeModifica_fallaBD()throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"87630115",1.69,59.7);
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //Act
        Mockito.when(iTraerPersona.damePersonaSegunDni("87630115")).thenReturn(nuevaPersona);
        nuevaPersona.setPeso(63.52);
        Mockito.when(iModificarPersona.modificarPeso(nuevaPersona)).thenReturn(false);
        //Assert
        assertEquals(63.52,nuevaPersona.getPeso());
        assertFalse(simulacro.modificarPesoPersona("87630115",63.52));
    }

    @Order(3)
    @Test
    public void test03_modificarPesoPersona_pesoNegativo_personaPesoNegativo()throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"87630115",1.69,59.7);
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //Act
        Mockito.verify(iTraerPersona,Mockito.never()).damePersonaSegunDni("87630115");
        Mockito.verify(iModificarPersona,Mockito.never()).modificarPeso(nuevaPersona);

        //Assert
        assertThrows(ExceptionPersonaPesoErroneo.class,()-> simulacro.modificarPesoPersona("87630115",-63.52));
    }

    @Order(4)
    @Test
    public void test04_modificarAlturaPersona_alturaSeModificaCorrectamente()throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"87630115",1.69,59.7);
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //Act
        Mockito.when(iTraerPersona.damePersonaSegunDni("87630115")).thenReturn(nuevaPersona);
        nuevaPersona.setAltura(1.8);
        Mockito.when(iModificarPersona.modificarAltura(nuevaPersona)).thenReturn(true);
        //Assert
        assertEquals(1.8,nuevaPersona.getAltura());
        assertTrue(simulacro.modificarAlturaPersona("87630115",1.8));
    }

    @Order(5)
    @Test
    public void test05_modificarAlturaPersona_alturaSeModifica_fallaBD()throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"87630115",1.69,59.7);
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //Act
        Mockito.when(iTraerPersona.damePersonaSegunDni("87630115")).thenReturn(nuevaPersona);
        nuevaPersona.setAltura(1.8);
        Mockito.when(iModificarPersona.modificarAltura(nuevaPersona)).thenReturn(false);
        //Assert
        assertEquals(1.8,nuevaPersona.getAltura());
        assertFalse(simulacro.modificarAlturaPersona("87630115",1.8));
    }

    @Order(6)
    @Test
    public void test06_modificarAlturaPersona_alturaErronea_personaAlturaNegativa()throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"87630115",1.69,59.7);
        ModificarPersonaCU simulacro = new ModificarPersonaCU(iTraerPersona,iModificarPersona);
        //Act
        Mockito.verify(iTraerPersona,Mockito.never()).damePersonaSegunDni("87630115");
        Mockito.verify(iModificarPersona,Mockito.never()).modificarAltura(nuevaPersona);
        //Assert
        assertThrows(ExceptionPersonaAlturaErronea.class,()-> simulacro.modificarAlturaPersona("87630115",-1.82));
    }
}
