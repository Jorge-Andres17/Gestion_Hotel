package co.edu.uniquindio.Hotel.factory;

import co.edu.uniquindio.Hotel.model.*;
import co.edu.uniquindio.Hotel.services.TipoHabitacion;
import co.edu.uniquindio.Hotel.services.TipoServicio;
import java.time.LocalDate;

public class ModelFactory {
    private static ModelFactory instance;
    private Hotel hotel;

    public ModelFactory(){
        hotel = inicializarDatos();
    }

    public ModelFactory getInstance(){
        if (instance == null){
            instance = new ModelFactory();
        }

        return instance;
    }

    private Hotel inicializarDatos() {
        Hotel hotel = new Hotel();
        hotel.setNombre("Hotel UQ");
        Habitacion habitacion1 = new Habitacion();
        Habitacion habitacion2 = new Habitacion();
        habitacion1.setNumeroHabitacion("101");
        habitacion2.setNumeroHabitacion("102");
        habitacion1.setTipoHabitacion(TipoHabitacion.Suite);
        habitacion2.setTipoHabitacion(TipoHabitacion.Doble);
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();
        cliente1.setNombre("Jorge");
        cliente1.setDni("1");
        cliente2.setNombre("vero");
        cliente2.setDni("2");
        cliente3.setNombre("esteban");
        cliente3.setDni("3");
        ServicioHabitacion servicio = new ServicioHabitacion();
        servicio.setIdServicio(1);
        servicio.setTipoServicio(TipoServicio.Spa);
        ServicioHabitacion servicio2 = new ServicioHabitacion();
        servicio2.setIdServicio(2);
        servicio2.setTipoServicio(TipoServicio.Limpieza);
        ServicioHabitacion servicio3 = new ServicioHabitacion();
        servicio3.setIdServicio(3);
        servicio3.setTipoServicio(TipoServicio.Restaurante);
        Reserva reserva = new Reserva();
        reserva.setCliente(cliente1);
        reserva.setFechaEntrada(LocalDate.of(2024,3,10));
        reserva.setFechaSalida(LocalDate.of(2024,4,1));
        reserva.setHabitacion(habitacion1);
        reserva.setIdReserva(1);
        Reserva reserva2 = new Reserva();
        reserva2.setCliente(cliente2);
        reserva2.setFechaEntrada(LocalDate.of(2024,5,15));
        reserva2.setFechaSalida(LocalDate.of(2024,5,20));
        reserva2.setHabitacion(habitacion1);
        reserva2.setIdReserva(2);
        hotel.agregarCliente(cliente1);
        hotel.agregarCliente(cliente2);
        hotel.agregarCliente(cliente3);
        hotel.agregarReserva(reserva);
        hotel.agregarReserva(reserva2);
        hotel.agregarServicioHabitacion(servicio);
        hotel.agregarServicioHabitacion(servicio2);
        hotel.agregarServicioHabitacion(servicio3);
        hotel.agregarHabitacion(habitacion1);
        hotel.agregarHabitacion(habitacion2);
        servicio.getListaHabitaciones().add(habitacion1);
        servicio2.getListaHabitaciones().add(habitacion1);
        servicio2.getListaHabitaciones().add(habitacion2);
        servicio.getListaHabitaciones().add(habitacion2);
        servicio3.getListaHabitaciones().add(habitacion2);
        habitacion1.getListaServicioHabitacion().add(servicio);
        habitacion1.getListaServicioHabitacion().add(servicio2);
        habitacion2.getListaServicioHabitacion().add(servicio);
        habitacion2.getListaServicioHabitacion().add(servicio2);
        habitacion2.getListaServicioHabitacion().add(servicio3);

        return hotel;
    }

    public int reservasHabitacionMes(String numHabitacion, int mes, int anio) {
        return hotel.reservasHabitacionMes(numHabitacion,mes,anio);
    }

    public int serviciosTotales( String numHabitacion) {
        return hotel.serviciosTotales(numHabitacion);
    }

    public String reservaActiva(LocalDate fechaActual, String ceedula) {
        return hotel.reservaActiva(fechaActual,ceedula);
    }

    public Hotel getHotel() {
        return hotel;
    }
}