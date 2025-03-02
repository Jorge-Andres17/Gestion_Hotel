package co.edu.uniquindio.Hotel.factory;

import co.edu.uniquindio.Hotel.model.*;
import co.edu.uniquindio.Hotel.services.TipoHabitacion;
import co.edu.uniquindio.Hotel.services.TipoServicio;

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
        hotel.setNombre("Hotel");
        Habitacion habitacion = new Habitacion();
        habitacion.setNumeroHabitacion("101");
        habitacion.setTipoHabitacion(TipoHabitacion.Doble);
        Cliente cliente = new Cliente();
        cliente.setNombre("Jorge");
        cliente.setDni("12345");
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
        reserva.setCliente(cliente);
        reserva.setFechaEntrada(null);
        reserva.setFechaSalida(null);
        reserva.setHabitacion(habitacion);
        reserva.setIdReserva(1);
        hotel.agregarCliente(cliente);
        hotel.agregarReserva(reserva);
        hotel.agregarServicioHabitacion(servicio);
        hotel.agregarServicioHabitacion(servicio2);
        hotel.agregarServicioHabitacion(servicio3);
        hotel.agregarHabitacion(habitacion);

        return hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
