/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.securedateserver;

import java.util.Date;
import static spark.Spark.*;

public class Spark {

    // View example at https://localhost:4567/secureHello
    public static void main(String[] args) {
        port(getPort());      
        secure("deploy/keystorageserver.jks", "secureServer1zy", null, null);
        get("/", (request, response) -> {
            java.util.Date fecha = new Date();
            return fecha;
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568; //returns default port if heroku-port isn't set (i.e.on localhost)
    }
}
