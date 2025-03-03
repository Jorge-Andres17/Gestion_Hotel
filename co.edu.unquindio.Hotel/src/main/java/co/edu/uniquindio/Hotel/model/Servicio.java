package co.edu.uniquindio.Hotel.model;

import co.edu.uniquindio.Hotel.services.IConsumible;
import co.edu.uniquindio.Hotel.services.TipoServicio;

public abstract class Servicio implements IConsumible{
    private int idServicio;
    private TipoServicio tipoServicio;

    public Servicio(){}

    public Servicio(int idServicio, TipoServicio tipoServicio) {
        this.idServicio = idServicio;
        this.tipoServicio = tipoServicio;
    }
    /**
     * Método para obtener el id del servicio
     * @return
     */
    public int getIdServicio() {
        return idServicio;
    }
    /**
     * Método para modificar el id del servicio
     * @param idServicio
     */
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
    /**
     * Método para obtener el tipo del servicio
     * @return
     */
    public TipoServicio gTipoServicio() {
        return tipoServicio;
    }
    /**
     * Método para modificar el tipo del servicio
     * @param tipoServicio
     */
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}
