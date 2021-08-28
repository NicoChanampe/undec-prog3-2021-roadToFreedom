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
        if(nombre == null || apellido == null || dni == null || peso == null || altura == null)
            throw new ExceptionPersonaAtributoNulo("Los campos apellido, nombre, dni, peso o altura no pueden ser nulos");
        if(dni.equals("") || nombre.equals("") || apellido.equals(""))
            throw new ExceptionPersonaAtributoVacio("Los campos apellido, nombre y dni no pueden estar sin completar");
        if(!validarDni(dni))
            throw new ExceptionPersonaDniMalEscrito("El dni solo debe contener entre 7 y 9 numeros");
        if(altura <= 0)
            throw new ExceptionPersonaAlturaErronea("Altura ingresada erronea");
        if(peso <= 0)
            throw new ExceptionPersonaPesoErroneo("Peso ingresado erroneo");

        return new Persona(id, nombre, apellido, club, fecha, dni, altura, peso);
    }

    private static boolean validarDni(String dni) {
        if(dni.length() < 7 || dni.length() > 9)
            return false;
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

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getHincha() {
        return clubHincha;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void actualizarDatos(Persona personaActualizada) {
        if(personaActualizada.getPeso() != this.peso)
            setPeso(personaActualizada.getPeso());
        if(personaActualizada.getAltura() != this.altura)
            setAltura(personaActualizada.getAltura());
        if(!personaActualizada.getNombre().equals(this.nombre))
            setNombre(personaActualizada.getNombre());
        if(!personaActualizada.getApellido().equals(this.apellido))
            setApellido(personaActualizada.getApellido());
        if(!personaActualizada.getHincha().equals(this.clubHincha))
            setClubHincha(personaActualizada.getHincha());
    }

    private void setPeso(double nuevoPeso){
        this.peso = nuevoPeso;
    }

    private void setAltura(double nuevaAltura) {
        this.altura = nuevaAltura;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }

    private void setClubHincha(String clubHincha) {
        this.clubHincha = clubHincha;
    }

    public void actualizarPeso(double nuevoPeso) throws ExceptionPersona{
        this.actualizarDatos(Persona.factoryPersona(id,nombre,apellido,clubHincha,fechaNacimiento,dni,altura,nuevoPeso));
    }

    public void actualizarAltura(double nuevaAltura)throws ExceptionPersona {
        this.actualizarDatos(Persona.factoryPersona(id,nombre,apellido,clubHincha,fechaNacimiento,dni,nuevaAltura,peso));
    }
}
