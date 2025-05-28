package org.example.trabajo_tp3.Modelo;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Jornada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date fecha;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Zona> zonaList;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
