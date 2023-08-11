package PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.models.PacienteModel;
import PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pR;

    //Encontrar el paciente por el numero de documento
    public PacienteModel verPaciente (String cc){
        PacienteModel paciente=pR.findByNumeroDocumento(cc);
        return paciente;
    }

    //Crear paciente
    public String crearPaciente(PacienteModel paciente) {
        // Validar si ya existe un médico con el mismo tipo y número de documento
        if (pR.findByNumeroDocumentoAndTipoDocumento(paciente.getNumeroDocumento(), paciente.getTipoDocumento()) != null ){
            return "Ya existe un paciente con el mismo tipo y numero de documento.";
        } else {

            if ( pR.findByNumeroDocumento(paciente.getNumeroDocumento()) != null ) {
                return "Ya existe un paciente con el mismo numero de documento.";
            } else {
                pR.save(paciente);
                return "Paciente creado exitosamente";
            }
        }
    }

    //Editar paciente
    public String editarPaciente(String cc, PacienteModel paciente){

        if (pR.findByNumeroDocumento(cc) != null){

            PacienteModel pacienteUpdate = pR.findByNumeroDocumento(cc);
            // Mantener el número de documento y actualizar otros campos
            pacienteUpdate.setPrimerNombre(paciente.getPrimerNombre());
            pacienteUpdate.setSegundoNombre(paciente.getSegundoNombre());
            pacienteUpdate.setPrimerApellido(paciente.getPrimerApellido());
            pacienteUpdate.setSegundoApellido(paciente.getSegundoApellido());
            pacienteUpdate.setTipoDocumento(paciente.getTipoDocumento());
            pacienteUpdate.setFechaExpedicionDoc(paciente.getFechaExpedicionDoc());

            pR.save(pacienteUpdate);
            return "Paciente editado exitosamente";
        } else{
            return "Paciente no existe";
        }
    }

    //Eliminar paciente
    public String eliminarPaciente (String cc) {
        PacienteModel paciente = pR.findByNumeroDocumento(cc);

        if (paciente == null){
            return "Error, no se puede eliminar Paciente.";
        } else {
            pR.delete(paciente);
            return "Paciente eliminado exitosamente";
        }
    }

}
