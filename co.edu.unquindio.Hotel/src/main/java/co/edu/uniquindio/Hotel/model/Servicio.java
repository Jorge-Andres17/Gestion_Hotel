package co.edu.uniquindio.Hotel.model;

public class Servicio {
    private int idServicio;
    private String nombreServicio;
    private double precioServicio;

    public Servicio(){}

    public Servicio(int idServicio, String nombreServicio, double precioServicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.precioServicio = precioServicio;
    }
}
