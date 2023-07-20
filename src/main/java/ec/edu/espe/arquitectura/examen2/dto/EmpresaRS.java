package ec.edu.espe.arquitectura.examen2.dto;

import java.util.List;

import ec.edu.espe.arquitectura.examen2.model.Empleado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpresaRS {
    private String ruc;
    private String razonSocial;
    private String cuentaPrincipal;

    private List<Empleado> phoneNumbers;
}
