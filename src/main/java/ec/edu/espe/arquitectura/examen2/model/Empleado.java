package ec.edu.espe.arquitectura.examen2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Empleado {
    private String cedula;
    private String apellidos;
    private String nombres;
    private String nroCuenta;
}
