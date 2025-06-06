package org.example.trabajo_tp3.Servlets;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.trabajo_tp3.DAO.EntityImpl.FiltroMapaDAO;
import org.example.trabajo_tp3.DAO.EntityImpl.UsuarioDAO;
import org.example.trabajo_tp3.Modelo.FiltroDelMapa;
import org.example.trabajo_tp3.Modelo.Usuario;
import org.example.trabajo_tp3.Util.ManagerFactory;

import java.io.IOException;
@WebServlet(name="ejemplo_filtro_mapa", value="/ejemploF")
public class EjemploFiltroMapa extends HttpServlet {
    private FiltroMapaDAO filtroMapaDAO = new FiltroMapaDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    public void init(ServletConfig  servletConfig) throws ServletException {
        super.init(servletConfig);
        filtroMapaDAO = new FiltroMapaDAO();
        usuarioDAO = new UsuarioDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = ManagerFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Usuario usuario = new Usuario();
        usuario.setNombre("Elias");
        usuario.setApellido("Orbe");
        usuario.setEmail("eliasorbe@gmail.com");
        usuario.setDNI("40393210");
        usuario.setTelefono("2241596232");
        usuario.setRol(Usuario.Rol.MEDICO);
        usuarioDAO.agregar(usuario);
        FiltroDelMapa  filtroDelMapa = new FiltroDelMapa();
        filtroDelMapa.setEnfermedades("Gripe Porcina, Sida, Lepra");
        filtroDelMapa.setSociales("Falta de agua, Falta de cloacas");
        filtroDelMapa.setUsuario(usuario);
        filtroMapaDAO.agregar(filtroDelMapa);
        if(usuario.getDNI() != null && filtroDelMapa.getId()!=null){
            tx.commit();
        }
        em.close();
    }
}
