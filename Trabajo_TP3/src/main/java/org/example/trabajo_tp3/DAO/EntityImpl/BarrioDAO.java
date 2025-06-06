package org.example.trabajo_tp3.DAO.EntityImpl;

import org.example.trabajo_tp3.DAO.EntityInterface.BarrioInterface;
import org.example.trabajo_tp3.DAO.GenericDAo;
import org.example.trabajo_tp3.Modelo.Barrio;

public class BarrioDAO extends GenericDAo<Barrio> implements BarrioInterface {
    public BarrioDAO() {
        super(Barrio.class);
    }
}
