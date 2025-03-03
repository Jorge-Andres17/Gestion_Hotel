package co.edu.uniquindio.Hotel.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.Hotel.services.IMetodosHotel;



public class Hotel implements IMetodosHotel{
    private String nombre;
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Habitacion> listaHabitaciones = new ArrayList<>();
    private List<ServicioHabitacion> listaServicioHabitacion = new ArrayList<>();
    private List<Reserva> listaReservas = new ArrayList<>();

    public  Hotel(){
    }
    
    public Hotel(String nombre){
        this.nombre = nombre;
    }
    /**
     * Método para verificar la existencia de un cliente en la lista de clientes    
     * @param dni
     * @return
     */
    @Override
    public boolean verificarCliente(String dni) {
        return listaClientes.stream().anyMatch(cliente -> cliente.getDni().equals(dni));
    }
    /**
     * Método para agregar un cliente a la lista de clientes
     * @param cliente
     */
    @Override
    public void agregarCliente(Cliente cliente) {
        if (!verificarCliente(cliente.getDni())) {
            listaClientes.add(cliente);
        }
    }
    /**
     * Método para eliminar un cliente de la lista de clientes
     * @param dni
     */
    @Override
    public void eliminarCliente(String dni) {
        listaClientes.removeIf(cliente -> cliente.getDni().equals(dni));
    }
    /**
     * Método para verificar la existencia de una habitación en la lista de habitaciones
     * @param numero
     * @return
     */
    @Override
    public boolean verificarHabitacion(String numero) {
        return listaHabitaciones.stream().anyMatch(habitacion ->habitacion.getNumeroHabitacion().equals( numero));
    }
    /**
     * Método para agregar una habitación a la lista de habitaciones
     * @param habitacion
     */
    @Override
    public void agregarHabitacion(Habitacion habitacion) {
        if (!verificarHabitacion(habitacion.getNumeroHabitacion())) {
            listaHabitaciones.add(habitacion);
        }
    }
    /**
     * Método para eliminar una habitación de la lista de habitaciones
     * @param numero
     */
    @Override
    public void eliminarHabitacion(String numero) {
        listaHabitaciones.removeIf(habitacion -> habitacion.getNumeroHabitacion().equals(numero));
    }
    /**
     * Método para agregar un servicio a la lista de servicios
     * @param servicioHabitacion
     */
    @Override
    public void agregarServicioHabitacion(ServicioHabitacion servicioHabitacion) {
        listaServicioHabitacion.add(servicioHabitacion);
    }
    /**
     * Método para eliminar un servicio de la lista de servicios
     * @param servicioHabitacion
     */
    @Override
    public void eliminarServicioHabitacion(ServicioHabitacion servicioHabitacion) {
        listaServicioHabitacion.remove(servicioHabitacion);
    }
    /**
     * Método para verificar la existencia de una reserva en la lista de reservas
     * @param id
     * @return
     */
    @Override
    public boolean verificarReserva(int id) {
        return listaReservas.stream().anyMatch(reserva -> reserva.getIdReserva() == id);
    }
    /**
     * Método para agregar una reserva a la lista de reservas
     * @param reserva
     */
    @Override
    public void agregarReserva(Reserva reserva) {
        if (!verificarReserva(reserva.getIdReserva())) {
            listaReservas.add(reserva);
        }
    }
    /**
     * Método para eliminar una reserva de la lista de reservas
     * @param id
     */
    @Override
    public void eliminarReserva(int id) {
        listaReservas.removeIf(reserva -> reserva.getIdReserva() == id);
    }
    /**
     * Método para obtener las reservas activas de un cliente
     * @param fechaActual
     * @param cliente
     */
    @Override
    public void reservaActiva(LocalDate fechaActual, Cliente cliente) {
        for (Reserva reserva : listaReservas) {
            if(reserva.getCliente().equals(cliente)){
                if((fechaActual.isEqual(reserva.getFechaEntrada()) || fechaActual.isAfter(reserva.getFechaEntrada())) &&
                (fechaActual.isEqual(reserva.getFechaSalida()) || fechaActual.isBefore(reserva.getFechaSalida()))){
                    cliente.agregarReservaActiva(reserva);
                }
            }
        }
    }
    /**
     * Método para obtener el número de días de la reserva 
     * @param id
     * @return
     */
    @Override
    public int DiasEntreReserva(int id){
        int dias = 0;
        for (Reserva reserva : listaReservas) {
            if(reserva.getIdReserva() == id){
                return dias += (int) ChronoUnit.DAYS.between(reserva.getFechaEntrada(), reserva.getFechaSalida());
            }
        }
        return dias = 0;
    }
    /**
     * Método para obtener el valor total de la reserva
     * @param numero
     * @param reserva
     * @return
     */
    @Override
    public double valorTotalReserva(String numero, Reserva reserva){
        double total = 0;
        for (Habitacion habitacion : listaHabitaciones) {
            if(habitacion.getNumeroHabitacion().equals(numero) && reserva.getHabitacion().getNumeroHabitacion().equals(numero)){
                total += habitacion.getPrecio() * DiasEntreReserva(reserva.getIdReserva());
            }
        }
        return total;
    }
    /**
     * Método para obtener el número de servicios de una habitacion
     * @param id
     * @param numHabitacion
     * @return
     */
    @Override
    public int serviciosTotales(int id, String numHabitacion){
        int total = 0;
        if (listaServicioHabitacion == null) {
            throw new IllegalArgumentException("La lista de servicios no puede ser nula.");
        }
        for (ServicioHabitacion servicioHabitacion : listaServicioHabitacion) {
            if(servicioHabitacion.getIdServicio() == id){
                if (servicioHabitacion.getListaHabitaciones() != null) {
                    for (Habitacion habitacion : servicioHabitacion.getListaHabitaciones()) {
                        if (habitacion.getNumeroHabitacion().equals(numHabitacion)) {
                            total++;
                        }
                    }
                }
            }
        }
        return total;
    }
    /**
     * Método para obtener la cantidad de reservas de una habitación en un mes
     * @param numHabitacion
     * @param mes
     * @param año
     * @return
     */
    @Override
    public int reservasDeHabitacionMes(String numHabitacion, int mes, int año) {
        int total = 0;
        LocalDate inicioDelMes = LocalDate.of(año, mes, 1);
        LocalDate finDelMes = inicioDelMes.withDayOfMonth(inicioDelMes.lengthOfMonth());
        for (Habitacion habitacion : listaHabitaciones) {
            if(habitacion.getNumeroHabitacion().equals(numHabitacion)){
                for (Reserva reserva : listaReservas) {
                    if(reserva.getHabitacion().getNumeroHabitacion().equals(numHabitacion)){
                        if((reserva.getFechaEntrada().isEqual(inicioDelMes) || reserva.getFechaEntrada().isAfter(inicioDelMes)) &&
                        (reserva.getFechaEntrada().isEqual(finDelMes) || reserva.getFechaEntrada().isBefore(finDelMes))){
                            total++;
                        }
                    }
                }
            }
        }
        return total;
    }


    /**
     * Método para obtener el nombre del hotel
     * @return
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método para modificar el nombre del hotel
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método para obtener la lista de clientes del hotel
     * @return
     */
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    /**
     * Método para modificar la lista de clientes del hotel
     * @param listaClientes
     */
    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    /**
     * Método para obtener la lista de habitaciones del hotel
     * @return
     */
    public List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }
    /**
     * Método para modificar la lista de habitaciones del hotel
     * @param listaHabitaciones
     */
    public void setListaHabitaciones(List<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }
    /**
     * Método para obtener la lista de servicios del hotel
     * @return
     */
    public List<ServicioHabitacion> getListaServicioHabitacion() {
        return listaServicioHabitacion;
    }
    /**
     * Método para modificar la lista de servicios del hotel
     * @param listaServicioHabitacion
     */
    public void setListaServicioHabitacion(List<ServicioHabitacion> listaServicioHabitacion) {
        this.listaServicioHabitacion = listaServicioHabitacion;
    }   
    /**
     * Método para obtener la lista de reservas del hotel
     * @return
     */
    public List<Reserva> getListaReservas() {
        return listaReservas;
    }
    /**
     * Método para modificar la lista de reservas del hotel
     * @param listaReservas
     */
    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    
    
}