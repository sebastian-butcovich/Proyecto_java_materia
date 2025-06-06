package org.example.trabajo_tp3.Modelo.Encuestas;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
@Entity
public class EncuestaPersonalMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //preguntas 59 hasta 73
    private Boolean tuvoAtencionUltimoAnio;
    private Boolean leIndicaronMedicacion;
    private Boolean accedioMedicacion;
    private List<String> formaConsigueMedicacion;
    private Boolean interrumpioTratamiento;

    //solamente para persona con útero de 25 a 65 años
    private String fechaUltimoPAP;

    private String fechaUltimoTestITS;
    private Boolean usaAnticonceptivo;
    private String metodoAnticonceptivo;
    private List<String> accesoAnticonceptivo;
    private Boolean dificultadAccesoAnticonceptivo;
    private Boolean leOfrecieronOtrosMetodos;
    private Boolean deseaMetodoNoDisponible;
    private String metodoDeseado;
    private Boolean usaPreservativoOCampo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getTuvoAtencionUltimoAnio() {
        return tuvoAtencionUltimoAnio;
    }

    public void setTuvoAtencionUltimoAnio(Boolean tuvoAtencionUltimoAnio) {
        this.tuvoAtencionUltimoAnio = tuvoAtencionUltimoAnio;
    }

    public Boolean getLeIndicaronMedicacion() {
        return leIndicaronMedicacion;
    }

    public void setLeIndicaronMedicacion(Boolean leIndicaronMedicacion) {
        this.leIndicaronMedicacion = leIndicaronMedicacion;
    }

    public Boolean getAccedioMedicacion() {
        return accedioMedicacion;
    }

    public void setAccedioMedicacion(Boolean accedioMedicacion) {
        this.accedioMedicacion = accedioMedicacion;
    }

    public List<String> getFormaConsigueMedicacion() {
        return formaConsigueMedicacion;
    }

    public void setFormaConsigueMedicacion(List<String> formaConsigueMedicacion) {
        this.formaConsigueMedicacion = formaConsigueMedicacion;
    }

    public Boolean getInterrumpioTratamiento() {
        return interrumpioTratamiento;
    }

    public void setInterrumpioTratamiento(Boolean interrumpioTratamiento) {
        this.interrumpioTratamiento = interrumpioTratamiento;
    }

    public String getFechaUltimoPAP() {
        return fechaUltimoPAP;
    }

    public void setFechaUltimoPAP(String fechaUltimoPAP) {
        this.fechaUltimoPAP = fechaUltimoPAP;
    }

    public String getFechaUltimoTestITS() {
        return fechaUltimoTestITS;
    }

    public void setFechaUltimoTestITS(String fechaUltimoTestITS) {
        this.fechaUltimoTestITS = fechaUltimoTestITS;
    }

    public Boolean getUsaAnticonceptivo() {
        return usaAnticonceptivo;
    }

    public void setUsaAnticonceptivo(Boolean usaAnticonceptivo) {
        this.usaAnticonceptivo = usaAnticonceptivo;
    }

    public String getMetodoAnticonceptivo() {
        return metodoAnticonceptivo;
    }

    public void setMetodoAnticonceptivo(String metodoAnticonceptivo) {
        this.metodoAnticonceptivo = metodoAnticonceptivo;
    }

    public List<String> getAccesoAnticonceptivo() {
        return accesoAnticonceptivo;
    }

    public void setAccesoAnticonceptivo(List<String> accesoAnticonceptivo) {
        this.accesoAnticonceptivo = accesoAnticonceptivo;
    }

    public Boolean getDificultadAccesoAnticonceptivo() {
        return dificultadAccesoAnticonceptivo;
    }

    public void setDificultadAccesoAnticonceptivo(Boolean dificultadAccesoAnticonceptivo) {
        this.dificultadAccesoAnticonceptivo = dificultadAccesoAnticonceptivo;
    }

    public Boolean getLeOfrecieronOtrosMetodos() {
        return leOfrecieronOtrosMetodos;
    }

    public void setLeOfrecieronOtrosMetodos(Boolean leOfrecieronOtrosMetodos) {
        this.leOfrecieronOtrosMetodos = leOfrecieronOtrosMetodos;
    }

    public Boolean getDeseaMetodoNoDisponible() {
        return deseaMetodoNoDisponible;
    }

    public void setDeseaMetodoNoDisponible(Boolean deseaMetodoNoDisponible) {
        this.deseaMetodoNoDisponible = deseaMetodoNoDisponible;
    }

    public String getMetodoDeseado() {
        return metodoDeseado;
    }

    public void setMetodoDeseado(String metodoDeseado) {
        this.metodoDeseado = metodoDeseado;
    }

    public Boolean getUsaPreservativoOCampo() {
        return usaPreservativoOCampo;
    }

    public void setUsaPreservativoOCampo(Boolean usaPreservativoOCampo) {
        this.usaPreservativoOCampo = usaPreservativoOCampo;
    }
}