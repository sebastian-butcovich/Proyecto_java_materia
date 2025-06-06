package org.example.trabajo_tp3.Modelo.Encuestas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
@Entity
public class EncuestaBarrio {
    //preguntas 24 a 27
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Boolean participaInstituciones;
    //Esto tiene que ser una tabla
    private List<String> institucionesBarrio;
    //Esto tiene que ser una tabla
    private List<String> serviciosBarrio;
    //Esto tiene que ser una tabla
    private List<String> problemasBarrio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getParticipaInstituciones() {
        return participaInstituciones;
    }

    public void setParticipaInstituciones(Boolean participaInstituciones) {
        this.participaInstituciones = participaInstituciones;
    }

    public List<String> getInstitucionesBarrio() {
        return institucionesBarrio;
    }

    public void setInstitucionesBarrio(List<String> institucionesBarrio) {
        this.institucionesBarrio = institucionesBarrio;
    }

    public List<String> getServiciosBarrio() {
        return serviciosBarrio;
    }

    public void setServiciosBarrio(List<String> serviciosBarrio) {
        this.serviciosBarrio = serviciosBarrio;
    }

    public List<String> getProblemasBarrio() {
        return problemasBarrio;
    }

    public void setProblemasBarrio(List<String> problemasBarrio) {
        this.problemasBarrio = problemasBarrio;
    }
}