package ec.edu.espe.arquitectura.examen2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.arquitectura.examen2.model.PagoRol;

public interface PagoRolRepository extends MongoRepository<PagoRol, String> {
    PagoRol findFirstByMesAndRucEmpresa(String mes, String ruc);
}
