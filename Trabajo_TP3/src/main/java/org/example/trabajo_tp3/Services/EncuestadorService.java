package org.example.trabajo_tp3.Services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.trabajo_tp3.DAO.GenericDAO;
import org.example.trabajo_tp3.Modelo.Encuestador;
import org.example.trabajo_tp3.Util.ManagerFactory;

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
        EntityManager entityManager = ManagerFactory.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(encuestador);
        entityTransaction.commit();
        return true;
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
