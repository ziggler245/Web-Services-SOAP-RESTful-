package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Serhii Khaliavin
 */
public class Connections {

    private static Connection conn;
    private static InitialContext ic;
    private static DataSource ds;

    private Connections() {
    }
    private static Connections instance;

    public static Connections getInstance() {
        if (instance == null) {
            instance = new Connections();
        }

        return instance;
    }

    public Connection getConnection() {

        try {

            if (conn == null || conn.isClosed()) {

                ic = new InitialContext();
                ds = (DataSource) ic.lookup("web_service");
                conn = ds.getConnection();

            }

        } catch (SQLException | NamingException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return conn;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Connections.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
