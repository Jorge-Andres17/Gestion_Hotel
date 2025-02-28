package co.edu.uniquindio.Hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private List<Cliente> listaClientes = new ArrayList();
    private List<Habitacion> listaHabitaciones = new ArrayList();
    private List<ServicioHabitacion> listaServicioHabitacion = new ArrayList();
    private List<Reserva> listaReservas = new ArrayList();

    public  Hotel(){}

    public Hotel(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitacion(List<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    public List<ServicioHabitacion> getListaServicioHabitacion() {
        return listaServicioHabitacion;
    }

    public void setListaServicioHabitacion(List<ServicioHabitacion> listaServicioHabitacion) {
        this.listaServicioHabitacion = listaServicioHabitacion;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public boolean verificarCliente(String dni) {
        return listaClientes.stream().anyMatch(cliente -> cliente.getDni().equals(dni));
    }

    public void agregarCliente(Cliente cliente) {
        if (!verificarCliente(cliente.getDni())) {
            listaClientes.add(cliente);
        }
    }

    public void eliminarCliente(String dni) {
        listaClientes.removeIf(cliente -> cliente.getDni().equals(dni));
    }

    public boolean verificarHabitacion(String numero) {
        return listaHabitaciones.stream().anyMatch(habitacion ->
                habitacion.getNumeroHabitacion().equals( numero));
    }

    public void agregarHabitacion(Habitacion habitacion) {
        if (!verificarHabitacion(habitacion.getNumeroHabitacion())) {
            listaHabitaciones.add(habitacion);
        }
    }

    public void eliminarHabitacion(String numero) {
        listaHabitaciones.removeIf(habitacion -> habitacion.getNumeroHabitacion().equals(numero));
    }

    public void agregarServicioHabitacion(ServicioHabitacion servicioHabitacion) {
        listaServicioHabitacion.add(servicioHabitacion);
    }

    public void eliminarServicioHabitacion(ServicioHabitacion servicioHabitacion) {
        listaServicioHabitacion.remove(servicioHabitacion);
    }

    public boolean verificarReserva(int id) {
        return listaReservas.stream().anyMatch(reserva -> reserva.getIdReserva() == id);
    }

    public void agregarReserva(Reserva reserva) {
        if (!verificarReserva(reserva.getIdReserva())) {
            listaReservas.add(reserva);
        }
    }

    public void eliminarReserva(int id) {
        listaReservas.removeIf(reserva -> reserva.getIdReserva() == id);
    }
}