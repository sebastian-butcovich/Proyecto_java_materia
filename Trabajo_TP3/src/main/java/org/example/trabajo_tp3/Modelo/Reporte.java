package org.example.trabajo_tp3.Modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String imagen;
    private boolean publico;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PersonalDeSalud personalDeSalud;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrganizacionSocial> organizacionSocialList;

    public List<OrganizacionSocial> getOrganizacionSocialList() {
        return organizacionSocialList;
    }

    public void setOrganizacionSocialList(List<OrganizacionSocial> organizacionSocialList) {
        this.organizacionSocialList = organizacionSocialList;
    }

    public PersonalDeSalud getPersonalDeSalud() {
        return personalDeSalud;
    }

    public void setPersonalDeSalud(PersonalDeSalud personalDeSalud) {
        this.personalDeSalud = personalDeSalud;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
