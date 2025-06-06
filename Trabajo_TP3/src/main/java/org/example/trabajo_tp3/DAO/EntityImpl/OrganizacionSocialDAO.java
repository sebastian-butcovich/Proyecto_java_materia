package org.example.trabajo_tp3.DAO.EntityImpl;

import org.example.trabajo_tp3.DAO.EntityInterface.OrganizacionSocialInterface;
import org.example.trabajo_tp3.DAO.GenericDAo;
import org.example.trabajo_tp3.Modelo.OrganizacionSocial;

public class OrganizacionSocialDAO extends GenericDAo<OrganizacionSocial> implements OrganizacionSocialInterface {
    public OrganizacionSocialDAO() {
        super(OrganizacionSocial.class);
    }
}
