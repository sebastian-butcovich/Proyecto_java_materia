package org.example.trabajo_tp3.Modelo;

import jakarta.persistence.*;
import org.example.trabajo_tp3.Modelo.Encuestas.Encuesta;

import java.util.Date;
import java.util.List;

@Entity
public class Campania {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Barrio barrio;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Jornada> jornada;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Encuesta>  encuestas;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reporte> reportes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public List<Jornada> getJornada() {
        return jornada;
    }

    public void setJornada(List<Jornada> jornada) {
        this.jornada = jornada;
    }

    public List<Encuesta> getEncuestas() {
        return encuestas;
    }

    public void setEncuestas(List<Encuesta> encuestas) {
        this.encuestas = encuestas;
    }

    public List<Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(List<Reporte> reportes) {
        this.reportes = reportes;
    }
}
