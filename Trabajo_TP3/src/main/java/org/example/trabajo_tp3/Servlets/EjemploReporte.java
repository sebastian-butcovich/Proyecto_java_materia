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
@WebServlet(name="ejemplo_reporte",value="/ejemploR")
public class EjemploReporte extends HttpServlet {
    private UsuarioDAO usuarioDAO;
    private OrganizacionSocialDAO organizacionSocialDAO;
    private ReporteDAO reporteDAO;
    private CoordenadaDAO coordenadaDAO;
    private ZonaDAO zonaDAO;
    private BarrioDAO barrioDAO;
    private PersonalMedicoDAO personalMedicoDAO;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        usuarioDAO = new UsuarioDAO();
        organizacionSocialDAO = new OrganizacionSocialDAO();
        reporteDAO = new ReporteDAO();
        coordenadaDAO = new CoordenadaDAO();
        zonaDAO = new ZonaDAO();
        barrioDAO = new BarrioDAO();
        personalMedicoDAO = new PersonalMedicoDAO();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = ManagerFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Usuario usuario = new Usuario();
        usuario.setRol(Usuario.Rol.MEDICO);
        usuario.setDNI("23940123");
        usuario.setTelefono("2245491232");
        usuario.setNombre("Marcelo");
        usuario.setApellido("Roba facil");
        usuarioDAO.agregar(usuario);
        PersonalDeSalud psd = new PersonalDeSalud();
        psd.setMatricula((long)38201283);
        psd.setUsuario(usuario);
        Usuario usuario3 = new Usuario();
        usuario3.setNombre("Roberto");
        usuario3.setApellido("Sanchez");
        usuario3.setDNI("43673893");
        usuario3.setEmail("sanchez@gmail.com");
        usuario3.setTelefono("+54673893");
        usuario3.setRol(Usuario.Rol.REFERENTE);
        usuarioDAO.agregar(usuario3);
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
        OrganizacionSocial organizacionSocial = new OrganizacionSocial();
        organizacionSocial.setNombre("Comida para todos");
        organizacionSocial.setDomicilio("Calle falsa 123");
        organizacionSocial.setActividadPrincipal("Llevar comida al barrio");
        organizacionSocial.setInformacionAdicional("Fundada 1959");
        organizacionSocial.setUsuario(usuario3);
        organizacionSocial.setBarrio(barrio);
        organizacionSocialDAO.agregar(organizacionSocial);
        Reporte reporte = new Reporte();
        reporte.setNombre("Reporte espiritual");
        reporte.setImagen("data:image://base64");
        reporte.setPublico(true);
        reporte.setCreador(psd);
        List<OrganizacionSocial> list = new ArrayList<OrganizacionSocial>();
        list.add(organizacionSocial);
        reporte.setSolicitantes(list);
        reporteDAO.agregar(reporte);
        tx.commit();
        em.close();
    }
}
