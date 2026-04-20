package servicio;

import modelo.Cliente;
import modelo.EstadoReserva;
import modelo.Reserva;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * getTotalPrevistoAtendidas(): calcular la suma total de importePrevisto de todas las reservas
     * con estado ATENDIDA.
     */
    //6. Total previsto de reservas atendidas
    public double getTotalPrevistoAtendidas() {
        return reservas.stream()
                .filter(r -> r.getEstado().equals(EstadoReserva.ATENDIDA))
                .mapToDouble(r -> r.getImportePrevisto())
                .sum();
    }

    /**
     * getReservasPorEstado(): crear un mapa donde la clave sea el estado de la reserva y el valor sea
     * el número total de reservas de ese estado.
     */
    //7. Número de reservas por estado
    public Map<EstadoReserva, Long> getReservasPorEstado() {
        return reservas.stream()
                .collect(Collectors.groupingBy(Reserva::getEstado,
                        Collectors.counting()));
    }

    /**
     * getReservasPorZona(): crear un mapa donde la clave sea la zona ( terraza , salon , barra , etc.)
     * y el valor sea el número de reservas de esa zona.
     */
    //8. Número de reservas por zona
    public Map<String, Long> getReservasPorZona() {
        return reservas.stream()
                .collect(Collectors.groupingBy(Reserva::getZona,
                        Collectors.counting()));
    }

    /**
     * getReservasAgrupadasPorFecha(): crear un mapa donde la clave sea la fecha y el valor sea la
     * lista de reservas de ese día.
     */
    //9. Reservas agrupadas por fecha
    public Map<LocalDate, List<Reserva>> getReservasAgrupadasPorFecha() {
        return reservas.stream()
                .collect(Collectors.groupingBy(Reserva::getFecha));
    }

    /**
     * getClienteTop(): obtener el cliente que más reservas tiene en el restaurante.
     */
    //10. Cliente con más reservas
    public Optional<Cliente> getClienteTop() {
        return reservas.stream()
                .collect(Collectors.groupingBy(Reserva::getCliente,
                        Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    /**
     * getTotalPrevistoAgrupadoPorFecha(): mostrar la suma del importe previsto de las reservas
     * agrupada por fecha.
     */
    //11. Recaudación prevista por fecha
     public Map<LocalDate, Double> getTotalPrevistoAgrupadoPorFecha() {
        return reservas.stream()
                .collect(Collectors.groupingBy(Reserva::getFecha,
                        Collectors.summingDouble(Reserva::getImportePrevisto)));
    }

    /**
     * getEstadisticasNumPersonas(): obtener estadísticas sobre el número de personas por reserva:
     */
    //12. Estadísticas de comensales
    public DoubleSummaryStatistics getEstadisticasNumPersonas() {
        return reservas.stream()
                .collect(Collectors.summarizingDouble(Reserva::getNumPersonas));
    }

    /**
     * getClientes(): mostrar la lista de clientes ordenada por nombre
     */
    //13. Clientes ordenados alfabéticamente
    public List<Cliente> getClientes() {
        return reservas.stream()
                .map(r -> r.getCliente())
                .distinct()
                .sorted(Comparator.comparing(Cliente::getNombre))
                .toList();
    }

    /**
     * getReservasFuturasAgrupadasPorFecha(): crear un mapa donde la clave sea la fecha y el valor
     * sea la lista de reservas de ese día, para las reservas a partir de hoy. Las reservas deben estar
     * previamente ordenadas por fecha.
     */
    //14. Reservas futuras
    public Map<LocalDate, List<Reserva>> getReservasFuturasAgrupadasPorFecha() {
        return reservas.stream()
                .filter(r -> !r.getFecha().isBefore(LocalDate.now()))
                .sorted(Comparator.comparing(Reserva::getFecha))
                .collect(Collectors.groupingBy(Reserva::getFecha));
    }

    /**
     * getPorcentajeCanceladas(): calcular qué porcentaje del total de reservas están canceladas.
     */
    //15. Porcentaje de reservas canceladas
    public double getPorcentajeCanceladas() {
        long ReservasCanceladas = reservas.stream()
                .filter(r -> r.getEstado().equals(EstadoReserva.CANCELADA))
                .count();
        return ((double) ReservasCanceladas / reservas.size()) * 100;
    }


}




