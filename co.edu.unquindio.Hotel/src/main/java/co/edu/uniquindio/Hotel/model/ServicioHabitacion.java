package co.edu.uniquindio.Hotel.model;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.Hotel.services.TipoServicio;

public class ServicioHabitacion extends Servicio{
    private List<Habitacion> listaHabitaciones = new ArrayList<>();

    public ServicioHabitacion(){}

    public ServicioHabitacion(int idServicio, TipoServicio nombreServicio, double precioServicio) {
        super(idServicio, nombreServicio);
    }
    /**
     * Método para obtener la lista de habitaciones del servicio
     * @return
     */
    public List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }
    /**
     * Método para modificar la lista de habitaciones del servicio
     * @param listaHabitaciones
     */
    public void setListaHabitaciones(List<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    @Override
    public void consumir() {
        //el metodo consumir miren a ver como lo plantean 
    }
}
