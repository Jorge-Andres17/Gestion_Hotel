package co.edu.uniquindio.Hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String dni;
    private List<Reserva> listaReservas = new ArrayList();
    public Cliente(){}

    public  Cliente(String nombre, String dni) {
        this.nombre = nombre;
    }

    public  String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni(){
        return dni;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
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
