package org.example.trabajo_tp3.Services;

import jakarta.persistence.EntityManager;
import org.example.trabajo_tp3.DAO.GenericDAO;
import org.example.trabajo_tp3.Modelo.Jornada;
import org.example.trabajo_tp3.Util.ManagerFactory;

import java.util.List;

public class JornadaService implements GenericDAO<Jornada> {

    @Override
    public List<Jornada> listar() {
        return List.of();
    }

    @Override
    public Jornada buscarPorId(long id) {
        return null;
    }

    @Override
    public boolean agregar(Jornada jornada) {
        EntityManager entityManager = ManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(jornada);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean actualizar(Jornada jornada) {
        return false;
    }

    @Override
    public boolean eliminar(long id) {
        return false;
    }
}
