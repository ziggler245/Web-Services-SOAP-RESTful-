package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.Fight;

/**
 *
 * @author Serhii Khaliavin
 */


public class FightDB {
    
    public static final int seatCount = 16;
    ArrayList<Fight> allFight = new ArrayList();
 
    
    private FightDB(){
    }
    
    private static FightDB instance;
    
      public static FightDB getInstance() {
        if (instance == null) {
            instance = new FightDB();
        }

        return instance;
    }
      
      private ArrayList<String> getSeat(PreparedStatement stmt) throws SQLException {
     
        ArrayList<String> list = new ArrayList<>();
        ResultSet rs = null;
        
        try {
            rs = stmt.executeQuery();
             while(rs.next()){         
             
                list.add(fillSeats(rs));   
               
            }
 
        } finally {
            rs.close();
            stmt.close();            
        return list;
    }
          }
          
          private ArrayList<Fight> getFight(PreparedStatement stmt,String name) throws SQLException {
     
        ArrayList<Fight> list = new ArrayList<>();
        ResultSet rs = null;
       
        try {
            rs = stmt.executeQuery();
         
            while(rs.next()){         
                 list.add(fillFight(rs, name));   
               
            }
 
        } finally {
            rs.close();
            stmt.close();            
            return list;
    }
          }
          
          private ArrayList<Fight> getFightPpv(PreparedStatement stmt,String name) throws SQLException {
     
        ArrayList<Fight> list = new ArrayList<>();
        ResultSet rs = null;
        
        try {
            rs = stmt.executeQuery();
         
            while(rs.next()){         
              
                list.add(fillFight(rs, name));   
               
            }
 
        } finally {
            rs.close();
            stmt.close();            
  
      return list;
    }
          }
        
          
              private Fight fillFight(ResultSet rs,String ppv_name) throws SQLException {
          
         Fight fight = new Fight();        
        fight.setId(rs.getInt("id"));
        fight.setCountry(rs.getString("country"));
        fight.setPpv(rs.getString("name"));
        fight.setDate(rs.getString("date"));
        fight.setDuration(rs.getString("duration"));
       int q=  seatCount-GetPpv(ppv_name);
       fight.setFreePlace(String.valueOf(q)    );

        return fight;
    }
              
                 private String fillSeats(ResultSet rs) throws SQLException {

      return rs.getString("seats");
    }
      

                   public ArrayList<Fight> getAllFights(ArrayList<String> country) {
              allFight.clear();
        try {
            
            for(int i=0;i<country.size();i++){
                if(getFight(getAllFightsStmt(country.get(i),getTable(country.get(i))),country.get(i)).isEmpty()){}else
                
            allFight.add(getFight(getAllFightsStmt(country.get(i),getTable(country.get(i))),country.get(i)).get(0));
               
            }
            
            return allFight;
        } catch (SQLException ex) {
            Logger.getLogger(FightDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Connections.getInstance().closeConnection();
        }
        return null;
    }
                 
          public ArrayList<String> getAllSeats(String ppv) throws SQLException {
               ArrayList<String> allSeats = new ArrayList();
             allSeats.addAll(getSeat(getAllSeatsStmt(ppv,getTable(ppv))));
             return allSeats;
             
    }
           public ArrayList<Fight> getAllFightsPpv(String ppv,String country,String date) {
              allFight.clear();
        try {
           int sizes=getFightPpv(getAllFightsPpvStmt(ppv,getTable(ppv),country,date),ppv).size();
             for(int i=0;i<sizes;i++){
                
            allFight.add(getFightPpv(getAllFightsPpvStmt(ppv,getTable(ppv),country,date),ppv).get(0));
               
            }
                return allFight;
        } catch (SQLException ex) {
            Logger.getLogger(FightDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Connections.getInstance().closeConnection();
        }
        return null;
    }
       
           
          private PreparedStatement getAllFightsStmt(String ppv,String table_name) throws SQLException {
              
   Connection conn = Connections.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("select distinct spr_countries.name as country,ppv.id, (select count(*) from spr_fastlane where spr_fastlane.free=\"yes\" ), ppv.name,ppv.table_name,finall_fight.duration,finall_fight.date\n" +
" from finall_fight,ppv,spr_countries,spr_fastlane\n" +
" where finall_fight.spr_ppv=ppv.id and finall_fight.spr_countries=spr_countries.id and  ppv.name=\""+ppv+"\"  ");
     
        return stmt;
    
    }
          
               private PreparedStatement getAllFightsPpvStmt(String ppv,String table_name,String country,String date) throws SQLException {
              
   Connection conn = Connections.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("select distinct spr_countries.name as country,ppv.id, (select count(*) from spr_fastlane where spr_fastlane.free=\"yes\" ), ppv.name,ppv.table_name,finall_fight.duration,finall_fight.date\n" +
" from finall_fight,ppv,spr_countries,spr_fastlane\n" +
" where finall_fight.spr_ppv=ppv.id and finall_fight.spr_countries=spr_countries.id and  ppv.name=\""+ppv+"\" and spr_countries.name=\""+country+"\"\n" +
" and date like \""+date+"%\"");
             
        return stmt;
    
    }
               
               
                   private PreparedStatement getAllSeatsStmt(String ppv,String table_name) throws SQLException {
              
        Connection conn = Connections.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("select seats from "+table_name+" where free=\"yes\"");
        return stmt;
    
    }

               
               
               
    private int GetPpv(String ppv) throws SQLException {
        
        Connection conn = Connections.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("select count(*) as cont  from reservation left join finall_fight on reservation.spr_finall_fight=finall_fight.id\n" +
"left join ppv on ppv.id=finall_fight.spr_ppv where ppv.name=\""+ppv+"\"");    
       
        int answer = 0;
        ResultSet rs = null;

        try {
            rs = stmt.executeQuery();

            while(rs.next()){                
                answer=  rs.getInt("cont");
            }
 
        } finally {
            rs.close();
            stmt.close();            
       
   
    }
          
       return answer;
      
}

    private String getTable(String ppv) throws SQLException {
        
         Connection conn = Connections.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM web_service.ppv where name=\""+ppv+"\"");    
       
        String answer = null ;
        ResultSet rs = null;

        try {
            rs = stmt.executeQuery();

            while(rs.next()){                
                answer=rs.getString("table_name");
            }
 
        } finally {
            rs.close();
            stmt.close();            
       
   
    }
          
       return answer;
        
    }

    private PreparedStatement getAllFightsCountryStmt(String ppv, String table_name) throws SQLException {
       
        
                     
   Connection conn = Connections.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("select distinct spr_countries.name as country, (select count(*) from "+table_name+" where "+table_name+".free=\"yes\" ), ppv.name,ppv.table_name,finall_fight.duration,finall_fight.date\n" +
" from finall_fight,ppv,spr_countries,"+table_name+"\n" +
" where finall_fight.spr_ppv=ppv.id and finall_fight.spr_countries=spr_countries.id and  spr_countries.name=\""+ppv+"\"");
        return stmt;
         
    }

}
