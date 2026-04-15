package app;

import modelo.Cliente;
import modelo.EstadoReserva;
import modelo.Reserva;
import servicio.Restaurante;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    static void main() {

        Restaurante r = new Restaurante("Bar leyendas");

        // CLIENTES
        Cliente c1 = new Cliente("48273615M", "Ana Pérez", "673829154", "ana@email.com", "Sevilla");
        Cliente c2 = new Cliente("59384726K", "Luis Gómez", "612947385", "luis@email.com", "Madrid");
        Cliente c3 = new Cliente("74125896T", "Marta Ruiz", "698231457", "marta@email.com", "Valencia");
        Cliente c4 = new Cliente("36925814P", "Carlos López", "645782319", "carlos@email.com", "Málaga");
        Cliente c5 = new Cliente("85274163L", "Lucía Torres", "679314825", "lucia@email.com", "Granada");
        Cliente c6 = new Cliente("14785236R", "Pedro Díaz", "622518947", "pedro@email.com", "Bilbao");
        Cliente c7 = new Cliente("96385274S", "Sara León", "687429153", "sara@email.com", "Zaragoza");
        Cliente c8 = new Cliente("25836914N", "David Castro", "655193728", "david@email.com", "Alicante");

        r.addCliente(c1);
        r.addCliente(c2);
        r.addCliente(c3);
        r.addCliente(c4);
        r.addCliente(c5);
        r.addCliente(c6);
        r.addCliente(c7);
        r.addCliente(c8);

        // RESERVAS (todas futuras)
        LocalDate hoy = LocalDate.now();

        r.addReserva(new Reserva(c1, hoy.plusDays(15), LocalTime.of(14, 0), 2, 30.0, EstadoReserva.CONFIRMADA, "interior"));
        r.addReserva(new Reserva(c2, hoy.plusDays(20), LocalTime.of(21, 30), 4, 80.0, EstadoReserva.PENDIENTE, "terraza"));
        r.addReserva(new Reserva(c3, hoy.plusDays(30), LocalTime.of(13, 30), 3, 45.0, EstadoReserva.ATENDIDA, "barra"));
        r.addReserva(new Reserva(c4, hoy.plusDays(11), LocalTime.of(22, 0), 5, 100.0, EstadoReserva.CANCELADA, "terraza"));
        r.addReserva(new Reserva(c5, hoy.plusDays(43), LocalTime.of(14, 30), 2, 35.0, EstadoReserva.CONFIRMADA, "interior"));
        r.addReserva(new Reserva(c6, hoy.plusDays(25), LocalTime.of(21, 0), 6, 120.0, EstadoReserva.PENDIENTE, "terraza"));
        r.addReserva(new Reserva(c7, hoy.plusDays(20), LocalTime.of(13, 0), 2, 25.0, EstadoReserva.ATENDIDA, "barra"));
        r.addReserva(new Reserva(c8, hoy.plusDays(16), LocalTime.of(20, 30), 4, 75.0, EstadoReserva.CONFIRMADA, "interior"));
        r.addReserva(new Reserva(c1, hoy.plusDays(17), LocalTime.of(14, 0), 3, 50.0, EstadoReserva.PENDIENTE, "terraza"));
        r.addReserva(new Reserva(c2, hoy.plusDays(13), LocalTime.of(22, 30), 2, 40.0, EstadoReserva.CANCELADA, "barra"));
        r.addReserva(new Reserva(c3, hoy.plusDays(8), LocalTime.of(13, 30), 5, 90.0, EstadoReserva.CONFIRMADA, "terraza"));
        r.addReserva(new Reserva(c4, hoy.plusDays(12), LocalTime.of(21, 0), 2, 30.0, EstadoReserva.ATENDIDA, "interior"));
        r.addReserva(new Reserva(c5, hoy.plusDays(20), LocalTime.of(14, 0), 4, 70.0, EstadoReserva.PENDIENTE, "barra"));
        r.addReserva(new Reserva(c6, hoy.plusDays(28), LocalTime.of(22, 0), 3, 60.0, EstadoReserva.CONFIRMADA, "terraza"));
        r.addReserva(new Reserva(c7, hoy.plusDays(21), LocalTime.of(13, 0), 2, 20.0, EstadoReserva.CANCELADA, "interior"));
        r.addReserva(new Reserva(c8, hoy.plusDays(9), LocalTime.of(15, 15), 10, 75.0, EstadoReserva.CONFIRMADA, "Interior"));

        // MOSTRAR DATOS
        System.out.println(r);
    }
}
