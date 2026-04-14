package modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Reserva {
    private static Long contadorId = 1L;

    private long id;
    private Cliente cliente;
    private LocalDate fecha;
    private LocalTime hora;
    private int numPersonas;
    private double importePrevisto;
    private EstadoReserva estado;
    private String zona;

    //Constructor
    public Reserva(Cliente cliente, LocalDate fecha, LocalTime hora, int numPersonas, double importePrevisto, EstadoReserva estado, String zona) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
        this.importePrevisto = importePrevisto;
        this.estado = estado;
        this.zona = zona;
    }

    //ToString
    @Override
    public String toString() {
        return "ID: " + id +
                " | " + cliente.getDni() +
                " | " + fecha + " " + hora +
                " | " + numPersonas + " pers" +
                " | " + importePrevisto + "€" +
                " | " + estado +
                " | " + zona;
    }
}
