package ec.edu.espe.arquitectura.examen2.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class EmpleadoPagoRQ {
    private String nroCuenta;
    private BigDecimal valor;
    private String estado;
}
