package org.example.trabajo_tp3.Servlets;

import com.google.gson.JsonObject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.trabajo_tp3.Modelo.*;
import org.example.trabajo_tp3.Services.BarrioServicie;
import org.example.trabajo_tp3.Services.OrganizacionSocialService;
import org.example.trabajo_tp3.Services.PersonalDeSaludService;
import org.example.trabajo_tp3.Services.UserServicie;
import org.example.trabajo_tp3.Util.ManagerFactory;
import org.example.trabajo_tp3.Util.ParseJSON;
import org.hibernate.Transaction;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name="servlet-user",value = "/usuario")
public class UsuarioServlet extends HttpServlet {
    private UserServicie userServicie;
    private PersonalDeSaludService personalDeSaludService;
    private OrganizacionSocialService organizacionSocialService;
    private ParseJSON parseJSON;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userServicie = new UserServicie();
        personalDeSaludService = new PersonalDeSaludService();
        organizacionSocialService = new OrganizacionSocialService();
        parseJSON = new ParseJSON();
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> usuarios = userServicie.listar();
        String usuariosString = parseJSON.listToJson(usuarios);
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.println(usuariosString);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject rol = new JSONObject();
        PrintWriter out = resp.getWriter();
        Usuario u = new Usuario();
        JSONObject jsonObject = new JSONObject();
        try {
            if(!checkData(req, resp, u, rol)){
                resp.setContentType("application/json");
                jsonObject.put("mensaje","No se pudo agregar el usuario. Faltan datos");
            }else if(checkRepeat(u)) {
                boolean res =userServicie.agregar(u);
                if(res){
                    agregarEspecialidad(rol, u);
                    jsonObject.put("mensaje","Usuario agregado correctamente");
                }else{
                    jsonObject.put("mensaje","Usuario no agregado correctamente");
                }
            }else{
                jsonObject.put("mensaje","El usuario que quiere agregar ya se encuentra en el sistema.");
            }
            out.println(jsonObject);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario u = new Usuario();
        JSONObject rol = new JSONObject();
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        JSONObject jsonObject = new JSONObject();
        try {
            if(!checkData(req,resp,u, rol)){
                jsonObject.put("mensaje","No se pudo agregar el usuario. Faltan datos o no existe");
            }else {
                boolean response = userServicie.actualizar(u);
                if(response){
                    jsonObject.put("mensaje","Usuario actualizado correctamente");
                }else{
                    jsonObject.put("mensaje","Usuario no encontrado o no se envio el id");
                }
            }
            out.println(jsonObject);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        JSONObject jsonObject = new JSONObject();
        if(req.getParameter("id") == null){
            try {
                jsonObject.put("mensaje","No se envio el id");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            out.println(jsonObject);
        }
            else{
                long id = Long.parseLong(req.getParameter("id"));
                userServicie.eliminar(id);
            try {
                jsonObject.put("mensaje","Se elimino correctamente el usuario");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private boolean checkData(HttpServletRequest req, HttpServletResponse resp, Usuario u, JSONObject rol) throws IOException, JSONException {
        JSONObject json = ParseJSON.parseJSON(req);
        if(json.has("id")){
            u.setId(json.getInt("id"));
        }
        if(json.get("nombre") != null && json.get("nombre") != "") {
            u.setNombre((String)json.get("nombre"));
        }else {
            resp.sendError(404,"No se envio el nombre del usuario");
            return false;
        }
        if(json.get("apellido") != null && json.get("apellido") != "") {
            u.setApellido((String)json.get("apellido"));
        }else {
            resp.sendError(404,"No se envio el apellido del usuario");
            return false;
        }
        if(json.get("email") != null && json.get("email") != "") {
            u.setEmail((String)json.get("email"));
        }else{
            resp.sendError(404,"No se envio el email del usuario");
            return false;
        }
        if(json.get("dni") != null && json.get("dni") != "") {
            u.setDNI((String)json.get("dni"));
        }else {
            resp.sendError(404,"No se envio el dni del usuario");
            return false;
        }
        if(json.get("telefono") != null && json.get("telefono") != "") {
            u.setTelefono((String)json.get("telefono"));
        }else {
            resp.sendError(404,"No se envio el telefono del usuario");
            return false;
        }
        if(json.get("rol") != null && json.get("rol") != "") {
            u.setRol(parseRol((String)json.get("rol")));
            if(json.get("datos_rol") != null && json.get("datos_rol") != "") {
                String rolString = json.get("rol").toString();
                tomarDatosRol(json.getJSONObject("datos_rol"),rol,rolString);
            }
        }
        return true;
    }
    private boolean checkRepeat( Usuario u){
        boolean response = false;
        EntityManager entityManager = ManagerFactory.getEntityManager();
        String hql = "FROM Usuario WHERE email = :userEmail";
        Query query = entityManager.createQuery(hql);
        query.setParameter("userEmail", u.getEmail());
        List u1 =  query.getResultList();
        if(!u1.isEmpty()){
            response = false;
        }else {
            response = true;
        }
        return response;
    }
    private Usuario.Rol parseRol(String rol){
        if(rol.equals("ADMINISTRADOR")){
            return Usuario.Rol.ADMINISTRADOR;
        }
        if(rol.equals("MEDICO")){
            return Usuario.Rol.MEDICO;
        }
        if(rol.equals("REFERENTE")){
            return Usuario.Rol.REFERENTE;
        }
        if(rol.equals("ENCUESTADOR")){
            return Usuario.Rol.ENCUESTADOR;
        }
        return null;
    }
    private void tomarDatosRol(JSONObject json, JSONObject rol,String rolString) throws JSONException {
        if(rolString.equals("MEDICO")){
            rol.put("rol","Medico");
            rol.put("matricula",json.get("matricula"));
        }
        if(rolString.equals("ORGANIZACION SOCIAL")){
            rol.put("rol","ORGANIZACION SOCIAL");
            rol.put("nombre",json.get("nombre"));
            rol.put("domicilio",json.get("domicilio"));
            rol.put("informacion_adicional",json.get("informacion"));
            rol.put("barrio",json.get("barrio"));
            rol.put("actividad_principal",json.get("actividad_principal"));
        }
        if(rolString.equals("ENCUESTADOR")){
            rol.put("rol","Encuestador");
            rol.put("genero",json.get("genero"));
            rol.put("edad",json.get("edad"));
            rol.put("ocupacion",json.get("ocupacion"));
        }
    }
    private void agregarEspecialidad(JSONObject rol, Usuario usuario) throws JSONException {
        EntityManager entityManager = ManagerFactory.getEntityManager();
        String hql = "FROM Usuario WHERE email = :userEmail";
        Query query = entityManager.createQuery(hql);
        query.setParameter("userEmail", usuario.getEmail());
        List<Usuario> u1 =  query.getResultList();
        Usuario search = u1.get(0);
        entityManager.close();
        seleccionarEspecialidad(search,rol);
    }
    private void seleccionarEspecialidad(Usuario u,JSONObject rol) throws JSONException {
        if(rol.get("rol").equals("MEDICO")){
            PersonalDeSalud personalDeSalud = new PersonalDeSalud();
            personalDeSalud.setMatricula(Long.parseLong((String)rol.get("matricula")));
            personalDeSalud.setUsuario(u);
            personalDeSaludService.agregar(personalDeSalud);
        }
        if(rol.get("rol").equals("ORGANIZACION SOCIAL")){
            OrganizacionSocial organizacionSocial = new OrganizacionSocial();
            organizacionSocial.setNombre((String)rol.get("nombre"));
            organizacionSocial.setDomicilio((String)rol.get("domicilio"));
            organizacionSocial.setInformacionAdicional((String)rol.get("informacion_adicional"));
            organizacionSocial.setActividadPrincipal((String)rol.get("actividad_principal"));
            organizacionSocial.setUsuario(u);
            EntityManager entityManager = ManagerFactory.getEntityManager();
            Barrio b = entityManager.find(Barrio.class, Long.parseLong((String)rol.get("barrio")));
            entityManager.close();
            organizacionSocial.setBarrio(b);
            organizacionSocialService.agregar(organizacionSocial);
        }
        if(rol.get("rol").equals("ENCUESTADOR")){
            Encuestador encuestador = new Encuestador();
            encuestador.setGenero((String)rol.get("genero"));
            encuestador.setOcupacion((String)rol.get("ocupacion"));
            encuestador.setEdad((Integer)rol.get("edad"));
            encuestador.setUsuario(u);
        }
    }
}
