package org.example.trabajo_tp3.DAO.EntityImpl;

import org.example.trabajo_tp3.DAO.EntityInterface.JornadaInterface;
import org.example.trabajo_tp3.DAO.GenericDAo;
import org.example.trabajo_tp3.Modelo.Jornada;

public class JornadaDAO extends GenericDAo<Jornada> implements JornadaInterface {
    public JornadaDAO() {
        super(Jornada.class);
    }
}
