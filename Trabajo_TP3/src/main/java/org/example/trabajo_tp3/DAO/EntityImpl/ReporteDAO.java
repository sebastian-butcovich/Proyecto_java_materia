package org.example.trabajo_tp3.DAO.EntityImpl;

import org.example.trabajo_tp3.DAO.EntityInterface.ReporteInterface;
import org.example.trabajo_tp3.DAO.GenericDAo;
import org.example.trabajo_tp3.Modelo.Reporte;

public class ReporteDAO extends GenericDAo<Reporte> implements ReporteInterface {
    public ReporteDAO() {
        super(Reporte.class);
    }
}
