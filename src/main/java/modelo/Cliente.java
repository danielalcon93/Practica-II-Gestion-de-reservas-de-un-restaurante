package modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Cliente {

    private String dni;
    private String nombre;
    private String telefono;
    private String email;
    private String ciudad;

    //ToString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DNI: ");
        sb.append(dni);
        sb.append(" | Nombre: ").append(nombre);
        sb.append(" | ").append(email);
        sb.append(" | ").append(telefono);
        sb.append(" | ").append(ciudad).append('\n');
        return sb.toString();
    }
}

