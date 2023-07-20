package ec.edu.espe.arquitectura.examen2.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "PagoRol")
@CompoundIndex(name = "idx_pagorol_mes_ruc", def = "{'mes':1, 'rucEmpresa':1}")
public class PagoRol {
    @Id
    private String id;

    private String mes;
    private String rucEmpresa;
    private String cuentaPrincipal;
    private BigDecimal valorTotal;
    private BigDecimal valorReal;

    private List<EmpleadoPago> empleadosPago;
}
