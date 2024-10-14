import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
    public static void main(String[] args) throws Exception {
        // Information de connexion
        final String url = "jdbc:postgresql://127.0.0.1/";
        final String user = "postgres";
        final String password = "Test1234";

        // Connexion a la base de donnees.
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connexion = DriverManager.getConnection(url, user, password);
            System.out.println("Connecte au serveur de gestion de la base de donnee." + url);
            statement = connexion.createStatement();
            try {
                String requeteSQLCreate = "CREATE DATABASE test1";
                statement.executeUpdate(requeteSQLCreate);
            } catch (SQLException e) {
                System.out.println("Base de donnees test1 deja existante.\n" + e.getMessage());
            }
            // On ferme la connexion existante pour se connecter sur la base de donnee
            // test1.
            statement.close();
            connexion.close();
            connexion = DriverManager.getConnection(url + "test1", user, password);
            statement = connexion.createStatement();
            String requeteSQLTable = "CREATE TABLE IF NOT EXISTS Status (id SERIAL PRIMARY KEY, status VARCHAR(20))";
            statement.executeUpdate(requeteSQLTable);
            String requeteSQLValeur = "INSERT INTO status (status) VALUES('Etudiant'),('Charge de cours'),('Administratif')";
            statement.executeUpdate(requeteSQLValeur);
            String requesteSQLValeurDansTableTest1 = "SELECT id, status FROM status";
            resultSet = statement.executeQuery(requesteSQLValeurDansTableTest1);
            while (resultSet.next()) {
                // Attention, les indices commencent a 1 et non 0.
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Toujours fermer les requetes.
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }

            // Toujours fermer la connexion a la base de donnees.
            if (connexion != null) {
                connexion.close();
            }
        }

    }

}
