package testCasoUso;

import casosDeUso.ModificarAutoCU;
import dominio.Auto;
import exceptions.exceptionAuto.ExceptionAuto;
import exceptions.exceptionAuto.ExceptionAutoNoExiste;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.IModificarAuto;
import repositorio.ITraerAuto;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestCUModificarAuto {
    @Mock
    ITraerAuto iTraerAuto;
    @Mock
    IModificarAuto iModificarAuto;

    @Order(1)
    @Test
    public void test01_modificarAuto_datosAutoSeModificanCorrectamente()throws ExceptionAuto {
        //Arrange
        Auto esteAuto = Auto.factoryAuto(1,"Fiat","147","Blanco",1.1,"XYZ 134",3,1996);
        Auto autoActualizado = Auto.factoryAuto(1,"Fiat","147","Azul",1.4,"XYZ 134",3,1996);
        ModificarAutoCU simulacroModificacion = new ModificarAutoCU(iModificarAuto,iTraerAuto);
        //Act
        Mockito.when(iTraerAuto.dameAuto(autoActualizado.getPatente())).thenReturn(esteAuto);
        esteAuto.actualizarAuto(autoActualizado);
        Mockito.when(iModificarAuto.modificarAuto(esteAuto)).thenReturn(true);

        //Assert
        assertTrue(simulacroModificacion.actualizarDatos(autoActualizado));
    }

    @Order(2)
    @Test
    public void test02_modificarAuto_datosAutoSeModifican_falloEnBDRetornaFalse()throws ExceptionAuto {
        //Arrange
        Auto esteAuto = Auto.factoryAuto(1,"Fiat","147","Blanco",1.1,"XYZ 134",3,1996);
        Auto autoActualizado = Auto.factoryAuto(1,"Fiat","147","Azul",1.4,"XYZ 134",3,1996);
        ModificarAutoCU simulacroModificacion = new ModificarAutoCU(iModificarAuto,iTraerAuto);
        //Act
        Mockito.when(iTraerAuto.dameAuto(autoActualizado.getPatente())).thenReturn(esteAuto);
        esteAuto.actualizarAuto(autoActualizado);
        Mockito.when(iModificarAuto.modificarAuto(esteAuto)).thenReturn(false);

        //Assert
        assertFalse(simulacroModificacion.actualizarDatos(autoActualizado));
    }

    @Order(3)
    @Test
    public void test03_modificarAuto_autoBuscadoNoExiste_excepcionAutoNoExiste()throws ExceptionAuto {
        //Arrange
        Auto autoActualizado = Auto.factoryAuto(1,"Fiat","147","Azul",1.4,"XYZ 134",3,1996);
        ModificarAutoCU simulacroModificacion = new ModificarAutoCU(iModificarAuto,iTraerAuto);
        //Act
        Mockito.when(iTraerAuto.dameAuto(autoActualizado.getPatente())).thenReturn(null);
        Mockito.verify(iModificarAuto,Mockito.never()).modificarAuto(autoActualizado);

        //Assert
        assertThrows(ExceptionAutoNoExiste.class, ()-> simulacroModificacion.actualizarDatos(autoActualizado));
    }
}
