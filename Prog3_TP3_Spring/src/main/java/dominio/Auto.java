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
    private Integer añoFabricacion;

    public static Auto factoryAuto(Integer id,String marca, String modelo, String color, Double cilindrada, String patente, Integer puertas, Integer año)throws ExceptionAuto {
        if(marca == null || modelo == null || color == null || cilindrada == null || patente == null || puertas == null || año == null)
            throw new ExceptionAutoAtributoNulo("La marca no puede ser nula");
        if (marca == "")
            throw new ExceptionAutoAtributoVacia("El campo marca no puede quedar vacio");
        if (modelo == "")
            throw new ExceptionAutoAtributoVacia("El campo modelo no puede quedar vacio");
        if(patente == "")
            throw new ExceptionAutoAtributoVacia("El campo patente no puede quedar vacio");
        if (cilindrada < 0)
            throw new ExceptionAutoCilindradaNegativa("El campo cilindrada no puede ser negativo");
        if(puertas != 3 && puertas != 5)
            throw new ExceptionAutoNumeroPuertasInvalido("La cantidad ingresada de puertas es invalida (3 o 5)");
        if (año < 1890 || año > LocalDate.now().getYear())
            throw new ExceptionAutoAñoInvalido("El año ingresado debe estar entre 1890 y " + LocalDate.now().getYear());

        return new Auto(id,marca, modelo, color, cilindrada, patente, puertas, año);
    }

    private Auto(Integer id,String marca, String modelo, String color, Double cilindrada, String patente, Integer puertas, Integer año) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.cilindrada = cilindrada;
        this.patente = patente;
        this.cantidadPuertas = puertas;
        this.añoFabricacion = año;
    }

    public String getPatente() {
        return this.patente;
    }
}
