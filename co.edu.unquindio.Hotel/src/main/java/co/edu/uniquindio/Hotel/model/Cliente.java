package co.edu.uniquindio.Hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String dni;
    private List<Reserva> listaReservasActivas = new ArrayList<>();

    public Cliente(){
    }
    
    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
    }

    
    public void agregarReservaActiva(Reserva reserva) {
        listaReservasActivas.add(reserva);
    }















    /**
     * Método para obtener el nombre del cliente
     * @return
     */
    public  String getNombre() {
        return nombre;
    }
    /**
     * Método para modiifcar el nombre del cliente
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método para obtener el dni del cliente
     * @return
     */
    public String getDni(){
        return dni;
    }
    /**
     * Método para modificar el dni del cliente
     * @param dni
     */
    public void setDni(String dni){
        this.dni = dni;
    }
    /**
     * Método para obtener la lista de reservas Activas del cliente
     * @return
     */
    public List<Reserva> getListaReservasActivas() {
        return listaReservasActivas;
    }
    /**
     * Método para modificar la lista de reservas Activas del cliente
     * @param listaReservas
     */
    public void setListaReservas(List<Reserva> listaReservasActivas) {
        this.listaReservasActivas = listaReservasActivas;
    }
}
