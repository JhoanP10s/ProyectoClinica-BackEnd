package PruebaTecnicaClinicaVenko.PruebaTecnicaClinicaVenko.models;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table (name = "Paciente")
public class PacienteModel {

    //Atributos
    @Id
    private String numeroDocumento;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String tipoDocumento;
	private LocalDate fechaExpedicionDoc;

    public PacienteModel(){
        super();
    }

    public PacienteModel(String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido,
            String segundoApellido, String tipoDocumento, LocalDate fechaExpedicionDoc) {
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.tipoDocumento = tipoDocumento;
        this.fechaExpedicionDoc = fechaExpedicionDoc;
    }

    //Getters & Setters

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public LocalDate getFechaExpedicionDoc() {
        return fechaExpedicionDoc;
    }

    public void setFechaExpedicionDoc(LocalDate fechaExpedicionDoc) {
        this.fechaExpedicionDoc = fechaExpedicionDoc;
    }



}
