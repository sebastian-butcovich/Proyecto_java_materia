package org.example.trabajo_tp3.DAO.EntityImpl;

import org.example.trabajo_tp3.DAO.EntityInterface.PilotoEncuestaBarrio;
import org.example.trabajo_tp3.DAO.GenericDAo;
import org.example.trabajo_tp3.Modelo.PilotoEncuestaPregunta.EncuestaBarrio;

public class PilotoEncuestaBarrioDAO extends GenericDAo<EncuestaBarrio> implements PilotoEncuestaBarrio {
    public PilotoEncuestaBarrioDAO() {
        super(EncuestaBarrio.class);
    }
}
