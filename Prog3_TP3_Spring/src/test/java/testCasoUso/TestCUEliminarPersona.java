package testCasoUso;


import casosDeUso.EliminarPersonaCU;
import exceptions.exceptionPersona.ExceptionPersona;
import exceptions.exceptionPersona.ExceptionPersonaNoEncontrada;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.IBuscarPersona;
import repositorio.IEliminarPersona;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestCUEliminarPersona {
    @Mock
    IEliminarPersona iEliminarPersona;
    @Mock
    IBuscarPersona iBuscarPersona;

    @Order(1)
    @Test
    public void test01_eliminarPersona_personaExiste_y_seEliminaCorrectamente()throws ExceptionPersona{
        //Arrange
        EliminarPersonaCU simulacro = new EliminarPersonaCU(iBuscarPersona,iEliminarPersona);

        //Act
        Mockito.when(iBuscarPersona.buscarPersonaPorDni("87966021")).thenReturn(true);
        Mockito.when(iEliminarPersona.darBajaPersona("87966021")).thenReturn(true);

        //Assert
        assertTrue(simulacro.darDeBajaPersona("87966021"));
    }

    @Order(2)
    @Test
    public void test02_eliminarPersona_personaExiste_y_falloEnBD()throws ExceptionPersona{
        //Arrange
        EliminarPersonaCU simulacro = new EliminarPersonaCU(iBuscarPersona,iEliminarPersona);

        //Act
        Mockito.when(iBuscarPersona.buscarPersonaPorDni("87966021")).thenReturn(true);
        Mockito.when(iEliminarPersona.darBajaPersona("87966021")).thenReturn(false);

        //Assert
        assertFalse(simulacro.darDeBajaPersona("87966021"));
    }

    @Order(3)
    @Test
    public void test03_eliminarPersona_personaNoExiste_exceptionPersonaNoEncontrada(){
        //Arrange
        EliminarPersonaCU simulacro = new EliminarPersonaCU(iBuscarPersona,iEliminarPersona);

        //Act
        Mockito.when(iBuscarPersona.buscarPersonaPorDni("87966021")).thenReturn(false);
        Mockito.verify(iEliminarPersona,Mockito.never()).darBajaPersona("87966021");

        //Assert
        assertThrows(ExceptionPersonaNoEncontrada.class,()-> simulacro.darDeBajaPersona("87966021"));
    }

}
