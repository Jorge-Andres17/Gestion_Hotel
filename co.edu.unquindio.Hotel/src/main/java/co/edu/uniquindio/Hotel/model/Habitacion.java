package co.edu.uniquindio.Hotel.model;

import co.edu.uniquindio.Hotel.services.TipoHabitacion;

public class Habitacion {
    private String numero;
    private TipoHabitacion tipoHabitacion;
    private double precio;

    public Habitacion(){}

    public Habitacion(String numero, TipoHabitacion tipoHabitacion, double precio) {
        this.numero = numero;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = precio;
    }
}
