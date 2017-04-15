package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import objects.Fight;

/**
 *
 * @author Serhii Khaliavin
 */
public class ClientDB {
    Context ctx=null;
    DataSource ds=null;
    Statement stmt=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;
    String table_name;
    ArrayList<Fight> allFight = new ArrayList();
     
    private ClientDB(){
    }
    
      private static ClientDB instance;
    
      public static ClientDB getInstance() {
        if (instance == null) {
            instance = new ClientDB();
        }

        return instance;
    }
      public void insert(String name,String surname,String phone,String email,String ncard,String place,int index){
      
            try {
            Connection conn = Connections.getInstance().getConnection();
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("wwe_final");
          
           
                  conn.setAutoCommit(false);
                 
                stmt = conn.createStatement();
              
          
                 pstmt = conn.prepareStatement("select table_name from ppv where id='"+index+"'");
                 rs = pstmt.executeQuery();          
          while(rs.next()){          
          table_name=rs.getString("table_name");
         
          }
                
                conn.setSavepoint();//Start Transactions
                 stmt.executeUpdate("insert into passenger(name,surname,document_number,email,phone) values(\""+name+"\",\""+surname+"\",\""+phone+"\",\""+email+"\",\""+ncard+"\");");
    stmt.executeUpdate("insert into reservation(spr_finall_fight,spr_passenger,seat)values((select id from finall_fight where spr_ppv="+index+"),(select MAX(id) from passenger),\""+place+"\");");
     stmt.executeUpdate("update "+table_name+" set free =\"no\" where seats=\""+place+"\"");
       conn.commit();//End Transactions
               
            
            
        } catch (NamingException |SQLException ex) {
            Logger.getLogger(ClientDB.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
   
      
      public    ArrayList<Fight> checkClient(String ncard,String email) {
        try {
             allFight.clear();
             allFight.addAll(getClient(getCheckStmt(ncard, email))) ;
        } catch (SQLException ex) {
            Logger.getLogger(ClientDB.class.getName()).log(Level.SEVERE, null, ex);
              
        }
              return allFight;
                 
    }
      
        public ArrayList<Fight> getClient(PreparedStatement stmt) throws SQLException {
     
        ArrayList<Fight> list = new ArrayList();
        ResultSet rs = null;
        
        try {
            rs = stmt.executeQuery();
          
          while(rs.next())  { 
                Fight fight = new Fight();
                fight.setCountry(rs.getString("country"));
                fight.setDate(rs.getString("date"));
                fight.setDuration(rs.getString("duration"));
                fight.setFreePlace(rs.getString("seat"));
                fight.setPpv(rs.getString("ppv"));
                list.add(fight);
                
            }
 
        } finally {
            rs.close();
            stmt.close();            
       
      return list;
    }
          }
           
   
     private PreparedStatement getCheckStmt(String ncard,String email) throws SQLException {
              
   Connection conn = Connections.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT reservation.seat,finall_fight.date,ppv.name as ppv,spr_countries.name as country,finall_fight.duration FROM web_service.reservation inner join passenger on reservation.spr_passenger=passenger.id \n" +
"inner join finall_fight on finall_fight.id=reservation.spr_finall_fight inner join spr_countries on spr_countries.id=finall_fight.spr_countries inner join ppv on ppv.id=finall_fight.spr_ppv\n" +
" where passenger.document_number=\""+ncard+"\" and email=\""+email+"\";");
     
        return stmt;
    
    }
   
}
