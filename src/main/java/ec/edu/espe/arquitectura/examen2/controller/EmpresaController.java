package ec.edu.espe.arquitectura.examen2.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.examen2.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examen2.model.Empresa;
import ec.edu.espe.arquitectura.examen2.service.EmpresaService;

@RestController
@RequestMapping("/api/v2/empresa")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<Empresa> empresaCreate(@RequestBody EmpresaRQ empresa) {
        try {
            Empresa empresaRS = this.empresaService.createEmpresa(empresa);
            return ResponseEntity.ok(empresaRS);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
