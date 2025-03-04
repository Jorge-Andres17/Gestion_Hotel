package co.edu.uniquindio.Hotel.services;

import java.time.LocalDate;

import co.edu.uniquindio.Hotel.model.Cliente;
import co.edu.uniquindio.Hotel.model.Habitacion;
import co.edu.uniquindio.Hotel.model.Reserva;
import co.edu.uniquindio.Hotel.model.ServicioHabitacion;

public interface IMetodosHotel {
    
    public boolean verificarCliente(String dni);
    public void agregarCliente(Cliente cliente);
    public void eliminarCliente(String dni);
    public boolean verificarHabitacion(String numero);
    public void agregarHabitacion(Habitacion habitacion);
    public void eliminarHabitacion(String numero);
    public void agregarServicioHabitacion(ServicioHabitacion servicioHabitacion);
    public void eliminarServicioHabitacion(ServicioHabitacion servicioHabitacion);
    public boolean verificarReserva(int id);
    public void agregarReserva(Reserva reserva);
    public void eliminarReserva(int id);
    public String reservaActiva(LocalDate fechaActual, String cedula);
    public int DiasEntreReserva(int id);
    public double valorTotalReserva(String numero, Reserva reserva);
    public int serviciosTotales(String numHabitacion);
    public int reservasHabitacionMes(String numHabitacion, int mes, int año);
}