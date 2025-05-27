package org.example.trabajo_tp3.Servlets;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.trabajo_tp3.Modelo.Barrio;
import org.example.trabajo_tp3.Services.BarrioServicie;
import org.example.trabajo_tp3.Util.ManagerFactory;
import org.example.trabajo_tp3.Util.ParseJSON;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="barrio",value = "/barrio")
public class BarrioServlet extends HttpServlet {
    private BarrioServicie  barrioServicie;
    private ParseJSON parseJSON;
    public void init(ServletConfig config) throws ServletException {
        barrioServicie = new BarrioServicie();
        parseJSON = new ParseJSON();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Barrio> barrios= barrioServicie.listar();
        String usuariosString = parseJSON.listToJson(barrios);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(usuariosString);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JSONObject datosEntrada = ParseJSON.parseJSON(request);
            JSONObject datosSalida = new JSONObject();
            Barrio barrio;
            if((datosEntrada.has("nombre")&&!datosEntrada.get("nombre").equals(""))
                    || (datosEntrada.has("informacionAdicional") && !datosEntrada.get("informacionAdicional").equals("") )) {
                barrio = new Barrio();
                barrio.setNombre(datosEntrada.getString("nombre"));
                barrio.setInformacionAdicional(datosEntrada.getString("informacionAdicional"));
                boolean res =barrioServicie.agregar(barrio);
                if(res){
                    datosSalida.put("mensaje","Se agrego el barrio correctamente");
                }else{
                    datosSalida.put("mensaje","Error al agregar el barrio");
                }
            }else {
                datosSalida.put("mensaje","Error al agregar el barrio. Faltan datos");
            }
            PrintWriter out  = response.getWriter();
            out.print(datosSalida);
            out.close();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    public void destroy(){

    }
}
