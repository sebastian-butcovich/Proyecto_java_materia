package org.example.trabajo_tp3.Services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.trabajo_tp3.DAO.GenericDAO;
import org.example.trabajo_tp3.Modelo.OrganizacionSocial;
import org.example.trabajo_tp3.Util.ManagerFactory;

import java.util.List;

public class OrganizacionSocialService implements GenericDAO<OrganizacionSocial> {

    @Override
    public List<OrganizacionSocial> listar() {
        return List.of();
    }

    @Override
    public OrganizacionSocial buscarPorId(long id) {
        return null;
    }

    @Override
    public boolean agregar(OrganizacionSocial organizacionSocial) {
        EntityManager entityManager = ManagerFactory.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(organizacionSocial);
        transaction.commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean actualizar(OrganizacionSocial organizacionSocialService) {
        return false;
    }

    @Override
    public boolean eliminar(long id) {
        return false;
    }
}
