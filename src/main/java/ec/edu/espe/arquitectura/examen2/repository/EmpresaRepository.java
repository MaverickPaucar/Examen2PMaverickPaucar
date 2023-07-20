package ec.edu.espe.arquitectura.examen2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.arquitectura.examen2.model.Empresa;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {
    Empresa findFirstByRuc(String ruc);
}
