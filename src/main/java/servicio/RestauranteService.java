package servicio;

import modelo.EstadoReserva;
import modelo.Reserva;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RestauranteService {

    private List<Reserva> reservas;
    public RestauranteService(List<Reserva> reservas) {
        this.reservas = reservas;
    }


        /**
         * getReservasConfirmadas(LocalDate fecha): mostrar todas las reservas con estado CONFIRMADA
         * de una fecha dada, ordenadas por hora de forma ascendente
         */
    //1. Reservas confirmadas de una fecha concreta
    public List<Reserva> getReservasConfirmadas(LocalDate fecha) {
        return reservas.stream()
                .filter(r -> r.getFecha().equals(fecha))
                .filter(r -> r.getEstado() == EstadoReserva.CONFIRMADA)
                .sorted(Comparator.comparing(Reserva::getHora))
                .toList();
    }

        /**
         * getReservasGrandes(int numPersonas): mostrar las reservas que tengan más de un número
         * dado de personas, por ejemplo más de 4.
         */
    //2. Reservas de más de X personas
    public List<Reserva> getReservasGrandes(int numPersonas) {
        return reservas.stream()
                .filter(r -> r.getNumPersonas() > numPersonas)
                .toList();
        }

    /**
     *getPrimeraCancelada(): buscar la primera reserva cancelada de la lista.
     */
    //3. Primera reserva cancelada
    public Optional<Reserva> getPrimeraCancelada() {
        return reservas.stream()
                .filter(r -> r.getEstado() == EstadoReserva.CANCELADA)
                .findFirst();
    }

    /**
     * getReservasOrdenadas(LocalDate fecha): mostrar todas las reservas no canceladas ordenadas
     * de mayor a menor número de personas en una fecha determinada.
     */
    //4. Reservas ordenadas por número de personas
    public List<Reserva> getReservasOrdenadas(LocalDate fecha) {
        return reservas.stream()
                .filter(r -> r.getFecha().equals(fecha))
                .filter(r -> r.getEstado() != EstadoReserva.CANCELADA)
                .sorted(Comparator.comparing(Reserva::getNumPersonas).reversed())
                .toList();
    }

    /**
     * getClientesReservasGrandes(): obtener los nombres de los clientes que tengan alguna reserva
     * de más de 6 personas.
     */
    //5.Clientes con reservas grandes
    public List<String> getClientesReservasGrandes() {
        return reservas.stream()
                .filter(r -> r.getNumPersonas() > 6)
                .map(r -> r.getCliente().getNombre())
                .distinct()
                .toList();
    }
























}




