package testCasoUso;

import casosDeUso.BuscarAutoCU;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.IBuscarAuto;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestCUBuscarAuto {
    @Mock
    IBuscarAuto iBuscarAuto;

    @Order(1)
    @Test
    public void test01_buscarAuto_autoExiste_y_esLeido(){
        BuscarAutoCU unaBusqueda = new BuscarAutoCU(iBuscarAuto);

        Mockito.when(iBuscarAuto.buscarAutoByPatente("XYZ 123")).thenReturn(true);

        assertTrue(unaBusqueda.buscarAuto("XYZ 123"));
    }
}
