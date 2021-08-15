package testDominio;

import dominio.Persona;
import exceptions.exceptionPersona.ExceptionPersona;
import exceptions.exceptionPersona.ExceptionPersonaAtributoNulo;
import exceptions.exceptionPersona.ExceptionPersonaAtributoVacio;
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
        Persona nuevaPersona = Persona.factoryPersona(1,"Franco David","Cardozo","Racing",fechaNacimiento,"89753122",1.73,56.31);
        //assert
        assertNotNull(nuevaPersona);
    }

    @Order(2)
    @Test
    public void test02_creacionPersona_personaNombreNulo() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAtributoNulo.class, () -> {
            Persona nuevaPersona = Persona.factoryPersona(1, null, "Cardozo", "Racing", fechaNacimiento, "89753122", 1.73, 56.31);
        });
    }

    @Order(3)
    @Test
    public void test03_creacionPersona_personaApellidoNulo() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAtributoNulo.class, () -> {
            Persona nuevaPersona = Persona.factoryPersona(2, "Belen Sabrina", null, "River", fechaNacimiento, "46323162", 1.52, 56.31);
        });
    }

    @Order(4)
    @Test
    public void test04_creacionPersona_personaDNINulo() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAtributoNulo.class, () -> {
            Persona nuevaPersona = Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, null, 1.73, 56.31);
        });
    }

    @Order(5)
    @Test
    public void test05_creacionPersona_personaDNIVacio() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAtributoVacio.class, () -> {
            Persona nuevaPersona = Persona.factoryPersona(1, "Franco David", "Cardozo", "Racing", fechaNacimiento, "", 1.73, 56.31);
        });
    }

    @Order(6)
    @Test
    public void test06_creacionPersona_personaNombreVacio() {
        //arrange
        LocalDate fechaNacimiento = LocalDate.parse("1999-01-20");
        //assert
        assertThrows(ExceptionPersonaAtributoVacio.class, () -> {
            Persona nuevaPersona = Persona.factoryPersona(1, "", "Cardozo", "Racing", fechaNacimiento, "89753122", 1.73, 56.31);
        });
    }


}
