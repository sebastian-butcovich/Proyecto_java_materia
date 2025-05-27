package org.example.trabajo_tp3.Services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.trabajo_tp3.DAO.GenericDAO;
import org.example.trabajo_tp3.Modelo.Barrio;
import org.example.trabajo_tp3.Util.ManagerFactory;

import java.util.List;

public class BarrioServicie implements GenericDAO<Barrio> {
    @Override
    public List<Barrio> listar() {
        EntityManager entityManager = ManagerFactory.getEntityManager();
        String jpql = "select b from Barrio b";
        TypedQuery<Barrio> query = entityManager.createQuery(jpql, Barrio.class);
        List<Barrio> barrios = query.getResultList();
        ManagerFactory.getEntityManager().close();
        return barrios;
    }

    @Override
    public Barrio buscarPorId(long id) {
        return null;
    }

    @Override
    public boolean agregar(Barrio barrio) {
        EntityManager entityManager = ManagerFactory.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(barrio);
        entityTransaction.commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean actualizar(Barrio barrio) {
        return false;
    }

    @Override
    public boolean eliminar(long id) {
        return false;
    }
}
