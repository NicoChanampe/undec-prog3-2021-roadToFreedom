package dominio;

public class Auto {
    private String marca;
    private String modelo;
    private String color;
    private Double cilindrada;
    private String patente;
    private Integer cantidadPuertas;
    private Integer añoFabricacion;

    public static Auto factoryAuto(String marca, String modelo, String color, double cilindrada, String patente, int puertas, int año) {
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
