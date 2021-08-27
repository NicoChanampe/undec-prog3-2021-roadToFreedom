package testDominio;

import dominio.Persona;
import exceptions.exceptionPersona.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class TestClasePersona {
    @Order(1)
    @Test
    public void test01_generarObjetoPersonaCorrectamente() throws ExceptionPersona {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //act
        Persona nuevaPersona = Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "89753122", 1.73, 56.31);
        //assert
        assertNotNull(nuevaPersona);
    }

    @Order(2)
    @Test
    public void test02_creacionPersona_personaNombreNulo() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAtributoNulo.class, () -> Persona.factoryPersona(1, null, "Cardozo", "Racing", fechaNacimiento, "89753122", 1.73, 56.31));
    }

    @Order(3)
    @Test
    public void test03_creacionPersona_personaApellidoNulo() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAtributoNulo.class, () -> Persona.factoryPersona(2, "Belen Sabrina", null, "River", fechaNacimiento, "46323162", 1.52, 56.31));
    }

    @Order(4)
    @Test
    public void test04_creacionPersona_personaDNINulo() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAtributoNulo.class, () -> Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, null, 1.73, 56.31));
    }

    @Order(5)
    @Test
    public void test05_creacionPersona_personaDNIVacio() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAtributoVacio.class, () -> Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "", 1.73, 56.31));
    }

    @Order(6)
    @Test
    public void test06_creacionPersona_personaNombreVacio() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAtributoVacio.class, () -> Persona.factoryPersona(1, "", "Cardozo", "Racing", fechaNacimiento, "89753122", 1.73, 56.31));
    }

    @Order(7)
    @Test
    public void test07_creacionPersona_personaApellidoVacio() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAtributoVacio.class, () -> Persona.factoryPersona(1, "Franco David", "", "Racing", fechaNacimiento, "89753122", 1.73, 56.31));
    }

    @Order(8)
    @Test
    public void test08_creacionPersona_personaDniConDigitoDeMas() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaDniMalEscrito.class, () -> Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "8975312246", 1.73, 56.31));
    }

    @Order(9)
    @Test
    public void test09_creacionPersona_personaDNICorto() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaDniMalEscrito.class, () -> Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "893124", 1.73, 56.31));
    }

    @Order(10)
    @Test
    public void test10_creacionPersona_personaDNIConPuntos() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaDniMalEscrito.class, () -> Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "89.312.124", 1.73, 56.31));
    }

    @Order(11)
    @Test
    public void test11_creacionPersona_personaDNIConLetra() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaDniMalEscrito.class, () -> Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "8t312124", 1.73, 56.31));
    }

    @Order(12)
    @Test
    public void test12_creacionPersona_personaAlturaCero() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAlturaErronea.class, () -> Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "89312124", 0.0, 56.31));
    }

    @Order(13)
    @Test
    public void test13_creacionPersona_personaAlturaNegativa() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAlturaErronea.class, () -> Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "89312124", -1.73, 56.31));
    }

    @Order(14)
    @Test
    public void test14_creacionPersona_personaPesoNegativo() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaPesoErroneo.class, () -> Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "89312124", 1.73, -56.31));
    }

    @Order(15)
    @Test
    public void test15_creacionPersona_personaPesoCero() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaPesoErroneo.class, () -> Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "89312124", 1.73, 0.0));
    }

    @Order(16)
    @Test
    public void test16_creacionPersona_personaPesoNulo() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAtributoNulo.class, () -> Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "89312124", 1.73, null));
    }

    @Order(17)
    @Test
    public void test17_creacionPersona_personaAlturaNula() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAtributoNulo.class, () -> Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "89312124", null, 56.75));
    }

    @Order(18)
    @Test
    public void test18_actualizarPersona_seModificanDatosPersona()throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        LocalDate otraFecha = LocalDate.parse("1999-01-20");
        Persona estaPersona = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"89678215",1.79,63.7);
        Persona personaActualizada = Persona.factoryPersona(2,"James","Rodriguez","Deportivo Cali",otraFecha,"89678215",1.8,63.4);

        estaPersona.actualizarDatos(personaActualizada);
        assertEquals(personaActualizada.getNombre(),estaPersona.getNombre());
        assertEquals(personaActualizada.getApellido(),estaPersona.getApellido());
        assertEquals(personaActualizada.getHincha(),estaPersona.getHincha());
        assertEquals(fechaNacimiento,estaPersona.getFechaNacimiento()); //La fecha de nacimiento no se cambia sin importar si se ingresa una distinta
        assertEquals(personaActualizada.getAltura(),estaPersona.getAltura());
        assertEquals(personaActualizada.getPeso(),estaPersona.getPeso());
    }

    @Order(19)
    @Test
    public void test19_actualizarPeso_pesoSeActualizaCorrectamente()throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"89678215",1.79,63.7);
        //Act
        nuevaPersona.actualizarPeso(63.52);
        //Assert
        assertEquals(63.52,nuevaPersona.getPeso());
    }

    @Order(20)
    @Test
    public void test20_actualizarAltura_alturaSeActualizaCorrectamente()throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"89678215",1.79,63.7);
        //Act
        nuevaPersona.actualizarAltura(1.8);
        //Assert
        assertEquals(1.8,nuevaPersona.getAltura());
    }

    @Order(21)
    @Test
    public void test21_actualizarPeso_pesoNegativoLanzaExcepcionPesoErroneo()throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"89678215",1.79,63.7);

        //Assert
        assertThrows(ExceptionPersonaPesoErroneo.class, ()->nuevaPersona.actualizarPeso(-63.52));
    }

    @Order(22)
    @Test
    public void test22_actualizarPeso_pesoCeroLanzaExcepcionPesoErroneo()throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"89678215",1.79,63.7);

        //Assert
        assertThrows(ExceptionPersonaPesoErroneo.class, ()->nuevaPersona.actualizarPeso(0.0));
    }

    @Order(23)
    @Test
    public void test23_actualizarAltura_alturaNegativaLanzaExcepcionAlturaErronea()throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"89678215",1.79,63.7);

        //Assert
        assertThrows(ExceptionPersonaAlturaErronea.class, ()->nuevaPersona.actualizarAltura(-1.94));
    }

    @Order(24)
    @Test
    public void test24_actualizarAltura_alturaCeroLanzaExcepcionAlturaErronea()throws ExceptionPersona{
        //Arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        Persona nuevaPersona = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"89678215",1.79,63.7);

        //Assert
        assertThrows(ExceptionPersonaAlturaErronea.class, ()->nuevaPersona.actualizarAltura(0.0));
    }

}
