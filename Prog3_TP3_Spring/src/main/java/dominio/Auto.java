package dominio;

import exceptions.exceptionAuto.ExceptionAuto;
import exceptions.exceptionAuto.ExceptionAutoAtributoNulo;
import exceptions.exceptionAuto.ExceptionAutoAtributoVacia;

public class Auto {
    private String marca;
    private String modelo;
    private String color;
    private Double cilindrada;
    private String patente;
    private Integer cantidadPuertas;
    private Integer añoFabricacion;

    public static Auto factoryAuto(String marca, String modelo, String color, double cilindrada, String patente, int puertas, int año)throws ExceptionAuto {
        if(marca == null)
            throw new ExceptionAutoAtributoNulo("La marca no puede ser nula");
        if (marca == "")
            throw new ExceptionAutoAtributoVacia("El campo marca no puede quedar vacio");
        if(modelo == null)
            throw new ExceptionAutoAtributoNulo("El modelo no puede ser nulo");
        if (modelo == "")
            throw new ExceptionAutoAtributoVacia("El campo modelo no puede quedar vacio");
        if(color == null)
            throw new ExceptionAutoAtributoNulo("El color no puede ser nulo");
        if(patente == null)
            throw new ExceptionAutoAtributoNulo("La patente no puede ser nula");
        if(patente == "")
            throw new ExceptionAutoAtributoVacia("El campo patente no puede quedar vacio");

        return new Auto(marca, modelo, color, cilindrada, patente, puertas, año);
    }

    private Auto(String marca, String modelo, String color, Double cilindrada, String patente, Integer puertas, Integer año) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.cilindrada = cilindrada;
        this.patente = patente;
        this.cantidadPuertas = puertas;
        this.añoFabricacion = año;
    }

}
