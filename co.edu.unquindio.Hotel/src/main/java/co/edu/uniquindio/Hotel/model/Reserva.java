package co.edu.uniquindio.Hotel.model;

import java.time.LocalDate;

public class Reserva {
    private int  idReserva;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Cliente cliente;
    private Habitacion habitacion;
    
    public Reserva(){}
    
    public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida,Cliente cliente, Habitacion habitacion) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cliente = cliente;
        this.habitacion = habitacion;
    }
    /**
     * Método para obtener el id de la reserva
     * @return
     */
    public int getIdReserva() {
        return idReserva;
    }
    /**
     * Método para modificar el id de la reserva
     * @param idReserva
     */
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    /**
     * Método para obtener la fecha de entrada de la reserva
     * @return
     */
    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }
    /**
     * Método para modificar la fecha de entrada de la reserva
     * @param fechaEntrada
     */
    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    /**
     * Método para obtener la fecha de salida de la reserva
     * @return
     */
    public LocalDate getFechaSalida() {
        return fechaSalida;
    }   
    /**
     * Método para modificar la fecha de salida de la reserva
     * @param fechaSalida
     */
    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    /**
     * Método para obtener el cliente de la reserva
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * Método para modificar el cliente de la reserva
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    /**
     * Método para obtener la habitación de la reserva
     * @return
     */
    public Habitacion getHabitacion() {
        return habitacion;
    }
    /**
     * Método para modificar la habitación de la reserva
     * @param habitacion
     */
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
}
