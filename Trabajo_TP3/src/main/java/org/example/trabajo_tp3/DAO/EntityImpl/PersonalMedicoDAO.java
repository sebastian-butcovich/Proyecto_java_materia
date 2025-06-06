package org.example.trabajo_tp3.DAO.EntityImpl;

import org.example.trabajo_tp3.DAO.EntityInterface.PersonalMedicoInterface;
import org.example.trabajo_tp3.DAO.GenericDAo;
import org.example.trabajo_tp3.Modelo.PersonalDeSalud;

public class PersonalMedicoDAO extends GenericDAo<PersonalDeSalud> implements PersonalMedicoInterface {
    public PersonalMedicoDAO() {
        super(PersonalDeSalud.class);
    }
}
