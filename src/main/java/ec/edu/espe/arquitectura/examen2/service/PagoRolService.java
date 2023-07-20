package ec.edu.espe.arquitectura.examen2.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examen2.dto.PagoRolRQ;
import ec.edu.espe.arquitectura.examen2.model.PagoRol;
import ec.edu.espe.arquitectura.examen2.repository.PagoRolRepository;

@Service
public class PagoRolService {
    private final PagoRolRepository pagoRolRepository;

    public PagoRolService(PagoRolRepository pagoRolRepository) {
        this.pagoRolRepository = pagoRolRepository;
    }

    public void createPagoRol(PagoRolRQ pagoRolRq) {
        PagoRol pagoRol = this.transformPagoRolRQ(pagoRolRq);
        PagoRol pagoRolTmp = this.pagoRolRepository.findFirstByMesAndRucEmpresa(pagoRol.getMes(),
                pagoRol.getRucEmpresa());
        if (pagoRolTmp == null) {
            this.pagoRolRepository.save(pagoRol);
        } else {
            throw new RuntimeException("Ya existe el pago en el mes " + pagoRol.getMes() + " de la empresa con el RUC"
                    + pagoRol.getRucEmpresa());
        }
    }

    private PagoRol transformPagoRolRQ(PagoRolRQ rq) {
        PagoRol pagoRol = PagoRol.builder().mes(rq.getMes()).rucEmpresa(rq.getRucEmpresa())
                .cuentaPrincipal(rq.getCuentaPrincipal()).valorTotal(rq.getValorTotal()).valorReal(rq.getValorReal())
                .build();
        return pagoRol;
    }
}
