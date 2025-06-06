package org.example.trabajo_tp3.DAO.EntityImpl;

import jakarta.persistence.EntityManager;
import org.example.trabajo_tp3.DAO.EntityInterface.FiltroMapaInterface;
import org.example.trabajo_tp3.DAO.GenericDAo;
import org.example.trabajo_tp3.Modelo.FiltroDelMapa;
import org.example.trabajo_tp3.Modelo.Usuario;
import org.example.trabajo_tp3.Util.ManagerFactory;

public class FiltroMapaDAO extends GenericDAo<FiltroDelMapa> implements FiltroMapaInterface {
    public FiltroMapaDAO() {
        super(FiltroDelMapa.class);
    }
    @Override
    public FiltroDelMapa agregar (FiltroDelMapa filtroMapa){
        Usuario u  = filtroMapa.getUsuario();
        EntityManager em = ManagerFactory.getEntityManager();
        if(u==null){
            return null;
        }
        if(u.getRol() != Usuario.Rol.MEDICO){
            return null;
        }
        em.persist(filtroMapa);
        return filtroMapa;
    }
}
