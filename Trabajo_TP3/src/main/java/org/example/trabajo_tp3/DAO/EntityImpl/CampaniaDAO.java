package org.example.trabajo_tp3.DAO.EntityImpl;

import org.example.trabajo_tp3.DAO.EntityInterface.CampaniaInterface;
import org.example.trabajo_tp3.DAO.GenericDAo;
import org.example.trabajo_tp3.Modelo.Campania;

public class CampaniaDAO extends GenericDAo<Campania> implements CampaniaInterface {
    public CampaniaDAO() {
        super(Campania.class);
    }
}
