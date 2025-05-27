package org.example.trabajo_tp3.Services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.trabajo_tp3.DAO.GenericDAO;
import org.example.trabajo_tp3.Modelo.PersonalDeSalud;
import org.example.trabajo_tp3.Modelo.Usuario;
import org.example.trabajo_tp3.Util.ManagerFactory;
import org.json.JSONObject;

import java.util.List;

public class PersonalDeSaludService implements GenericDAO<PersonalDeSalud> {

    @Override
    public List<PersonalDeSalud> listar() {
        return List.of();
    }

    @Override
    public PersonalDeSalud buscarPorId(long id) {
        return null;
    }

    @Override
    public boolean agregar(PersonalDeSalud personalDeSalud) {
        EntityManager entityManager = ManagerFactory.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(personalDeSalud);
        transaction.commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean actualizar(PersonalDeSalud personalDeSalud) {
        return false;
    }

    @Override
    public boolean eliminar(long id) {
        return false;
    }
}
