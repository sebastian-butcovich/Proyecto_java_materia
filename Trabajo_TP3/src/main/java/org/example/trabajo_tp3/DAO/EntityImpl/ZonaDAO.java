package org.example.trabajo_tp3.DAO.EntityImpl;

import org.example.trabajo_tp3.DAO.EntityInterface.ZonaInterface;
import org.example.trabajo_tp3.DAO.GenericDAo;
import org.example.trabajo_tp3.Modelo.Zona;

public class ZonaDAO extends GenericDAo<Zona> implements ZonaInterface {
    public ZonaDAO() {
        super(Zona.class);
    }
}
