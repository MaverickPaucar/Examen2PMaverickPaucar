package ec.edu.espe.arquitectura.examen2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examen2.dto.EmpleadoRQ;
import ec.edu.espe.arquitectura.examen2.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examen2.model.Empleado;
import ec.edu.espe.arquitectura.examen2.model.Empresa;
import ec.edu.espe.arquitectura.examen2.repository.EmpresaRepository;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa createEmpresa(EmpresaRQ empresaRq) {
        Empresa empresa = this.transformEmpresaRQ(empresaRq);
        Empresa empresaTmp = this.empresaRepository.findFirstByRuc(empresa.getRuc());
        if (empresaTmp == null) {
            return this.empresaRepository.save(empresa);
        } else {
            throw new RuntimeException("Empresa con RUC " + empresa.getRuc() + " ya existe");
        }
    }

    private Empresa transformEmpresaRQ(EmpresaRQ rq) {
        Empresa empresa = Empresa.builder().ruc(rq.getRuc()).razonSocial(rq.getRazonSocial())
                .cuentaPrincipal(rq.getCuentaPrincipal()).build();
        return empresa;
    }

    private List<Empleado> transformEmpleadoRQ(List<EmpleadoRQ> rq) {
        List<Empleado> empleadoList = new ArrayList<>();
        for (EmpleadoRQ empleadoRq : rq) {
            Empleado empleado = Empleado.builder().cedula(empleadoRq.getCedula()).apellidos(empleadoRq.getApellidos())
                    .nombres(empleadoRq.getNombres()).nroCuenta(empleadoRq.getNroCuenta()).build();
            empleadoList.add(empleado);
        }
        return empleadoList;
    }

    public Empresa addEmpleados(String ruc, List<EmpleadoRQ> empleados) {
        Empresa empresaTmp = this.empresaRepository.findFirstByRuc(ruc);
        if (empresaTmp == null) {
            throw new RuntimeException("La empresa no existe");
        } else {
            List<Empleado> nuevosEmpleados = this.transformEmpleadoRQ(empleados);
            empresaTmp.setEmpleados(nuevosEmpleados);
        }
        return this.empresaRepository.save(empresaTmp);
    }
}
