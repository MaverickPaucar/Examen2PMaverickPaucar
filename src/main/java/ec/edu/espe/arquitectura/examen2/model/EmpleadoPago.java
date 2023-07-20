package ec.edu.espe.arquitectura.examen2.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class EmpleadoPago {
    private String nroCuenta;
    private BigDecimal valor;
    private String estado;
}
