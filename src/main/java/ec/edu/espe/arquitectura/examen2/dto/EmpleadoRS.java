package ec.edu.espe.arquitectura.examen2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadoRS {
    private String cedula;
    private String apellidos;
    private String nombres;
    private String nroCuenta;
}
