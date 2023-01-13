/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author AIMERICK NOUA
 */

public class Connexion {

    private static Connection conex;
    private String url = "jdbc:postgresql://localhost:5432/job_tracking";
    private String user = "postgres";
    private String pwd = "00000000";

    private Connexion() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.out.println("Erreur d'ouverture du Driver :" + e.getMessage());
        }

        try {
            conex = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.out.println("Erreur d'entrer a' la base de donnee" + e.getMessage());
        }
    }

    public static Connection seconnecter() {
        if (conex == null) {
            Connexion connection = new Connexion();    
        }
        return conex;
    }

}
