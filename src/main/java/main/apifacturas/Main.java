/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.apifacturas;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author danie
 */
public class Main {
    public static void main(String[] args) throws Exception {    
        SpringApplication.run(Main.class, args);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/cliente/{factura}")
    public ResponseEntity<?> getFacturaCliente(@PathVariable JSONObject factura){                        
        FormatoCliente formato = new ClientePlano();        
        return new ResponseEntity<>(formato.crearFormato(factura),HttpStatus.OK);
    }    
    
    @RequestMapping(method = RequestMethod.GET, path = "/xml/{factura}")
    public ResponseEntity<?> getFacturaXML(@PathVariable String factura){                                
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
