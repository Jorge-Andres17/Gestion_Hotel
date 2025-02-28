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
        servicio.setNombreServicio(TipoServicio.Spa);
        servicio.setPrecioServicio(1000);
        ServicioHabitacion servicio2 = new ServicioHabitacion();
        servicio2.setIdServicio(2);
        servicio2.setNombreServicio(TipoServicio.Limpieza);
        servicio2.setPrecioServicio(2000);
        ServicioHabitacion servicio3 = new ServicioHabitacion();
        servicio3.setIdServicio(3);
        servicio3.setNombreServicio(TipoServicio.Restaurante);
        servicio3.setPrecioServicio(3000);
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
