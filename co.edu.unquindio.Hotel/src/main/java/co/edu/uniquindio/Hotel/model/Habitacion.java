package co.edu.uniquindio.Hotel.model;

import co.edu.uniquindio.Hotel.services.TipoHabitacion;

import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private String numeroHabitacion;
    private TipoHabitacion tipoHabitacion;
    private double precio;
    private Reserva reserva;
    private List<ServicioHabitacion> listaServicioHabitacion = new ArrayList();

    public Habitacion(){}

    public Habitacion(String numeroHabitacion, TipoHabitacion tipoHabitacion, double precio) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = precio;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<ServicioHabitacion> getListaServicioHabitacion() {
        return listaServicioHabitacion;
    }

    public void setListaServicioHabitacion(List<ServicioHabitacion> listaServicioHabitacion) {
        this.listaServicioHabitacion = listaServicioHabitacion;
    }

    public void agregarServicioHabitacion(ServicioHabitacion servicioHabitacion) {
        listaServicioHabitacion.add(servicioHabitacion);
    }

    public void eliminarServicioHabitacion(ServicioHabitacion servicioHabitacion) {
        listaServicioHabitacion.remove(servicioHabitacion);
    }
}
