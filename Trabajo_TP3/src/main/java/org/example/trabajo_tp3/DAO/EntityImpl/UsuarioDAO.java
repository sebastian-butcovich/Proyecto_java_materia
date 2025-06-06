package org.example.trabajo_tp3.DAO.EntityImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.trabajo_tp3.DAO.EntityInterface.UsuarioInterface;
import org.example.trabajo_tp3.DAO.GenericDAo;
import org.example.trabajo_tp3.Modelo.Usuario;
import org.example.trabajo_tp3.Util.ManagerFactory;

import java.util.List;

public class UsuarioDAO extends GenericDAo<Usuario> implements UsuarioInterface {
    private EntityManager entityManager;
    public UsuarioDAO() {
        super(Usuario.class);
    }
    public EntityManager getEntityManager() {
        return ManagerFactory.getEntityManager();
    }
    @Override
    public Usuario agregar(Usuario usuario) {
        //Agregar usuario con checkeo de repetidos
        try{
            EntityManager em = getEntityManager();
            String query = "FROM Usuario u WHERE u.email = :email";
            TypedQuery<Usuario> q = em.createQuery(query, Usuario.class);
            q.setParameter("email", usuario.getEmail());
            List<Usuario> u =  q.getResultList();
            if(!u.isEmpty()){
                return u.get(0);
            }else{
                em.persist(usuario);
            }
            return usuario;
        }catch(NoResultException e){
           e.printStackTrace();
           return null;
        }
    }
}
