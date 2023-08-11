package PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.models.MedicoModel;

public interface MedicoRepository extends JpaRepository <MedicoModel, Long>{
    
    MedicoModel findByNumeroDocumento(String cc);
    MedicoModel findByNumeroDocumentoAndTipoDocumento(String cc, String tipoDoc);
    
}
