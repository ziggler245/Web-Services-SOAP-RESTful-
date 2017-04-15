package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Serhii Khaliavin
 */
public class Ppvs {
    
    private Ppvs(){
    }
    
    private static Ppvs instance;
    
      public static Ppvs getInstance() {
        if (instance == null) {
            instance = new Ppvs();
        }
    
    return instance;
}   
        private ArrayList<String> getAllPpv(PreparedStatement stmt) throws SQLException {

        ArrayList<String> list = new ArrayList<>();
        ResultSet rs = null;

        try {
            rs = stmt.executeQuery();

            while(rs.next()){                
                list.add(rs.getString("name"));            
            }
 
        } finally {
            rs.close();
            stmt.close();            
        }

        return list;
    }
               

                  public ArrayList<String> getAllCountries() {
        try {
            return getAllPpv(getAllPpvStmt());
        } catch (SQLException ex) {
            Logger.getLogger(Ppvs.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Connections.getInstance().closeConnection();
        }
        return null;
    }
               
    private PreparedStatement getAllPpvStmt() throws SQLException {
         
        Connection conn = Connections.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from ppv");
        return stmt;
    
    }

}