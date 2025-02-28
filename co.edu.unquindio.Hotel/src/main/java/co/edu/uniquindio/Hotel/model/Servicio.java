package co.edu.uniquindio.Hotel.model;

import co.edu.uniquindio.Hotel.services.TipoServicio;

public abstract class Servicio {
    private int idServicio;
    private TipoServicio nombreServicio;
    private double precioServicio;

    public Servicio(){}

    public Servicio(int idServicio, TipoServicio nombreServicio, double precioServicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.precioServicio = precioServicio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }


    public double getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(double precioServicio) {
        this.precioServicio = precioServicio;
    }

    public TipoServicio getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(TipoServicio nombreServicio) {
        this.nombreServicio = nombreServicio;
    }
}
