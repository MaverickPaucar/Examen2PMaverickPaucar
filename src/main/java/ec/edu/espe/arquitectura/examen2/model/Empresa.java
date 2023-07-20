package ec.edu.espe.arquitectura.examen2.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "Empresa")
@CompoundIndex(name = "idx_empresa_ruc_cuentaprincipal", def = "{'ruc':1, 'cuentaPrincipal':1}", unique = true)
public class Empresa {
    @Id
    private String id;

    private String ruc;
    private String razonSocial;
    private String cuentaPrincipal;

    private List<Empleado> empleados;
}
