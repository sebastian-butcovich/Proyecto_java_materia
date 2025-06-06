package org.example.trabajo_tp3.Modelo;

import jakarta.persistence.*;

@Entity
public class Encuestador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genero;
    private String ocupacion;
    private Integer edad;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Usuario usuario;
    public Long getId() {
        return id;
    }
    public  void setId(Long id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
}
