package org.example.trabajo_tp3.Modelo.Encuestas;

import jakarta.persistence.*;

@Entity
public class Encuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private EncuestaSalud encuestaSalud;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private EncuestaSocial Social;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private EncuestaVivienda encuestaVivienda;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EncuestaSalud getEncuestaSalud() {
        return encuestaSalud;
    }

    public void setEncuestaSalud(EncuestaSalud encuestaSalud) {
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
