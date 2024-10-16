package DAL.Postgres;
import DAL.Singleton.Singleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInitializer {
    private static final String createTables = "/resources/sql/script.sql";

    private DBInitializer() {
    }

    public static void initDB(Singleton single, String dbName) {
        PreparedStatement ps = null;
        try {
            ps = single.getConnection().prepareStatement("SELECT 1 FROM pg_database WHERE datname = ?;");
            ps.setString(1, dbName);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                ps.close();
                try {
                    ps = single.getConnection().prepareStatement("CREATE DATABASE " + dbName + ";");
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void initTables(Singleton single) throws SQLException {
        executeSqlScript(single, createTables);
    }

    private static void executeSqlScript(Singleton single, String sqlFilePath) throws SQLException {
        StringBuilder sqlScript = new StringBuilder();

        try {
            InputStream is = DBInitializer.class.getResourceAsStream(sqlFilePath);
            if (is == null) {
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                sqlScript.append(line).append("\n"); 
            }
            try {
                if (is != null) {
                    is.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Statement st = single.getConnection().createStatement()) { 
            st.execute(sqlScript.toString());
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
