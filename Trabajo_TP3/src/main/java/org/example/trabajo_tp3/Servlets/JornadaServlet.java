package org.example.trabajo_tp3.Servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.trabajo_tp3.Modelo.Jornada;
import org.example.trabajo_tp3.Services.JornadaService;
import org.example.trabajo_tp3.Util.ParseJSON;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name="jornada",value="/jornada")
public class JornadaServlet extends HttpServlet {
    private JornadaService  jornadaService;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        jornadaService = new JornadaService();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            JSONObject entrada = ParseJSON.parseJSON(request);
            JSONObject salida = new JSONObject();
            Jornada jornada = new Jornada();
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            if(!checkDataJornada(entrada,jornada)){
                salida.put("mensaje","No se enviaron todos los datos");
            }else{
                if(!jornadaService.agregar(jornada)){
                    salida.put("mensaje","Error al agregar el jornada");
                }else{
                    salida.put("mensaje","Se agrego la jornada con exito");
                }
            }
            out.println(salida);
        }catch(JSONException e){
            e.printStackTrace();
        }
    }
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    private boolean checkDataJornada(JSONObject entrada, Jornada jornada) {
       try{
           if(entrada.has("id")){
               jornada.setId(Integer.parseInt((String)entrada.get("id")));
           }
           if(entrada.has("fecha") && entrada.get("fecha") != null){
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               Date fecha  = sdf.parse((String)entrada.get("fecha"));
               jornada.setFecha(fecha);
           }else{
               return false;
           }
       }catch (JSONException e){
           e.printStackTrace();
       } catch (ParseException e) {
           throw new RuntimeException(e);
       }
        return true;
    }
}
