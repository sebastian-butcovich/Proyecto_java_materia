package org.example.trabajo_tp3.Modelo;

import jakarta.persistence.*;

@Entity
public class FiltroDelMapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sociales;
    private String enfermedades;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSociales() {
        return sociales;
    }

    public void setSociales(String sociales) {
        this.sociales = sociales;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
