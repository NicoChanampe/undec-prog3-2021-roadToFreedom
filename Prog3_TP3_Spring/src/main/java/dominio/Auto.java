package dominio;

import exceptions.exceptionAuto.*;

import java.time.LocalDate;

public class Auto {
    private Integer id;
    private String marca;
    private String modelo;
    private String color;
    private Double cilindrada;
    private String patente;
    private Integer cantidadPuertas;
    private Integer anioFabricacion;

    public static Auto factoryAuto(Integer id,String marca, String modelo, String color, Double cilindrada, String patente, Integer puertas, Integer anio)throws ExceptionAuto {
        if(marca == null || modelo == null || color == null || cilindrada == null || patente == null || puertas == null || anio == null)
            throw new ExceptionAutoAtributoNulo("Los campos no pueden ser nulos");
        if (marca.equals("") || modelo.equals("") || patente.equals(""))
            throw new ExceptionAutoAtributoVacia("Los campos marca, modelo y patente no pueden estar vacios");
        if (cilindrada < 0)
            throw new ExceptionAutoCilindradaNegativa("El campo cilindrada no puede ser negativo");
        if(puertas != 3 && puertas != 5)
            throw new ExceptionAutoNumeroPuertasInvalido("La cantidad ingresada de puertas es invalida (3 o 5)");
        if (anio < 1890 || anio > LocalDate.now().getYear())
            throw new ExceptionAutoAñoInvalido("El año ingresado debe estar entre 1890 y " + LocalDate.now().getYear());

        return new Auto(id,marca, modelo, color, cilindrada, patente, puertas, anio);
    }

    private Auto(Integer id,String marca, String modelo, String color, Double cilindrada, String patente, Integer puertas, Integer anio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.cilindrada = cilindrada;
        this.patente = patente;
        this.cantidadPuertas = puertas;
        this.anioFabricacion = anio;
    }

    public String getPatente() {
        return this.patente;
    }

    public void actualizarAuto(Auto autoActualizado) {
        if(!autoActualizado.getColor().equals(this.color))
            this.setColor(autoActualizado.getColor());
        if(!autoActualizado.getCilindrada().equals(this.cilindrada))
            this.setCilindrada(autoActualizado.getCilindrada());
    }

    private void setCilindrada(Double nuevaCilindrada) {
        this.cilindrada = nuevaCilindrada;
    }

    private Double getCilindrada() {
        return cilindrada;
    }

    private String getColor() {
        return color;
    }

    private void setColor(String nuevoColor) {
        this.color = nuevoColor;
    }

    private String getMarca() {
        return marca;
    }

    private String getModelo() {
        return modelo;
    }

    public String obtenerColor() {
        if(color.equals(""))
           return "El auto no tiene color cargado";
        return getColor();
    }

    public Double obtenerCilindrada() {
        return getCilindrada();
    }

    public String obtenerMarca() {
        return getMarca();
    }

    public String obtenerModelo() {
        return getModelo();
    }

}
