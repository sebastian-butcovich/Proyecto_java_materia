package org.example.trabajo_tp3.Modelo.Encuestas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
@Entity
public class EncuestaVivienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //preguntas 1 a 15
    private String direccion;
    private String materialConstruccion;
    private Boolean tieneAgua;
    private String tipoAccesoAgua;
    private Boolean aguaPotable;
    // Hay que ver como implementar esto. Creo que no existe una lista de string en mysql.
    private List<String> itemsVivienda;
    private String desagueInodoro;
    private List<String> formasCocinar;
    private List<String> calefaccion;
    private String conexionElectricidad;
    private List<String> accesoInternet;
    private Integer ambientesParaDormir;
    private String tipoTenencia;
    private String percepcionIngresos;
    private Boolean recibeAsistenciaAlimentaria;
    private List<String> tipoAsistencia;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMaterialConstruccion() {
        return materialConstruccion;
    }

    public void setMaterialConstruccion(String materialConstruccion) {
        this.materialConstruccion = materialConstruccion;
    }

    public Boolean getTieneAgua() {
        return tieneAgua;
    }

    public void setTieneAgua(Boolean tieneAgua) {
        this.tieneAgua = tieneAgua;
    }

    public String getTipoAccesoAgua() {
        return tipoAccesoAgua;
    }

    public void setTipoAccesoAgua(String tipoAccesoAgua) {
        this.tipoAccesoAgua = tipoAccesoAgua;
    }

    public List<String> getItemsVivienda() {
        return itemsVivienda;
    }

    public void setItemsVivienda(List<String> itemsVivienda) {
        this.itemsVivienda = itemsVivienda;
    }

    public Boolean getAguaPotable() {
        return aguaPotable;
    }

    public void setAguaPotable(Boolean aguaPotable) {
        this.aguaPotable = aguaPotable;
    }

    public String getDesagueInodoro() {
        return desagueInodoro;
    }

    public void setDesagueInodoro(String desagueInodoro) {
        this.desagueInodoro = desagueInodoro;
    }

    public List<String> getFormasCocinar() {
        return formasCocinar;
    }

    public void setFormasCocinar(List<String> formasCocinar) {
        this.formasCocinar = formasCocinar;
    }

    public List<String> getCalefaccion() {
        return calefaccion;
    }

    public void setCalefaccion(List<String> calefaccion) {
        this.calefaccion = calefaccion;
    }

    public String getConexionElectricidad() {
        return conexionElectricidad;
    }

    public void setConexionElectricidad(String conexionElectricidad) {
        this.conexionElectricidad = conexionElectricidad;
    }

    public List<String> getAccesoInternet() {
        return accesoInternet;
    }

    public void setAccesoInternet(List<String> accesoInternet) {
        this.accesoInternet = accesoInternet;
    }

    public Integer getAmbientesParaDormir() {
        return ambientesParaDormir;
    }

    public void setAmbientesParaDormir(Integer ambientesParaDormir) {
        this.ambientesParaDormir = ambientesParaDormir;
    }

    public String getTipoTenencia() {
        return tipoTenencia;
    }

    public void setTipoTenencia(String tipoTenencia) {
        this.tipoTenencia = tipoTenencia;
    }

    public String getPercepcionIngresos() {
        return percepcionIngresos;
    }

    public void setPercepcionIngresos(String percepcionIngresos) {
        this.percepcionIngresos = percepcionIngresos;
    }

    public Boolean getRecibeAsistenciaAlimentaria() {
        return recibeAsistenciaAlimentaria;
    }

    public void setRecibeAsistenciaAlimentaria(Boolean recibeAsistenciaAlimentaria) {
        this.recibeAsistenciaAlimentaria = recibeAsistenciaAlimentaria;
    }

    public List<String> getTipoAsistencia() {
        return tipoAsistencia;
    }

    public void setTipoAsistencia(List<String> tipoAsistencia) {
        this.tipoAsistencia = tipoAsistencia;
    }
}