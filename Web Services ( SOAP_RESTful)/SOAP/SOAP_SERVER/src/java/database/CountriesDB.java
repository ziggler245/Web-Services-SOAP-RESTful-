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
public class CountriesDB {
   
    
       private static CountriesDB instance;
    
      public static CountriesDB getInstance() {
        if (instance == null) {
            instance = new CountriesDB();
        }
    
    return instance;
}
      
      
        public ArrayList<String> getAllCountries() {
        try {
            return getPpv(getAllCountriesStmt());
        } catch (SQLException ex) {
            Logger.getLogger(CountriesDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Connections.getInstance().closeConnection();
        }
        return null;
    }
         private ArrayList<String> getPpv(PreparedStatement stmt) throws SQLException {

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
            private PreparedStatement getAllCountriesStmt() throws SQLException {
             
        Connection conn = Connections.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from spr_countries ");
        return stmt;
    
    }
    
    
}
