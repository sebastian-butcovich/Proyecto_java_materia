package org.example.trabajo_tp3.Util;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.trabajo_tp3.Modelo.Usuario;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public  class ParseJSON<T> {
    public static JSONObject parseJSON(HttpServletRequest req) throws IOException, JSONException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine()) != null){
            sb.append(line);
        }
        String json = sb.toString();
        return  new JSONObject(json);
    }
    public String listToJson(List<T> usuarios) {
        Gson gson = new Gson();
        String json = gson.toJson(usuarios);
        return json;
    }
}
