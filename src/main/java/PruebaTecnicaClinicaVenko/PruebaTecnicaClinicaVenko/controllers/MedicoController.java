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

import PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.models.MedicoModel;
import PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.repository.MedicoRepository;
import PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.services.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository mR;

    @Autowired
    private MedicoService mS;

    //Obtener todos los medicos 
    @GetMapping
    private Iterable<MedicoModel> getAllMedico(){
        return mR.findAll();
    }

    //Mostrar informacion de medico
    @GetMapping("{cc}")
    private ResponseEntity<?> getMedico(@PathVariable("cc") String medicoCC){

        MedicoModel medico = mS.verMedico(medicoCC);

        if (medico == null){
            return ResponseEntity.badRequest().body("No existe medico registrado");
        } else {
            return ResponseEntity.ok(medico);
        }
    }
    
    //Crea y valida Medico por cc y tipoDoc
    @PostMapping("/crearMedico")
    private ResponseEntity<String> crearMedico(@RequestBody MedicoModel medico){

        String m = mS.crearMedico(medico);

        if (m.contains("Medico se ha registrado exitosamente")){
            return ResponseEntity.ok(m);
        } else {
            return ResponseEntity.badRequest().body(m);
        }
    }

    //Editar medico por cedula
    @PutMapping("{cc}")
    private String editarMedico(@PathVariable("cc") String medicoCC, @RequestBody MedicoModel medico){
        return mS.editarMedico(medicoCC, medico);
    }

    //Eliminar medico por cedula
    @DeleteMapping("/eliminarMedico/{cc}")
    private String eliminarMedico(@PathVariable("cc")String medicoCC) {
        return mS.eliminarMedico(medicoCC);
    }


}
