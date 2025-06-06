package org.example.trabajo_tp3.Modelo.Encuestas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.Type;

@Entity
// La ídea es que la pregunta sea generica y que la respuesta puede guarda distinto tipos de datos según convenga la situación
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private String encuesta;
    private String pregunta;
    // Se puede hacer esto? O tengo que definir un tipo de datos estricto.
    private String respuesta;
    private boolean respondio;
    public Integer getNumero() {
        return numero;
    }

    public String getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(String encuesta) {
        this.encuesta = encuesta;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isRespondio() {
        return respondio;
    }

    public void setRespondio(boolean respondio) {
        this.respondio = respondio;
    }
}
