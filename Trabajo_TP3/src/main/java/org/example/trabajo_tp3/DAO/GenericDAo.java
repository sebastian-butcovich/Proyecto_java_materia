package org.example.trabajo_tp3.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.example.trabajo_tp3.DAO.GenericDAOInterface;
import org.example.trabajo_tp3.Util.ManagerFactory;

import java.util.List;

public  abstract class GenericDAo<T> implements GenericDAOInterface<T> {

    private Class<T> entityClass;
    public GenericDAo(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    @Override
    public List<T> listar() {
        EntityManager em = ManagerFactory.getEntityManager();
        var transaction = em.getTransaction();
        transaction.begin();
        String jpql = "select u from T u";
        TypedQuery<T> query = em.createQuery(jpql, entityClass);
        List<T> todasEntradas = query.getResultList();
        return todasEntradas;
    }

    @Override
    public T buscarPorId(long id) {
        EntityManager em = ManagerFactory.getEntityManager();
        if(id == 0) {
            return null;
        }
        String jpql = "select u from T u where u.id = :id";
        TypedQuery<T> query = em.createQuery(jpql, entityClass);
        query.setParameter("id", id);
        T  unaEntrada= query.getSingleResult();
        return unaEntrada;
    }


    @Override
    @Transactional
    public T actualizar(T entidad) {
        EntityManager em = ManagerFactory.getEntityManager();
        em.merge(entidad);
        return entidad;
        }
    @Transactional
    @Override
    public boolean eliminar( long id) {
        EntityManager em = ManagerFactory.getEntityManager();
        if (id == 0) {
            return false;
        } else {
            T u = this.buscarPorId(id);
            if (u == null) {
                return false;
            }
            em.remove(u);
            return true;
        }
    }
    @Override
    @Transactional
    public T agregar(T u)  {
        EntityManager em = ManagerFactory.getEntityManager();
        em.persist(u);
       return u;
    }
}
