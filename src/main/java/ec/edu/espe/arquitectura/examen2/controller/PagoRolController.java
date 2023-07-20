package ec.edu.espe.arquitectura.examen2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.examen2.service.PagoRolService;

@RestController
@RequestMapping("/api/v2/pagoRol")
public class PagoRolController {
    private final PagoRolService pagoRolService;

    public PagoRolController(PagoRolService pagoRolService) {
        this.pagoRolService = pagoRolService;
    }

}
