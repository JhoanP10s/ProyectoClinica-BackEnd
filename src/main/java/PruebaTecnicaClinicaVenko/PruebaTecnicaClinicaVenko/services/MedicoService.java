package PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.models.MedicoModel;
import PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.repository.MedicoRepository;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository mR;

    //Encontrar el medico por el numero de documento
    public MedicoModel verMedico(String cc){
        MedicoModel medico=mR.findByNumeroDocumento(cc);
        return medico;
    }

    //Crear medico
    public String crearMedico(MedicoModel medico){
        // Validar si ya existe un médico con el mismo tipo y número de documento
        if (mR.findByNumeroDocumentoAndTipoDocumento(medico.getNumeroDocumento(), medico.getTipoDocumento()) != null ){
            return "Ya existe un medico con el mismo tipo y numero de documento.";
        } else {
            if (mR.findByNumeroDocumento(medico.getNumeroDocumento()) != null ){
                return "Ya existe un medico con el mismo numero de documento";
            } else{
                mR.save(medico);
                return "Medico creado exitosamente";
            }
        }
    }

    //Editar medico
    public String editarMedico(String cc, MedicoModel medico){

        if (mR.findByNumeroDocumento(cc) != null){

            MedicoModel medicoUpdate=mR.findByNumeroDocumento(cc);
            // Mantener el número de documento y actualizar otros campos
            medicoUpdate.setPrimerNombre(medico.getPrimerNombre());
            medicoUpdate.setSegundoNombre(medico.getSegundoNombre());
            medicoUpdate.setPrimerApellido(medico.getPrimerApellido());
            medicoUpdate.setSegundoApellido(medico.getSegundoApellido());
            medicoUpdate.setTipoDocumento(medico.getTipoDocumento());
            medicoUpdate.setFechaExpedicionDoc(medico.getFechaExpedicionDoc());

            mR.save(medicoUpdate);
            return "Medico editado exitosamente";
        } else{
            return "Medico no existe";
        }
    }

    //Eliminar medico
    public String eliminarMedico(String cc){
        MedicoModel medico = mR.findByNumeroDocumento(cc);

        if (medico == null){
            return "Error, no se puede eliminar Medico.";
        } else {
            mR.delete(medico);
            return "Medico eliminado exitosamente.";
        }
    }

}
