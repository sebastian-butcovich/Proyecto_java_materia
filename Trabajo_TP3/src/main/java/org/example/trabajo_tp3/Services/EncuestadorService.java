package org.example.trabajo_tp3.Services;

import org.example.trabajo_tp3.DAO.GenericDAO;
import org.example.trabajo_tp3.Modelo.Encuestador;

import java.util.List;

public class EncuestadorService implements GenericDAO<Encuestador> {

    @Override
    public List<Encuestador> listar() {
        return List.of();
    }

    @Override
    public Encuestador buscarPorId(long id) {
        return null;
    }

    @Override
    public boolean agregar(Encuestador encuestador) {
        return false;
    }

    @Override
    public boolean actualizar(Encuestador encuestador) {
        return false;
    }

    @Override
    public boolean eliminar(long id) {
        return false;
    }
}
