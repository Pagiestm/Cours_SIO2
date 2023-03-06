package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

class InjectionTest {

    @Test
    public void Injection_VérificationConnexion_DoitRefuser() {
        // Arranger

        String url = "jdbc:mysql://localhost:3306/testInjection";
        try {
        Connection con = DriverManager.getConnection(url, "root", "");
        Statement stmt = con.createStatement();
        ResultSet resultats = null;
        String requete = "SELECT prenom, nom, mdp FROM test";
        resultats = stmt.executeQuery(requete);
        System.out.println(resultats);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
