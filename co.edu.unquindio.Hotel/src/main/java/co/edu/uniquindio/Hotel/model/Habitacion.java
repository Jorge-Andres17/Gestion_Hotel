package co.edu.uniquindio.Hotel.model;

import co.edu.uniquindio.Hotel.services.TipoHabitacion;

import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private String numeroHabitacion;
    private TipoHabitacion tipoHabitacion;
    private double precio;
    private Reserva reserva;
    private List<ServicioHabitacion> listaServicioHabitacion = new ArrayList<>();
    
    public Habitacion(){}   

    public Habitacion(String numeroHabitacion, TipoHabitacion tipoHabitacion, double precio) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = calcularPrecio(tipoHabitacion);
    }
    /**
     * Método para calcular el precio de la habitación
     * @param tipoHabitacion
     * @return
     */
    public double calcularPrecio(TipoHabitacion tipoHabitacion) {
        if(tipoHabitacion == TipoHabitacion.Simple){
            return 100000;
        }
        else if(tipoHabitacion == TipoHabitacion.Doble){
            return 200000;
        }
        else if(tipoHabitacion == TipoHabitacion.Suite){
            return 300000;
        }
        return 0;
    }


    /**
     * Método para obtener el numero de la habitación
     * @return
     */
    public  String getNumeroHabitacion() {
        return numeroHabitacion;
    }
    /**
     * Método para modificar el numero de la habitación
     * @param numeroHabitacion
     */
    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
    /**
     * Método para obtener el tipo de habitación
     * @return
     */
    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }
    /**
     * Método para modificar el tipo de habitación
     * @param tipoHabitacion
     */
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    /**
     * Método para obtener el precio de la habitación
     * @return
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * Método para modificar el precio de la habitación
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * Método para obtener la reserva de la habitación
     * @return
     */
    public Reserva getReserva() {
        return reserva;
    }
    /**
     * Método para modificar la reserva de la habitación
     * @param reserva
     */
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    /**
     * Método para obtener la lista de servicios de la habitación
     * @return
     */
    public List<ServicioHabitacion> getListaServicioHabitacion() {
        return listaServicioHabitacion;
    }
    /**
     * Método para modificar la lista de servicios de la habitación
     * @param listaServicioHabitacion
     */
    public void setListaServicioHabitacion(List<ServicioHabitacion> listaServicioHabitacion) {
        this.listaServicioHabitacion = listaServicioHabitacion;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numeroHabitacion='" + numeroHabitacion + '\'' +
                ", tipoHabitacion=" + tipoHabitacion +
                ", precio=" + precio +
                '}';
    }
}
