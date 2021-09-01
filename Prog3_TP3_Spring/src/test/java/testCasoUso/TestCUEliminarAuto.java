package testCasoUso;

import casosDeUso.EliminarAutoCU;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.IBuscarAuto;
import repositorio.IEliminarAuto;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestCUEliminarAuto {
    @Mock
    IBuscarAuto iBuscarAuto;
    @Mock
    IEliminarAuto iEliminarAuto;

    @Order(1)
    @Test
    public void test01_eliminarAuto_autoSeEliminaSinProblema(){
        //Arrange
        EliminarAutoCU simulacroEliminacion = new EliminarAutoCU(iEliminarAuto,iBuscarAuto);

        //Act
        Mockito.when(iBuscarAuto.buscarAutoByPatente("XYZ 123")).thenReturn(true);
        Mockito.when(iEliminarAuto.bajameAuto("XYZ 123")).thenReturn(true);

        //Assert
        assertTrue(simulacroEliminacion.darBajaAuto("XYZ 123"));
    }

    @Order(2)
    @Test
    public void test02_eliminarAuto_fallaBDretornaFalse(){
        //Arrange
        EliminarAutoCU simulacroEliminacion = new EliminarAutoCU(iEliminarAuto,iBuscarAuto);

        //Act
        Mockito.when(iBuscarAuto.buscarAutoByPatente("XYZ 123")).thenReturn(true);
        Mockito.when(iEliminarAuto.bajameAuto("XYZ 123")).thenReturn(false);

        //Assert
        assertFalse(simulacroEliminacion.darBajaAuto("XYZ 123"));
    }
}
