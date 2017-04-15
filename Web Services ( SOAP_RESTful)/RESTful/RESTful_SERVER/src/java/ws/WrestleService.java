package ws;

import database.ClientDB;
import database.CountriesDB;
import database.FightDB;
import database.Ppvs;
import exceptions.Exceptions;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import objects.Fight;
import rest.FightList;
import rest.ResponseList;

/**
 *
 * @author Serhii Khaliavin
 */
@Path("/wrestle")
public class WrestleService {
    
     private Ppvs ppv =  Ppvs.getInstance();
     private CountriesDB country =  CountriesDB.getInstance();
     private FightDB fight =  FightDB.getInstance();
     private ClientDB client =  ClientDB.getInstance();
    
      public WrestleService(){
    }
  
      
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("allPpv")
      public  ResponseList getAllPpv() {
       
           List<String> ppvList = ppv.getAllCountries();
        
        ResponseList responseList = new ResponseList();
        
        responseList.setList(ppvList);
        
        return responseList;
  
      }
        
     @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("allCities")
     public ResponseList getAllCountries() {
       
    List<String> countries = country.getAllCountries();
    
       ResponseList responseList = new ResponseList();
       responseList.setList(countries);
    return responseList;
    
    }
     
      @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("allFight")
     public FightList getAllFights() {
       ArrayList<String> country=new ArrayList();
       country.addAll( getAllPpv().getList());
     List<Fight> list = fight.getAllFights(country);
        FightList fightList = new FightList();
       fightList.setList(list);
    return fightList;
    
    }
    
     
     
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getClient")
         public FightList check(@QueryParam("ncard")  String ncard,@QueryParam("email") String email)  {
       
   
    List<Fight> list=client.checkClient(ncard, email);
      FightList fightList = new FightList();
       fightList.setList(list);
         
          if(fightList.getList().size()==0)
     try {
         throw new Exceptions("No information!");
    } catch (Exceptions ex) {
        Logger.getLogger(WrestleService.class.getName()).log(Level.SEVERE, null, ex);
    }
      

    return fightList;
         }
     
    
     @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getPpvFight")
        public FightList getAllFightsPpv(@QueryParam("ppv")String ppv,@QueryParam("country")String country,@QueryParam("date")String date) {
       FightList fightList = new FightList();
            
                  try {
           if(ppv==null){
               throw new Exceptions("Check PPV!");
                
}
           if(country==null){throw new Exceptions("Check Country!");}
         List<Fight> list = fight.getAllFightsPpv(ppv,country,date);
          
          fightList.setList(list);
     if(list.size()==0){throw new Exceptions("No tickets found!");}
     
     }catch (Exceptions ex) {
                   Logger.getLogger(WrestleService.class.getName()).log(Level.SEVERE, null, ex);
               }
     
    return fightList;
    
    }
        
                
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getAllSeat") 
        public ResponseList getAllSeats(@QueryParam("ppv")String ppv) {
       ResponseList responseList = new ResponseList();
    if(ppv!=null){
     
     
         try {
             List<String> list  = fight.getAllSeats(ppv);
              responseList.setList(list);
         } catch (SQLException ex) {
             Logger.getLogger(WrestleService.class.getName()).log(Level.SEVERE, null, ex);
         }
    
     
    }
    return responseList;
    
    }
     
        
        
        
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/inser")             
public ResponseList insert_p(@QueryParam("name")String name,@QueryParam("surname")String surname,@QueryParam("phone")String phone,@QueryParam("email")String email,@QueryParam("ncard")String ncard,@QueryParam("place")String place,@QueryParam("index")int index) {
 if((name!=null)&&(surname!=null)&&(phone!=null)&&(email!=null)&&(ncard!=null)&&(phone!=null))
    
    client.insert(name, surname, phone, email, ncard, place,index);

 ResponseList rp = new ResponseList();
return rp;    }
    

}


