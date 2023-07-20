package ec.edu.espe.arquitectura.examen2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpresaRQ {
    private String ruc;
    private String razonSocial;
    private String cuentaPrincipal;
}
