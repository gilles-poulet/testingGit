package main.java.DAL.Section;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.java.BL.Section.Section;

public class SectionDAO implements ISectionDAO {

    // // Information de connexion
    // final String url = "jdbc:postgresql://127.0.0.1/";
    // final String user = "postgres";
    // final String password = "Test1234";
    // // Connexion a la base de donnees.
    // Connection connexion = null;
    // Statement statement = null;
    // ResultSet resultSet = null;

    @Override
    public ArrayList<Section> getSections() {

        final String url = "jdbc:postgresql://127.0.0.1/";
        final String user = "postgres";
        final String password = "Test1234";
        Statement request = null;
        Connection connexion = null;
        ResultSet set = null;
        ArrayList<Section> liste = new ArrayList<>();

        try {
            // 'url' : l'URL de la base de données (ex: jdbc:mysql://localhost:3306/)
            // 'user' : le nom d'utilisateur pour la connexion
            // 'password' : le mot de passe associé à l'utilisateur
            connexion = DriverManager.getConnection(url, user, password);
            // Création d'un objet Statement permettant d'exécuter des requêtes SQL
            request = connexion.createStatement();

            try {
                // Tentative d'exécution d'une requête SQL pour créer une nouvelle base de
                // données appelée "UE1396"
                request.executeUpdate("CREATE DATABASE UE1396");

            } catch (SQLException ex)
            // Si une erreur SQL survient (comme une base de données existante, problème de
            // droits, etc.),
            // l'exception est capturée et son message d'erreur est imprimé dans la console
            {
                ex.printStackTrace();
            } finally {
                if (request != null) {
                    try {
                        request.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                if (connexion != null) {
                    try {
                        connexion.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            }

            connexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/UE196", user, password);
            request = connexion.createStatement();
            try {
                request.executeUpdate("CREATE TABLE Section(id SERIAL PRIMARY KEY, nom VARCHAR(30) UNIQUE )");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            set = request.executeQuery("SELECT nom FROM Section");
            while (set.next()) {
                Section section = new Section();
                section.setNom(set.getString("nom"));
                liste.add(section);
            }
        }

        catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (request != null) {
                try {
                    request.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        }
        return liste;
    }

    @Override
    public int getIDSection(String nom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIDSection'");
    }

    @Override
    public boolean updateSection(int id, String nom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSection'");
    }

    @Override
    public boolean deleteSection(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSection'");
    }

    @Override
    public boolean addSection(String nom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addSection'");
    }

}
