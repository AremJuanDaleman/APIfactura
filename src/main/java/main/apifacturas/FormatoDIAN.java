/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.apifacturas;

import org.json.JSONObject;

/**
 *
 * @author juan 
 */
public interface FormatoDIAN {
    String crearFormato(JSONObject factura);
}
