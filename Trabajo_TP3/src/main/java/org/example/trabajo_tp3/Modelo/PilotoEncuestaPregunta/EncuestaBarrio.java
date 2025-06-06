package org.example.trabajo_tp3.Modelo.PilotoEncuestaPregunta;

import jakarta.persistence.*;
import org.example.trabajo_tp3.Modelo.Encuestas.Pregunta;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "pilotoEncuesta")
public class EncuestaBarrio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Pregunta> preguntas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}
