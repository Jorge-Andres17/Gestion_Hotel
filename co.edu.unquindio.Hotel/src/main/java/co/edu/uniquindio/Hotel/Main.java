package co.edu.uniquindio.Hotel;

import co.edu.uniquindio.Hotel.factory.ModelFactory;
import co.edu.uniquindio.Hotel.model.Hotel;
import co.edu.uniquindio.Hotel.util.Constantes;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        invocar();
    }

    private static void invocar() {
        ModelFactory modelFactory = new ModelFactory();
        Hotel hotel = modelFactory.getHotel();
        abrirPestania(modelFactory);

    }

    private static void reservaHabitacionMes(ModelFactory modelFactory) {
        String numHabitacion = JOptionPane.showInputDialog("Ingrese el numero de habitacion");
        int mes =   Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de la reserva"));
        int anio =   Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de la reserva"));
        String resultado = String.valueOf(modelFactory.reservasHabitacionMes(numHabitacion,mes, anio));
        validarResultado(
                resultado,
                Constantes.RESERVAHABITACIONES + resultado,
                Constantes.NO_RESERVAHABITACIONES);
        abrirPestania(modelFactory);

    }
    private static void serviciosTotales(ModelFactory modelFactory) {
        String numHabitacion = JOptionPane.showInputDialog("Ingrese el numero de la habitacion");
        String resultado = String.valueOf(modelFactory.serviciosTotales(numHabitacion));
        validarResultado(
                resultado,
                Constantes.SERVICIO_EXISTENTE + resultado,
                Constantes.SERVICIO_NO_EXISTE);
        abrirPestania(modelFactory);

    }
    private static void reservaActiva(ModelFactory modelFactory) {
        String fechaActual = JOptionPane.showInputDialog("Ingrese la fecha de la reserva (YYYY-MM-DD)");
        String cedula = JOptionPane.showInputDialog("Ingrese la cedula del cliente");
        String resultado = modelFactory.reservaActiva(convertirLocaldate(fechaActual),cedula);
        validarResultado(
                resultado,
                Constantes.RESERVA_EXISTENTE + resultado,
                Constantes.RESERVA_NO_EXISTE);
        abrirPestania(modelFactory);

    }

    private static LocalDate convertirLocaldate(String fechaActual) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = LocalDate.parse(fechaActual, formatter);
        return fecha;
    }

    private static void validarResultado(String resultado,
                                         String mensajeExitoso,
                                         String mensajeNoExitoso) {
        if (!resultado.equals("")) {
            JOptionPane.showMessageDialog(null,mensajeExitoso);
        } else {
            JOptionPane.showMessageDialog(null,mensajeNoExitoso);
        }
    }


    private static void abrirPestania(ModelFactory modelFactory) {
        int abrirPestania = JOptionPane.showOptionDialog( null,"¿Que desea hacer?",
            "" + modelFactory.getHotel().getNombre(),JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,
            new Object[] { " Cantidad de reservas de una habitación en un mes",
                    " Número de servicios de una habitacion",
                    "Reservas activas de un cliente"}, "Reservas activas de un cliente");

    switch (abrirPestania){
        case 0:
            reservaHabitacionMes(modelFactory);
            break;
        case 1:
            serviciosTotales(modelFactory);
            break;
        case 2:
            reservaActiva (modelFactory);
            break;

        }
    }
}