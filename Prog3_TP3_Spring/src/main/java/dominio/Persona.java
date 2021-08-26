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
        if(nombre == null || apellido == null || dni == null)
            throw new ExceptionPersonaAtributoNulo("Los campos apellido, nombre y dni no pueden ser nulos");
        if(dni == "" || nombre == "" || apellido == "")
            throw new ExceptionPersonaAtributoVacio("Los campos apellido, nombre y dni no pueden estar sin completar");
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
        if(peso <= 0)
            throw new ExceptionPersonaPesoErroneo("El peso no puede ser negativo");

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

    public String getDni() {
        return dni;
    }

    public void setPeso(double nuevoPeso){
        this.peso = nuevoPeso;
    }

    public double getPeso() {
        return peso;
    }

    public void setAltura(double nuevaAltura) {
        this.altura = nuevaAltura;
    }

    public double getAltura() {
        return altura;
    }
}
