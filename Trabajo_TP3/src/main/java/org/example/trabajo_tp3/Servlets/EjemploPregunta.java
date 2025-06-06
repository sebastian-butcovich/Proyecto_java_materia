package org.example.trabajo_tp3.Servlets;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.trabajo_tp3.DAO.EntityImpl.PilotoEncuestaBarrioDAO;
import org.example.trabajo_tp3.DAO.EntityImpl.PreguntaDAO;
import org.example.trabajo_tp3.Modelo.Encuestas.Pregunta;
import org.example.trabajo_tp3.Modelo.PilotoEncuestaPregunta.EncuestaBarrio;
import org.example.trabajo_tp3.Util.ManagerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="pregunta",value="/pregunta")
public class EjemploPregunta extends HttpServlet {
    private PreguntaDAO preguntaDAO;
    private PilotoEncuestaBarrioDAO pilotoEncuestaBarrioDAO;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        preguntaDAO = new PreguntaDAO();
        pilotoEncuestaBarrioDAO = new PilotoEncuestaBarrioDAO();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = ManagerFactory.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Pregunta pregunta = new Pregunta();
        pregunta.setNumero(2);
        pregunta.setPregunta("¿Tiene servicio de gas o tiene garrafa?");
        pregunta.setRespuesta("Garrafa");
        pregunta.setRespondio(true);
        preguntaDAO.agregar(pregunta);
        EncuestaBarrio  encuestaBarrio = new EncuestaBarrio();
        List<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);
        encuestaBarrio.setPreguntas(preguntas);
        pilotoEncuestaBarrioDAO.agregar(encuestaBarrio);
        et.commit();
        em.close();

    }
}
