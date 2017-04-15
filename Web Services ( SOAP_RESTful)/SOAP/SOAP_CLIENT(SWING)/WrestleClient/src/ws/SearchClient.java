package ws;

import java.util.ArrayList;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.ws.AsyncHandler;


/**
 *
 * @author Serhii Khaliavin
 */
public class SearchClient {
    private WService fightService;
    private WrestleService searchImpl;
    
    
    public SearchClient(){
    
    fightService=new WService();
    searchImpl=fightService.getWrestleServicePort();
        
    }
    
       public void insert(String name,String surname,String phone,String email,String ncard,String place,int index) {
    searchImpl.insert(name, surname, ncard, email, phone, place,index);
    
    }
    
     public ArrayList<String> getAllPpvs() {
        ArrayList<String> cityList = new ArrayList<>();
        cityList.addAll(searchImpl.getAllPpv());
        return cityList;
    }
     
      public ArrayList<Fight> check(String ncard,String email) {
        ArrayList<Fight> checkList = new ArrayList();
        
         try {
               checkList.addAll(searchImpl.check(ncard, email));
        } catch (Exceptions_Exception ex ) {
            Logger.getLogger(SearchClient.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
 
        }
       
        
        
        return checkList;
    }
     
     
     public ArrayList<String> getAllSeats(String ppv) {
        ArrayList<String> cityList = new ArrayList<>();
        cityList.addAll(searchImpl.getAllSeats(ppv));
        return cityList;
    }
     
     
         public ArrayList<String> getAllCountries() {
        ArrayList<String> countryList = new ArrayList<>();
        countryList.addAll(searchImpl.getAllCountries());
          return countryList;
    }
    
         
            public ArrayList<Fight> getAllFight() {
        ArrayList<Fight> countryList = new ArrayList<>();
        countryList.addAll(searchImpl.getAllFights());
         return countryList;
    }
            
            
                        public ArrayList<Fight> getAllFightPpv(String ppv,String country,String date)   {
        ArrayList<Fight> countryList = new ArrayList<>();
        
        try {
            countryList.addAll(searchImpl.getAllFightsPpv(ppv,country,date));
        } catch (Exceptions_Exception ex) {
            Logger.getLogger(SearchClient.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null,ex.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return countryList;
    }
                        
    public Future<?>getAllFightPpvAsyncCallback(String ppv,String country,String date,AsyncHandler<GetAllFightsPpvResponse> handler) {

    return    searchImpl.getAllFightsPpvAsync(ppv, country, date, handler);
        
        
    }
                            
}
