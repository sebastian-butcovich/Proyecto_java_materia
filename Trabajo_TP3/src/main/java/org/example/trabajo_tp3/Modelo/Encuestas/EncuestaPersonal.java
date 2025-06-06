package org.example.trabajo_tp3.Modelo.Encuestas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;
@Entity
public class EncuestaPersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //preguntas 30 a 58
    private Integer numeroPersona;
    private Integer edad;
    private Integer edadMeses; //si tiene menos de un aÃ±o
    private String identidadGenero;
    private String paisNacimiento;
    private Boolean sabeLeerEscribir;
    private String nivelEducativo;
    private Boolean trabajoSemanaPasada;
    private Boolean trabajaEnBlanco;
    // No se qué es eso
    private List<String> ramasTrabajo;
    private Boolean realizaTareasDomesticas;
    private Boolean cobraJubilacionOPension;
    private Boolean auditablePorPension;
    private Boolean programaEstado;
    private List<String> programasEstado;
    private List<String> coberturaSalud;
    private String ultimoControlSalud;
    private Boolean vacunacionCompleta;
    private Boolean accesoVacunasUrgentes;
    private List<String> fuentesCalendarioVacunas;
    private List<String> enfermedades; //enum con los tipos de enfermedades
    private Boolean consumoSustancias;
    private List<String> sustanciasConsumidas;
    private Boolean sufrioViolencia;
    private Boolean tieneDiscapacidad;
    private List<String> tipoDiscapacidad;
    private Boolean tieneCUD; //certificado discapacidad
    private Date fechaVencimientoCUD;
    private Boolean embarazada;
    private String trimestre;
    private Integer controlesEmbarazo;
    private List<String> lugaresControlEmbarazo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getLugaresControlEmbarazo() {
        return lugaresControlEmbarazo;
    }

    public void setLugaresControlEmbarazo(List<String> lugaresControlEmbarazo) {
        this.lugaresControlEmbarazo = lugaresControlEmbarazo;
    }

    public Integer getControlesEmbarazo() {
        return controlesEmbarazo;
    }

    public void setControlesEmbarazo(Integer controlesEmbarazo) {
        this.controlesEmbarazo = controlesEmbarazo;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    public Boolean getEmbarazada() {
        return embarazada;
    }

    public void setEmbarazada(Boolean embarazada) {
        this.embarazada = embarazada;
    }

    public Date getFechaVencimientoCUD() {
        return fechaVencimientoCUD;
    }

    public void setFechaVencimientoCUD(Date fechaVencimientoCUD) {
        this.fechaVencimientoCUD = fechaVencimientoCUD;
    }

    public Boolean getTieneCUD() {
        return tieneCUD;
    }

    public void setTieneCUD(Boolean tieneCUD) {
        this.tieneCUD = tieneCUD;
    }

    public List<String> getTipoDiscapacidad() {
        return tipoDiscapacidad;
    }

    public void setTipoDiscapacidad(List<String> tipoDiscapacidad) {
        this.tipoDiscapacidad = tipoDiscapacidad;
    }

    public Boolean getTieneDiscapacidad() {
        return tieneDiscapacidad;
    }

    public void setTieneDiscapacidad(Boolean tieneDiscapacidad) {
        this.tieneDiscapacidad = tieneDiscapacidad;
    }

    public List<String> getSustanciasConsumidas() {
        return sustanciasConsumidas;
    }

    public void setSustanciasConsumidas(List<String> sustanciasConsumidas) {
        this.sustanciasConsumidas = sustanciasConsumidas;
    }

    public Boolean getSufrioViolencia() {
        return sufrioViolencia;
    }

    public void setSufrioViolencia(Boolean sufrioViolencia) {
        this.sufrioViolencia = sufrioViolencia;
    }

    public Boolean getConsumoSustancias() {
        return consumoSustancias;
    }

    public void setConsumoSustancias(Boolean consumoSustancias) {
        this.consumoSustancias = consumoSustancias;
    }

    public List<String> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(List<String> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public List<String> getFuentesCalendarioVacunas() {
        return fuentesCalendarioVacunas;
    }

    public void setFuentesCalendarioVacunas(List<String> fuentesCalendarioVacunas) {
        this.fuentesCalendarioVacunas = fuentesCalendarioVacunas;
    }

    public Boolean getAccesoVacunasUrgentes() {
        return accesoVacunasUrgentes;
    }

    public void setAccesoVacunasUrgentes(Boolean accesoVacunasUrgentes) {
        this.accesoVacunasUrgentes = accesoVacunasUrgentes;
    }

    public Boolean getVacunacionCompleta() {
        return vacunacionCompleta;
    }

    public void setVacunacionCompleta(Boolean vacunacionCompleta) {
        this.vacunacionCompleta = vacunacionCompleta;
    }

    public String getUltimoControlSalud() {
        return ultimoControlSalud;
    }

    public void setUltimoControlSalud(String ultimoControlSalud) {
        this.ultimoControlSalud = ultimoControlSalud;
    }

    public List<String> getCoberturaSalud() {
        return coberturaSalud;
    }

    public void setCoberturaSalud(List<String> coberturaSalud) {
        this.coberturaSalud = coberturaSalud;
    }

    public List<String> getProgramasEstado() {
        return programasEstado;
    }

    public void setProgramasEstado(List<String> programasEstado) {
        this.programasEstado = programasEstado;
    }

    public Boolean getProgramaEstado() {
        return programaEstado;
    }

    public void setProgramaEstado(Boolean programaEstado) {
        this.programaEstado = programaEstado;
    }

    public Boolean getAuditablePorPension() {
        return auditablePorPension;
    }

    public void setAuditablePorPension(Boolean auditablePorPension) {
        this.auditablePorPension = auditablePorPension;
    }

    public Boolean getRealizaTareasDomesticas() {
        return realizaTareasDomesticas;
    }

    public void setRealizaTareasDomesticas(Boolean realizaTareasDomesticas) {
        this.realizaTareasDomesticas = realizaTareasDomesticas;
    }

    public Boolean getCobraJubilacionOPension() {
        return cobraJubilacionOPension;
    }

    public void setCobraJubilacionOPension(Boolean cobraJubilacionOPension) {
        this.cobraJubilacionOPension = cobraJubilacionOPension;
    }

    public List<String> getRamasTrabajo() {
        return ramasTrabajo;
    }

    public void setRamasTrabajo(List<String> ramasTrabajo) {
        this.ramasTrabajo = ramasTrabajo;
    }

    public Boolean getTrabajaEnBlanco() {
        return trabajaEnBlanco;
    }

    public void setTrabajaEnBlanco(Boolean trabajaEnBlanco) {
        this.trabajaEnBlanco = trabajaEnBlanco;
    }

    public Boolean getTrabajoSemanaPasada() {
        return trabajoSemanaPasada;
    }

    public void setTrabajoSemanaPasada(Boolean trabajoSemanaPasada) {
        this.trabajoSemanaPasada = trabajoSemanaPasada;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public Boolean getSabeLeerEscribir() {
        return sabeLeerEscribir;
    }

    public void setSabeLeerEscribir(Boolean sabeLeerEscribir) {
        this.sabeLeerEscribir = sabeLeerEscribir;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String getIdentidadGenero() {
        return identidadGenero;
    }

    public void setIdentidadGenero(String identidadGenero) {
        this.identidadGenero = identidadGenero;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdadMeses() {
        return edadMeses;
    }

    public void setEdadMeses(Integer edadMeses) {
        this.edadMeses = edadMeses;
    }

    public Integer getNumeroPersona() {
        return numeroPersona;
    }

    public void setNumeroPersona(Integer numeroPersona) {
        this.numeroPersona = numeroPersona;
    }
}