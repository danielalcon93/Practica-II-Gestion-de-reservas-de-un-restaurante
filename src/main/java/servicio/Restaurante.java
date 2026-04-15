package servicio;

import lombok.Getter;
import lombok.Setter;
import modelo.Cliente;
import modelo.Reserva;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Restaurante {

    private String nombre;
    private List<Cliente> clientes = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    //Constructor
    public Restaurante(String nombre) {
        this.nombre = nombre;
    }

    //Metodos

    /**
     * Añade Clientes
     * @param cliente
     */
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }


    /**
     * Añade reservas
     * @param reserva
     */
    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }


    /**
     * Busca Clientes por Dni
     * @param dni
     * @return Devuelve el cliente si encuentra su DNI
     * @null Si no lo encuentra devuelve null
     */
    public Cliente getClientePorDni(String dni){
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * Busca en la lista las reservas
     * @return el listado de reservas encontradas
     */
    public List<Reserva> getReservas() {
        return reservas;
    }


    //ToString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Restaurante{\n");
        sb.append("nombre='").append(nombre).append("'\n");
        sb.append("clientes=").append(clientes).append("\n");
        sb.append("reservas=").append(reservas).append("\n");
        sb.append('}').append('\n');
        return sb.toString();
    }
}
