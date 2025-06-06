package org.example.trabajo_tp3.DAO.EntityImpl;

import org.example.trabajo_tp3.DAO.EntityInterface.PreguntaInterface;
import org.example.trabajo_tp3.DAO.GenericDAo;
import org.example.trabajo_tp3.Modelo.Encuestas.Pregunta;

public class PreguntaDAO extends GenericDAo<Pregunta> implements PreguntaInterface {
    public PreguntaDAO() {
        super(Pregunta.class);
    }
}
