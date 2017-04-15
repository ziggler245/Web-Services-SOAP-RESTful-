package objects;


/**
 *
 * @author Serhii Khaliavin
 */
public class Fight {
   
    private String date;
    private String ppv;
    private String country;
    private String duration;
    private String freePlace;
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  
    
    public String getPpv() {
        return ppv;
    }

    public void setPpv(String ppv) {
        this.ppv = ppv;
    }
    
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
      public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
   public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    public String getFreePlace() {
        return freePlace;
    }

    public void setFreePlace(String freePlace) {
        this.freePlace = freePlace;
    }
    
    
}
