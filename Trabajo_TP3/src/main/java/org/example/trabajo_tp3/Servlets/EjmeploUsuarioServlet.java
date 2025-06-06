package org.example.trabajo_tp3.Servlets;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.trabajo_tp3.DAO.EntityImpl.*;
import org.example.trabajo_tp3.Modelo.*;
import org.example.trabajo_tp3.Util.ManagerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ejemplo_usuario",value="/ejemploU")
public class EjmeploUsuarioServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO;
    private PersonalMedicoDAO personalMedicoDAO;
    private OrganizacionSocialDAO organizacionSocialDAO;
    private CoordenadaDAO coordenadaDAO;
    private ZonaDAO zonaDAO;
    private BarrioDAO barrioDAO;
    private EncuestadorDAO encuestadorDAO;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        usuarioDAO = new UsuarioDAO();
        personalMedicoDAO = new PersonalMedicoDAO();
        organizacionSocialDAO = new OrganizacionSocialDAO();
        coordenadaDAO = new CoordenadaDAO();
        zonaDAO = new ZonaDAO();
        barrioDAO = new BarrioDAO();
        encuestadorDAO = new EncuestadorDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Usuario administrador
        EntityManager em = ManagerFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Usuario usuario = new Usuario();
        usuario.setNombre("Sebastián");
        usuario.setApellido("Butcovich");
        usuario.setDNI("45673892");
        usuario.setEmail("email@gmail.com");
        usuario.setTelefono("+45673892");
        usuario.setRol(Usuario.Rol.ADMINISTRADOR);
        usuarioDAO.agregar(usuario);
        tx.commit();
        //Usuario médico
        tx.begin();
        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Juan");
        usuario2.setApellido("LL");
        usuario2.setDNI("45673895");
        usuario2.setEmail("email2@gmail.com");
        usuario2.setTelefono("+45673832");
        usuario2.setRol(Usuario.Rol.MEDICO);
        usuarioDAO.agregar(usuario2);
        PersonalDeSalud ps = new PersonalDeSalud();
        ps.setUsuario(usuario2);
        ps.setMatricula((long)2394820);
        personalMedicoDAO.agregar(ps);
        tx.commit();
        //Coordenada
        tx.begin();
        Coordenada coordenada = new Coordenada();
        coordenada.setCoorX("29");
        coordenada.setCoorY("21");
        coordenadaDAO.agregar(coordenada);
        Coordenada coordenada2 = new Coordenada();
        coordenada2.setCoorX("32");
        coordenada2.setCoorY("27");
        coordenadaDAO.agregar(coordenada2);
        Coordenada coordenada3 = new Coordenada();
        coordenada3.setCoorX("53");
        coordenada3.setCoorY("21");
        coordenadaDAO.agregar(coordenada3);
        //Zona
        Zona zona = new Zona();
        zona.setNombre("La matanza");
        zona.setInformacion("Lugar peligroso");
        List<Coordenada> coordenadas = new ArrayList<Coordenada>();
        coordenadas.add(coordenada2);
        coordenadas.add(coordenada3);
        zona.setCoordenadas(coordenadas);
        zonaDAO.agregar(zona);
        //Barrio
        Barrio barrio = new Barrio();
        barrio.setNombre("Ni idea");
        barrio.setInformacionAdicional("Nadie sabe donde queda");
        List<Zona> zonas = new  ArrayList<>();
        zonas.add(zona);
        barrio.setZonas(zonas);
        barrioDAO.agregar(barrio);
        tx.commit();
        //Usuario empresa
        tx.begin();
        Usuario usuario3 = new Usuario();
        usuario3.setNombre("Roberto");
        usuario3.setApellido("Sanchez");
        usuario3.setDNI("43673893");
        usuario3.setEmail("sanchez@gmail.com");
        usuario3.setTelefono("+54673893");
        usuario3.setRol(Usuario.Rol.REFERENTE);
        usuarioDAO.agregar(usuario3);
        tx.commit();
        tx.begin();
        OrganizacionSocial organizacionSocial = new OrganizacionSocial();
        organizacionSocial.setNombre("Comida para todos");
        organizacionSocial.setDomicilio("Calle falsa 123");
        organizacionSocial.setActividadPrincipal("Llevar comida al barrio");
        organizacionSocial.setInformacionAdicional("Fundada 1959");
        organizacionSocial.setUsuario(usuario3);
        organizacionSocial.setBarrio(barrio);
        organizacionSocialDAO.agregar(organizacionSocial);
        tx.commit();
        tx.begin();
        Usuario usuario4 = new Usuario();
        usuario4.setNombre("Robo");
        usuario4.setApellido("Marquelios");
        usuario4.setDNI("33673893");
        usuario4.setEmail("email4@gmail.com");
        usuario4.setTelefono("+54373893");
        usuario4.setRol(Usuario.Rol.ENCUESTADOR);
        usuarioDAO.agregar(usuario4);
        Encuestador encuestador = new Encuestador();
        encuestador.setEdad(25);
        encuestador.setOcupacion("Estudiante");
        encuestador.setGenero("Masculino");
        encuestador.setUsuario(usuario4);
        encuestadorDAO.agregar(encuestador);
        tx.commit();
        em.close();
    }
}
