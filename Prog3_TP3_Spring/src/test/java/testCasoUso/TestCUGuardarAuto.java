package testCasoUso;

import casosDeUso.GuardarAutoCU;
import dominio.Auto;
import exceptions.exceptionAuto.ExceptionAuto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.IBuscarAuto;
import repositorio.IGuardarAuto;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestCUGuardarAuto {
    @Mock
    IBuscarAuto iBuscarAuto;
    @Mock
    IGuardarAuto iGuardarAuto;

    @Order(1)
    @Test
    public void test01_guardarAuto_autoNoExiste_y_esGuardado()throws ExceptionAuto {
        Auto maquinaDelMal = Auto.factoryAuto("Ford","Mustang","Gris",5.0,"cincinatty",3,1969);
        GuardarAutoCU simulacro = new GuardarAutoCU(iGuardarAuto,iBuscarAuto);

        Mockito.when(iBuscarAuto.buscarAutoByPatente("cincinatty")).thenReturn(false);
        Mockito.when(iGuardarAuto.cargarAuto(maquinaDelMal)).thenReturn(true);

        assertTrue(simulacro.guardarAuto(maquinaDelMal));
    }
}
