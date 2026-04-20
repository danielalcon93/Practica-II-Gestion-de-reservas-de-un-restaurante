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
        return "DNI: " + dni +
                " | Nombre: " + nombre +
                " | " + email +
                " | " + telefono +
                " | " + ciudad + "\n";
    }
}

