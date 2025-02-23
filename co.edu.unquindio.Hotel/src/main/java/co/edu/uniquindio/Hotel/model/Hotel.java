package co.edu.uniquindio.Hotel.model;

public class Hotel {
    private String nombre;

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
}
