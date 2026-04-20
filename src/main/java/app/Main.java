package app;

import modelo.Cliente;
import modelo.EstadoReserva;
import modelo.Reserva;
import servicio.Restaurante;
import servicio.RestauranteService;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

        //Clientes
        public static void cargarClientes(Restaurante restaurante) {
            restaurante.addCliente(new Cliente("48273615M", "Ana Pérez", "673829154", "ana@email.com", "Sevilla"));
            restaurante.addCliente(new Cliente("59384726K", "Luis Gómez", "612947385", "luis@email.com", "Madrid"));
            restaurante.addCliente(new Cliente("74125896T", "Marta Ruiz", "698231457", "marta@email.com", "Valencia"));
            restaurante.addCliente(new Cliente("36925814P", "Carlos López", "645782319", "carlos@email.com", "Málaga"));
            restaurante.addCliente(new Cliente("85274163L", "Lucía Torres", "679314825", "lucia@email.com", "Granada"));
            restaurante.addCliente(new Cliente("14785236R", "Pedro Díaz", "622518947", "pedro@email.com", "Bilbao"));
            restaurante.addCliente(new Cliente("96385274S", "Sara León", "687429153", "sara@email.com", "Zaragoza"));
            restaurante.addCliente(new Cliente("25836914N", "David Castro", "655193728", "david@email.com", "Alicante"));
        }


        // RESERVAS
        public static void cargarReservas(Restaurante restaurante) {
            LocalDate hoy = LocalDate.now();

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("48273615M"),
                    hoy,
                    LocalTime.of(14, 0),
                    2,
                    30.0,
                    EstadoReserva.CONFIRMADA,
                    "interior"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("59384726K"),
                    hoy,
                    LocalTime.of(16, 0),
                    4,
                    80.0,
                    EstadoReserva.CONFIRMADA,
                    "terraza"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("74125896T"),
                    hoy,
                    LocalTime.of(18, 30),
                    3,
                    45.0,
                    EstadoReserva.CONFIRMADA,
                    "barra"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("36925814P"),
                    hoy,
                    LocalTime.of(20, 0),
                    5,
                    100.0,
                    EstadoReserva.CONFIRMADA,
                    "terraza"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("85274163L"),
                    hoy,
                    LocalTime.of(22, 0),
                    2,
                    35.0,
                    EstadoReserva.CONFIRMADA,
                    "interior"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("14785236R"),
                    hoy.plusDays(25),
                    LocalTime.of(21, 0),
                    6,
                    120.0,
                    EstadoReserva.PENDIENTE,
                    "terraza"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("96385274S"),
                    hoy.plusDays(20),
                    LocalTime.of(13, 0),
                    2,
                    25.0,
                    EstadoReserva.ATENDIDA,
                    "barra"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("25836914N"),
                    hoy.plusDays(16),
                    LocalTime.of(20, 30),
                    4,
                    75.0,
                    EstadoReserva.CONFIRMADA,
                    "interior"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("48273615M"),
                    hoy.plusDays(17),
                    LocalTime.of(14, 0),
                    3,
                    50.0,
                    EstadoReserva.PENDIENTE,
                    "terraza"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("59384726K"),
                    hoy.plusDays(13),
                    LocalTime.of(22, 30),
                    2,
                    40.0,
                    EstadoReserva.CANCELADA,
                    "barra"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("74125896T"),
                    hoy.plusDays(8),
                    LocalTime.of(13, 30),
                    5,
                    90.0,
                    EstadoReserva.CONFIRMADA,
                    "terraza"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("36925814P"),
                    hoy.plusDays(12),
                    LocalTime.of(21, 0),
                    2,
                    30.0,
                    EstadoReserva.ATENDIDA,
                    "interior"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("85274163L"),
                    hoy.plusDays(20),
                    LocalTime.of(14, 0),
                    4,
                    70.0,
                    EstadoReserva.PENDIENTE,
                    "barra"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("14785236R"),
                    hoy.plusDays(28),
                    LocalTime.of(22, 0),
                    3,
                    60.0,
                    EstadoReserva.CONFIRMADA,
                    "terraza"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("96385274S"),
                    hoy.plusDays(21),
                    LocalTime.of(13, 0),
                    2,
                    20.0,
                    EstadoReserva.CANCELADA,
                    "interior"));

            restaurante.addReserva(new Reserva(
                    restaurante.getClientePorDni("25836914N"),
                    hoy.plusDays(9),
                    LocalTime.of(15, 15),
                    10,
                    75.0,
                    EstadoReserva.CONFIRMADA,
                    "interior"));
        }

        static void main(String[] args) {
                Restaurante r = new Restaurante("Bar leyendas");

                // CLIENTES
                cargarClientes(r);
                // RESERVAS
                cargarReservas(r);

                //Creamos el servicio
                RestauranteService reservas = new RestauranteService(r.getReservas());

        //Consultas
            IO.println("--- 1. ---> Reservas confirmadas de hoy");
            reservas.getReservasConfirmadas(LocalDate.now()).forEach(System.out::println);

            IO.println("--- 2. ---> Reservas de más de 4 personas");
            reservas.getReservasGrandes(4).forEach(System.out::println);

            IO.println("--- 3. ---> Primera reserva cancelada");
            reservas.getPrimeraCancelada().ifPresent(System.out::println);

            IO.println("--- 4. ---> Reservas ordenadas por personas");
            reservas.getReservasOrdenadas(LocalDate.now()).forEach(System.out::println);

            IO.println("--- 5. ---> Clientes con reservas grandes");
            reservas.getClientesReservasGrandes().forEach(System.out::println);

            IO.println("--- 6. ---> Total previsto atendidas");
            IO.println(reservas.getTotalPrevistoAtendidas());

            IO.println("--- 7. ---> Número de reservas por estado");
            reservas.getReservasPorEstado().forEach((k,v) -> IO.println(k + ": " + v));

            IO.println("--- 8. ---> Número de reservas por zona");
            reservas.getReservasPorZona().forEach((k,v) -> IO.println(k + ": " + v));

            IO.println("--- 9. ---> Reservas agrupadas por fecha");
            reservas.getReservasAgrupadasPorFecha().forEach((k,v) -> IO.println(k + ": " + v));

            IO.println("--- 10. ---> Cliente con más reservas");
            reservas.getClienteTop().ifPresent(System.out::println);

            IO.println("--- 11. ---> Recaudación por fecha");
            reservas.getTotalPrevistoAgrupadoPorFecha().forEach((k,v) -> IO.println(k + ": " + v));

            IO.println("--- 12. ---> Estadísticas de comensales");
            IO.println(reservas.getEstadisticasNumPersonas());

            IO.println("--- 13. ---> Clientes ordenados");
            reservas.getClientes().forEach(System.out::println);

            IO.println("--- 14. ---> Reservas futuras agrupadas");
            reservas.getReservasFuturasAgrupadasPorFecha().forEach((k,v) -> IO.println(k + ": " + v));

            IO.println("--- 15. ---> Porcentaje canceladas");
            IO.println(reservas.getPorcentajeCanceladas() + "%");
        }
}

