package dominio;

import exceptions.exceptionPersona.*;

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
        if(dni == null)
            throw new ExceptionPersonaAtributoNulo("El DNI no puede ser nulo");
        if(dni == "")
            throw new ExceptionPersonaAtributoVacio("El DNI no puede estar sin completar");
        if(nombre == "")
            throw new ExceptionPersonaAtributoVacio("El campo nombre no puede quedar vacio");
        if(apellido == "")
            throw new ExceptionPersonaAtributoVacio("El campo apellido no puede quedar vacio");
        if(dni.length() > 9)
            throw new ExceptionPersonaDniMalEscrito("El dni no puede tener mas de 10 digitos");
        if(dni.length() < 8)
            throw new ExceptionPersonaDniMalEscrito("El dni minimo debe tener 8 digitos");
        if(!validarDni(dni))
            throw new ExceptionPersonaDniMalEscrito("El dni solo debe contener numeros");
        if(altura == 0)
            throw new ExceptionPersonaAlturaErronea("La altura no puede ser cero");
        if(altura < 0)
            throw new ExceptionPersonaAlturaErronea("La altura no puede ser negativa");

        return new Persona(id, nombre, apellido, club, fecha, dni, altura, peso);
    }

    private static boolean validarDni(String dni) {
        for(int i = 0;i<dni.length();i++){
            if(dni.codePointAt(i) < 48 || dni.codePointAt(i) > 57)
                return false;
        }
        return true;
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
