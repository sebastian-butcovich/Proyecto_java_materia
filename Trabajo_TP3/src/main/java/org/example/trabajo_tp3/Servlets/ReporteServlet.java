package org.example.trabajo_tp3.Servlets;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.trabajo_tp3.Modelo.Reporte;
import org.example.trabajo_tp3.Modelo.Usuario;
import org.example.trabajo_tp3.Services.ReporteService;
import org.example.trabajo_tp3.Services.UserServicie;
import org.example.trabajo_tp3.Util.ManagerFactory;
import org.example.trabajo_tp3.Util.ParseJSON;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="Reporte",value="/reporte")
public class ReporteServlet extends HttpServlet {
    private ParseJSON parseJSON;
    private ReporteService  reporteService;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        parseJSON = new ParseJSON();
        reporteService = new ReporteService();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<Reporte> reportes = reporteService.listar();
        ParseJSON parseJSON = new ParseJSON();
        String salida = parseJSON.listToJson(reportes);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(salida);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JSONObject entrada = ParseJSON.parseJSON(request);
            JSONObject salida = new JSONObject();
            Reporte reporte = new Reporte();
            PrintWriter out = response.getWriter();
            if(checkDataReporte(entrada,reporte)){
                if(reporteService.agregar(reporte)){
                    salida.put("mensaje","Se agrego el reporte");
                }else{
                    salida.put("mensaje","No se agrego el reporte por falla interna");
                }
            }else{
                salida.put("mensaje","No estan todos los datos.");
            }
            out.print(salida);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            JSONObject entrada = ParseJSON.parseJSON(request);
            JSONObject salida = new JSONObject();
            Reporte reporte = new Reporte();
            PrintWriter out = response.getWriter();
            if (!checkDataReporte(entrada,reporte)){
                salida.put("mensaje","No se envio los datos completos");
            }else{
                if(reporteService.actualizar(reporte)){
                    salida.put("mensaje","Se actualizo el reporte");
                }else{
                    salida.put("mensaje","No se actualizo el reporte");
                }
            }
            out.print(salida);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        JSONObject salida = new JSONObject();
        try{
            if(request.getParameter("id") == null ||  Integer.parseInt(request.getParameter("id"))<=0){
                salida.put("mensaje","No se envio el id del registro que se quiere eliminar o el id es invalido");
            }else{
                if(!reporteService.eliminar(Integer.parseInt(request.getParameter("id")))){
                    salida.put("mensaje","No se elimino el reporte por que no se encontro o por problemas internos");
                }else{
                    salida.put("mensaje","Se elimino el reporte");
                }
            }
        }catch (JSONException e) {
            throw new RuntimeException(e);
        }
        out.print(salida);
    }
    private boolean checkDataReporte(JSONObject entrada, Reporte reporte) throws JSONException {
        if(entrada.has("id") && (int)entrada.get("id") > 0){
            reporte.setId(entrada.getInt("id"));
        }
        if(!entrada.has("nombre") && entrada.get("nombre") ==null)
        {
            return false;
        }else {
            reporte.setNombre(entrada.getString("nombre"));
        }
        if(!entrada.has("imagen") &&  entrada.get("imagen") ==null)
        {
            return false;
        }else{
            reporte.setImagen(entrada.getString("imagen"));
        }
        if(!entrada.has("publico") &&  entrada.get("publico") ==null){
            return false;
        }else{
            reporte.setPublico(entrada.getBoolean("publico"));
        }
//        if(!entrada.has("personal_de_salud") || entrada.get("personal_de_salud") ==null){
//            return false;
//        }else{
//            UserServicie userServicie = new UserServicie();
//            Usuario u = userServicie.buscarPorId(entrada.getInt("id"));
//            if(u == null){
//                return false;
//            }else{
//                reporte.se
//            }
//
//        }
        return true;
    }
}
