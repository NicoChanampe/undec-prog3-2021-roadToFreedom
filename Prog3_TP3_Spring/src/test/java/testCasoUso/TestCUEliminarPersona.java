package testCasoUso;

import casosDeUso.BuscarPersonaCU;
import casosDeUso.EliminarPersonaCU;
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
    public void test01_eliminarPersona_personaExiste_y_seEliminaCorrectamente(){
        //Arrange
        EliminarPersonaCU simulacro = new EliminarPersonaCU(iBuscarPersona,iEliminarPersona);

        //Act
        Mockito.when(iBuscarPersona.buscarPersonaPorDni("87966021")).thenReturn(true);
        Mockito.when(iEliminarPersona.darBajaPersona("87966021")).thenReturn(true);

        //Assert
        assertTrue(simulacro.darDeBajaPersona("87966021"));
    }

}
