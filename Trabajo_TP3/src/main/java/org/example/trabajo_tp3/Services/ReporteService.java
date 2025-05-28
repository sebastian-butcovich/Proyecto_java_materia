package org.example.trabajo_tp3.Services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.trabajo_tp3.DAO.GenericDAO;
import org.example.trabajo_tp3.Modelo.Reporte;
import org.example.trabajo_tp3.Util.ManagerFactory;

import java.util.List;

public class ReporteService implements GenericDAO<Reporte> {

    @Override
    public List<Reporte> listar() {
        EntityManager em = ManagerFactory.getEntityManager();
        String jpql = "SELECT r FROM Reporte r";
        TypedQuery<Reporte> query = em.createQuery(jpql, Reporte.class);
        List<Reporte> lista = query.getResultList();
        return lista;
    }

    @Override
    public Reporte buscarPorId(long id) {
        EntityManager entityManager = ManagerFactory.getEntityManager();
        String query = "SELECT r FROM Reporte r WHERE r.id = :id";
        TypedQuery<Reporte> query1 = entityManager.createQuery(query, Reporte.class);
        query1.setParameter("id", id);
        try{
            Reporte r = (Reporte) query1.getSingleResult();
            return r;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public boolean agregar(Reporte reporte) {
        EntityManager entityManager = ManagerFactory.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(reporte); // Esto se tiene que cambiar por un merge cuando se agregen relaciones
        entityTransaction.commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean actualizar(Reporte reporte) {
        EntityManager entityManager = ManagerFactory.getEntityManager();
        Reporte re = this.buscarPorId(reporte.getId());
        if(re==null){
            return false;
        }else{
            re.setNombre(reporte.getNombre());
            re.setImagen(reporte.getImagen());
            re.setPublico(reporte.isPublico());
            entityManager.getTransaction().begin();
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
    }

    @Override
    public boolean eliminar(long id) {
        EntityManager entityManager = ManagerFactory.getEntityManager();
        Reporte reporte = this.buscarPorId(id);
        if(reporte==null){
            return false;
        }
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(reporte);
        entityTransaction.commit();
        entityManager.close();
        return true;
    }
}
