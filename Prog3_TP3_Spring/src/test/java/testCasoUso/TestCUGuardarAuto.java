package testCasoUso;

import casosDeUso.GuardarAutoCU;
import dominio.Auto;
import exceptions.exceptionAuto.ExceptionAuto;
import exceptions.exceptionAuto.ExceptionAutoExistente;
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
        Auto maquinaDelMal = Auto.factoryAuto(1,"Ford","Mustang","Gris",5.0,"cincinatty",3,1969);
        GuardarAutoCU simulacro = new GuardarAutoCU(iGuardarAuto,iBuscarAuto);

        Mockito.when(iBuscarAuto.buscarAutoByPatente("cincinatty")).thenReturn(false);
        Mockito.when(iGuardarAuto.cargarAuto(maquinaDelMal)).thenReturn(true);

        assertTrue(simulacro.guardarAuto(maquinaDelMal));
    }

    @Order(2)
    @Test
    public void test02_guardarAuto_autoExiste_excepcionAutoExistente()throws ExceptionAuto {
        Auto autoExiste = Auto.factoryAuto(1,"Fiat","147","Azul",1.1,"XYZ 123",5,1998);
        GuardarAutoCU simulacro = new GuardarAutoCU(iGuardarAuto,iBuscarAuto);

        Mockito.when(iBuscarAuto.buscarAutoByPatente("XYZ 123")).thenReturn(true);
        Mockito.verify(iGuardarAuto,Mockito.never()).cargarAuto(autoExiste);

        assertThrows(ExceptionAutoExistente.class, ()->{
            simulacro.guardarAuto(autoExiste);
        });
    }

    @Order(3)
    @Test
    public void test03_guardarAuto_autoNoExiste_y_errorEnBD()throws ExceptionAuto {
        Auto maquinaDelMal = Auto.factoryAuto(1,"Ford","Mustang","Gris",5.0,"cincinatty",3,1969);
        GuardarAutoCU simulacro = new GuardarAutoCU(iGuardarAuto,iBuscarAuto);

        Mockito.when(iBuscarAuto.buscarAutoByPatente("cincinatty")).thenReturn(false);
        Mockito.when(iGuardarAuto.cargarAuto(maquinaDelMal)).thenReturn(false);

        assertFalse(simulacro.guardarAuto(maquinaDelMal));
    }
}
