/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.apifacturas;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Iterator;
import org.json.JSONObject;

/**
 *
 * @author danie
 */
public class ClientePlano implements FormatoCliente{

    String facturaPlana = "FACTURA CLIENTE\n";
    
    @Override
    public String crearFormato(JSONObject json) {
        Iterator<String> keys = json.keys();
        while (keys.hasNext()){
            String llave = keys.next();  
            facturaPlana += llave + ": " + json.getString(llave) + "\n";
        }                
        return facturaPlana;        
    }
    
}
