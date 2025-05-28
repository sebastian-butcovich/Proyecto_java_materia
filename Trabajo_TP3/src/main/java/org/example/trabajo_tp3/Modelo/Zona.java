package org.example.trabajo_tp3.Modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String informacion;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Coordenada> coordenadas;
}
