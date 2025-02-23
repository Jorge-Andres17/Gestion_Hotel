package co.edu.uniquindio.Hotel.model;

import java.time.LocalDate;

public class Reserva {
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    public Reserva(){}

    public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }
}
