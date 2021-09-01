package testCasoUso;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorio.ITraerAuto;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestCUModificarAuto {
    @Mock
    ITraerAuto iTraerAuto;
//    @Mock
//    IModificarAuto iModificarAuto;

    @Order(1)
    @Test
    public void test01_modificarAuto_datosAutoSeModificanCorrectamente(){

    }
}
