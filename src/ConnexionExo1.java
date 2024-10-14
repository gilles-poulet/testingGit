//  Exercice 2.3.3 Page 30
//  Pour l'exercice suivant, vous allez créer le programme java permettant: 
//  - La creation de la base de donnees Ecole.
//  - La creation des tables reprises dans le Modele Physique de Donnees (MPD) suivant.
//  - L'insertion des donnees reprises dans les tableaux 2.1 - Section et 2.2 - Cours


//penser à ajouter des logs !!! 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionExo1 {

    public static void main(String[]args) throws Exception{

        //connections logs
        final String url = "jdbc:postgresql://127.0.0.1/";
        final String user = "postgres";
        final String password = "Test1234";

        //DB Connections Strings
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultSet = null;




    }

    
}
