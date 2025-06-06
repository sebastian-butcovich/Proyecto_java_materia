package org.example.trabajo_tp3.DAO.EntityImpl;

import org.example.trabajo_tp3.DAO.EntityInterface.CoordenadaInterface;
import org.example.trabajo_tp3.DAO.GenericDAo;
import org.example.trabajo_tp3.Modelo.Coordenada;

public class CoordenadaDAO extends GenericDAo<Coordenada> implements CoordenadaInterface {
    public CoordenadaDAO() {
        super(Coordenada.class);
    }
}
