package testCasoUso;

import casosDeUso.TraerAutoCU;
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
import repositorio.ITraerAuto;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestCUTraerAuto {
    @Mock
    ITraerAuto iTraerAuto;

    @Order(1)
    @Test
    public void test01_traerAuto_autoExiste_yEsLeido() throws ExceptionAuto {
        Auto runrun = Auto.factoryAuto(1,"Chevrolet","Corsa","Gris",1.8,"KGV 234",5,2012);
        TraerAutoCU simulamos = new TraerAutoCU(iTraerAuto);

        Mockito.when(iTraerAuto.dameAuto("KGV 346")).thenReturn(runrun);

        assertEquals(runrun,simulamos.traerAuto("KGV 346"));
    }
}
