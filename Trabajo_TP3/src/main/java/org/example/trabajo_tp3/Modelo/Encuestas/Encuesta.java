package org.example.trabajo_tp3.Modelo.Encuestas;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Encuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private EncuestaAccesoSalud encuestaSalud;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private EncuestaSocial Social;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private EncuestaVivienda encuestaVivienda;
    @OneToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    private EncuestaBarrio encuestaBarrio;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<EncuestaPersonal> encuestaPersonal;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private EncuestaPersonalMedica encuestaPersonalMedica;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EncuestaAccesoSalud getEncuestaSalud() {
        return encuestaSalud;
    }

    public void setEncuestaSalud(EncuestaAccesoSalud encuestaSalud) {
        this.encuestaSalud = encuestaSalud;
    }

    public EncuestaVivienda getEncuestaVivienda() {
        return encuestaVivienda;
    }

    public void setEncuestaVivienda(EncuestaVivienda encuestaVivienda) {
        this.encuestaVivienda = encuestaVivienda;
    }

    public EncuestaSocial getSocial() {
        return Social;
    }

    public void setSocial(EncuestaSocial social) {
        Social = social;
    }
}
