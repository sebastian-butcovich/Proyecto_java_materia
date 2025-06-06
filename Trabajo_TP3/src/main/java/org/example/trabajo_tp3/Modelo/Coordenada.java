package org.example.trabajo_tp3.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coordenada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coorX;
    private String coorY;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoorX() {
        return coorX;
    }

    public void setCoorX(String coorX) {
        this.coorX = coorX;
    }

    public String getCoorY() {
        return coorY;
    }

    public void setCoorY(String coorY) {
        this.coorY = coorY;
    }
}
