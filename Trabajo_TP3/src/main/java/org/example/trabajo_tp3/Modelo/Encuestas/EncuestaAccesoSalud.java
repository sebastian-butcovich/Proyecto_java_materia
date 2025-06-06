package org.example.trabajo_tp3.Modelo.Encuestas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
@Entity
public class EncuestaAccesoSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //preguntas 16 a 23
    private String centroSaludPrincipal;
    private List<String> dificultadesAtencion;
    private List<String> disciplinasConsultadas;
    private Boolean consultaSaludMental;
    private String lugarSaludMental;
    private Boolean accesoOportunoSaludMental;
    private String motivoNoAccesoSaludMental;
    private Boolean saludMentalDerivado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCentroSaludPrincipal() {
        return centroSaludPrincipal;
    }

    public void setCentroSaludPrincipal(String centroSaludPrincipal) {
        this.centroSaludPrincipal = centroSaludPrincipal;
    }

    public List<String> getDificultadesAtencion() {
        return dificultadesAtencion;
    }

    public void setDificultadesAtencion(List<String> dificultadesAtencion) {
        this.dificultadesAtencion = dificultadesAtencion;
    }

    public List<String> getDisciplinasConsultadas() {
        return disciplinasConsultadas;
    }

    public void setDisciplinasConsultadas(List<String> disciplinasConsultadas) {
        this.disciplinasConsultadas = disciplinasConsultadas;
    }

    public Boolean getConsultaSaludMental() {
        return consultaSaludMental;
    }

    public void setConsultaSaludMental(Boolean consultaSaludMental) {
        this.consultaSaludMental = consultaSaludMental;
    }

    public String getLugarSaludMental() {
        return lugarSaludMental;
    }

    public void setLugarSaludMental(String lugarSaludMental) {
        this.lugarSaludMental = lugarSaludMental;
    }

    public Boolean getAccesoOportunoSaludMental() {
        return accesoOportunoSaludMental;
    }

    public void setAccesoOportunoSaludMental(Boolean accesoOportunoSaludMental) {
        this.accesoOportunoSaludMental = accesoOportunoSaludMental;
    }

    public String getMotivoNoAccesoSaludMental() {
        return motivoNoAccesoSaludMental;
    }

    public void setMotivoNoAccesoSaludMental(String motivoNoAccesoSaludMental) {
        this.motivoNoAccesoSaludMental = motivoNoAccesoSaludMental;
    }

    public Boolean getSaludMentalDerivado() {
        return saludMentalDerivado;
    }

    public void setSaludMentalDerivado(Boolean saludMentalDerivado) {
        this.saludMentalDerivado = saludMentalDerivado;
    }
}
