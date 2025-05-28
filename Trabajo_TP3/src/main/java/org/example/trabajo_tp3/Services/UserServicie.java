package org.example.trabajo_tp3.Services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transaction;
import org.example.trabajo_tp3.DAO.GenericDAO;
import org.example.trabajo_tp3.Modelo.Usuario;
import org.example.trabajo_tp3.Util.ManagerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet(name="usuarios", value="/usuarios")
public class UserServicie implements GenericDAO <Usuario> {

    public List<Usuario> listar() {
        EntityManager entityManager = ManagerFactory.getEntityManager();
        var transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql = "select u from Usuario u";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        List<Usuario> usuarios = query.getResultList();
        ManagerFactory.getEntityManager().close();
        return usuarios;
    }

    @Override
    public Usuario buscarPorId(long id) {
        if(id == 0) {
            return null;
        }
        EntityManager entityManager = ManagerFactory.getEntityManager();
        String jpql = "select u from Usuario u where u.id = :id";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        query.setParameter("id", id);
        Usuario usuarios = query.getSingleResult();
        ManagerFactory.getEntityManager().close();
        return usuarios;
    }



    @Override
    public boolean actualizar(Usuario usuario) {
        EntityManager entityManager = ManagerFactory.getEntityManager();
        Usuario u = entityManager.find(Usuario.class, usuario.getId());
        if(u == null ) {
            return false;
        }else{
            u.setNombre(usuario.getNombre());
            u.setApellido(usuario.getApellido());
            u.setEmail(usuario.getEmail());
            u.setTelefono(usuario.getTelefono());
            u.setRol(usuario.getRol());
            entityManager.getTransaction().begin();
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
    }

    @Override
    public boolean eliminar( long id) {
        EntityManager entityManager = ManagerFactory.getEntityManager();
        if (id == 0) {
            return false;
        } else {
            Usuario u = entityManager.find(Usuario.class, id);
            if (u == null) {
                return false;
            }
            entityManager.getTransaction().begin();
            entityManager.remove(u);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
    }
    @Override
    public boolean agregar(Usuario u)  {
        EntityManager entityManager = ManagerFactory.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(u);
        entityTransaction.commit();
        ManagerFactory.getEntityManager().close();
       return true;
    }
}
