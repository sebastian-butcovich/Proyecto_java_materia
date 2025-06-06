package org.example.trabajo_tp3.DAO.EntityImpl;

import org.example.trabajo_tp3.DAO.EntityInterface.EncuestadorInterface;
import org.example.trabajo_tp3.DAO.GenericDAo;
import org.example.trabajo_tp3.Modelo.Encuestador;

public class EncuestadorDAO extends GenericDAo<Encuestador> implements  EncuestadorInterface {
    public EncuestadorDAO() {
        super(Encuestador.class);
    }
}
