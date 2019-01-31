package com.fernandopaniagua.client;
//Las librerías de HTTP se descargan de http://hc.apache.org/downloads.cgi
//Las librerías de proceso de JSON se descargan de https://code.google.com/archive/p/json-simple/downloads

import java.io.IOException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class HttpManager {
    private String protocol;//http ó https
    private String server;
    private String path;
    private String port;
    private String method;//Método HTTP - POST, GET, PUT...

    public HttpManager(String protocol, String server, String path, String port, String method) {
        this.protocol = protocol;
        this.server = server;
        this.path = path;
        this.port = port;
        this.method = method;
    }

    public HttpManager(String protocol, String server, String path, String method) {
        this.protocol = protocol;
        this.server = server;
        this.path = path;
        this.method = method;
        if (protocol.equalsIgnoreCase("HTTP")){
            this.port = "80";
        } else {
            this.port = "443";
        }
    }
    
    public JSONObject getJSONFromRESTWS() throws IOException, ParseException{
        //https://fpaniaguaformacion.github.io/habitaciones.json
        String url = protocol + "://" + server + ":" + port +  "/" + path;
        System.out.println("URL:" + url);
        Content c = Request.Get(url).execute().returnContent();
        JSONParser jsp = new JSONParser();
        JSONObject jso = (JSONObject)jsp.parse(c.asString());
        /*
        Request.Post("http://targethost/login")
                .bodyForm(Form.form().add("username", "vip").add("password", "secret").build())
                .execute().returnContent();
        */
        return jso;
    }
    
    
}
