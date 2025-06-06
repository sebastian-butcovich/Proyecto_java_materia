package org.example.trabajo_tp3.Modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String imagen;
    private boolean publico;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PersonalDeSalud creador;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrganizacionSocial> solicitantes;

    public List<OrganizacionSocial> getSolicitantes() {
        return solicitantes;
    }

    public void setSolicitantes(List<OrganizacionSocial> solicitantes) {
        this.solicitantes = solicitantes;
    }

    public PersonalDeSalud getCreador() {
        return creador;
    }

    public void setCreador(PersonalDeSalud creador) {
        this.creador = creador;
    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
