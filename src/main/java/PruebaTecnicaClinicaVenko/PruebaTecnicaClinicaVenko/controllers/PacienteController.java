package PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.models.PacienteModel;
import PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.repository.PacienteRepository;
import PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.services.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pR;

    @Autowired
    private PacienteService pS;

    //Obtener todos los pacientes
    @GetMapping
    private Iterable<PacienteModel> getAllPaciente(){
        return pR.findAll();
    }

    //Mostrar informacion de paciente
    @GetMapping("{cc}")
    private ResponseEntity<?> getPaciente(@PathVariable("cc") String pacienteCC) {
        PacienteModel paciente = pS.verPaciente(pacienteCC);

        if (paciente == null) {
            return ResponseEntity.badRequest().body("No existe paciente registrado");
        } else {
            return ResponseEntity.ok(paciente);
        }
    }

    //Crea y valida Paciente por cc y tipoDoc
    @PostMapping("/crearPaciente")
    private ResponseEntity<String> crearPaciente(@RequestBody PacienteModel paciente) {
        String p = pS.crearPaciente(paciente);

        if ( p.contains("Paciente se ha registrado exitosamente")) {
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.badRequest().body(p);
        }
    }

    //Editar paciente por cc
    @PutMapping("{cc}")
    private String editarPaciente (@PathVariable("cc") String pacienteCC, @RequestBody PacienteModel paciente) {
        return pS.editarPaciente(pacienteCC, paciente);
    }

    //Eliminar paciente por cc
    @DeleteMapping("/eliminarPaciente/{cc}")
    private String eliminarPaciente (@PathVariable("cc") String pacienteCC) {
        return pS.eliminarPaciente(pacienteCC);
    }

}
