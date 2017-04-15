package ws;

import database.ClientDB;
import database.CountriesDB;
import database.Ppvs;
import database.FightDB;
import exceptions.Exceptions;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;
import objects.Fight;

/**
 *
 * @author Serhii Khaliavin
 */
@WebService(serviceName = "WService")
@Addressing
public class WrestleService {
    
     public  ArrayList<String> getAllPpv() {
       
     ArrayList<String> list = Ppvs.getInstance().getAllCountries();
    return list;
    
    }
     
        
     public ArrayList<String> getAllCountries() {
       
     ArrayList<String> list = CountriesDB.getInstance().getAllCountries();
    return list;
    
    }
     
      
     public ArrayList<Fight> getAllFights() {
       
     ArrayList<Fight> list = FightDB.getInstance().getAllFights(getAllPpv());
    return list;
    
    }
     
         public ArrayList<Fight> check(String ncard,String email)throws Exceptions  {
       
    ArrayList<Fight>fight= ClientDB.getInstance().checkClient(ncard, email);
     if(fight.size()==0)
     throw new Exceptions("No information!");
      else

    return fight;
    
         
         
         }
     
     
     
        public ArrayList<Fight> getAllFightsPpv(String ppv,String country,String date)throws Exceptions {
       
                  
           if(ppv==null){throw new Exceptions("Check PPV!");}
           if(country==null){throw new Exceptions("Check Country!");}
         ArrayList<Fight> list = FightDB.getInstance().getAllFightsPpv(ppv,country,date);
     if(list.size()==0){throw new Exceptions("No tickets found!");}
    return list;
    
    }
        
                 public ArrayList<String> getAllSeats(String ppv) {
       
     ArrayList<String> list=null;
         try {
             list = FightDB.getInstance().getAllSeats(ppv);
         } catch (SQLException ex) {
             Logger.getLogger(WrestleService.class.getName()).log(Level.SEVERE, null, ex);
         }
     
    return list;
    
    }
                  
                      public void insert(String name,String surname,String phone,String email,String ncard,String place,int index) {
                          ClientDB.getInstance().insert(name, surname, phone, email, ncard, place,index);
    
    }

                
     
}


