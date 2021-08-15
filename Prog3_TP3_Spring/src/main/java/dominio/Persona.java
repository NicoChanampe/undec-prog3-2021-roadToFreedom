package dominio;

import exceptions.exceptionPersona.ExceptionPersona;
import exceptions.exceptionPersona.ExceptionPersonaAtributoNulo;

import java.time.LocalDate;

public class Persona {
    public Integer id;
    public String nombre;
    public String apellido;
    public String clubHincha;
    public LocalDate fechaNacimiento;
    public String dni;
    public Double altura;
    public Double peso;


    public static Persona factoryPersona(int id, String nombre, String apellido, String club, LocalDate fecha, String dni, Double altura, Double peso) throws ExceptionPersona {
        if(nombre == null)
            throw new ExceptionPersonaAtributoNulo("El nombre no puede ser nulo");
        if(apellido == null)
            throw new ExceptionPersonaAtributoNulo("El apellido no puede ser nulo");

        return new Persona(id, nombre, apellido, club, fecha, dni, altura, peso);
    }

    private Persona (int id, String nombre, String apellido, String club, LocalDate fecha, String dni, Double altura, Double peso){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clubHincha = club;
        this.fechaNacimiento = fecha;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }
}
