package com.example;
import java.sql.*;

public class TestInjection {
    private String prenom;
    private String nom;
    private String mdp;


    public TestInjection(String prenom, String nom, String mdp) {
        this.prenom = prenom;
        this.nom = nom;
        this.mdp = mdp;
    }

    public void testInjection() {
       
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

    public boolean UtilisateursOuiOuNon(resultats) {
        if (resultats == null) {
            return false;
        }else {
            return true;
        }
    }
}