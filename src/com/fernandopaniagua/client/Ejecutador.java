/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernandopaniagua.client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author fernando.paniagua
 */
public class Ejecutador {
    public static void main(String[] args) {
        //https://fpaniaguaformacion.github.io/habitaciones.json
        HttpManager man = new HttpManager(
                "https",
                "fpaniaguaformacion.github.io",
                "habitaciones.json",
                "GET");
        try {
            JSONObject jso = man.getJSONFromRESTWS();
            JSONArray hotel = (JSONArray)jso.get("hotel");
            for (Object object : hotel) {
                Long numero = (Long)((JSONObject)object).get("numero");
                System.out.println(numero.toString());
            }
        } catch (IOException ex) {
            System.err.println("IO EXCEPTION");
            ex.printStackTrace();
        } catch (ParseException ex) {
            System.err.println("PARSE EXCEPTION");
            ex.printStackTrace();
        }
    }
    
}
