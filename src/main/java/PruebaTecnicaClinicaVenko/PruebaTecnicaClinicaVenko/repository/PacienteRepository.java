package PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.models.PacienteModel;

public interface PacienteRepository extends JpaRepository <PacienteModel, Long>{

    PacienteModel findByNumeroDocumento(String cc);
    PacienteModel findByNumeroDocumentoAndTipoDocumento(String cc, String tipoDoc);
}
