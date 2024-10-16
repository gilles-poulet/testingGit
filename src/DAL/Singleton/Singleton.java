package DAL.Singleton;
import DAL.Postgres.DBInitializer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Singleton {
    
    private String url = "jdbc:postgresql://localhost/";
    private String db = "sgbd";
    private String user = "postgres";
    private String pw = "toto";
    private Connection conn = null;
    private volatile static Singleton single;

    private Singleton() {
        try {
            conn = DriverManager.getConnection(url, user, pw);
            DBInitializer.initDB(this, db);
            close();
            conn = DriverManager.getConnection(url+db, user, pw);
            DBInitializer.initTables(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public static Singleton getInstance() {
        if (single == null) {
            synchronized (Connection.class) {
                if (single == null) {
                    single = new Singleton();
                }
            }
        }
        return single;
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
