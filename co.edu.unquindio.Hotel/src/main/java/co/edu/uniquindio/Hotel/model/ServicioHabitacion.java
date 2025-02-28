package co.edu.uniquindio.Hotel.model;

import java.util.ArrayList;
import java.util.List;

public class ServicioHabitacion extends Servicio{
    private List<Habitacion> listaHabitaciones = new ArrayList();

    public ServicioHabitacion(){}

    public ServicioHabitacion(int idServicio, String nombreServicio, double precioServicio) {
        super(idServicio, nombreServicio, precioServicio);
    }
}
