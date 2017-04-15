package objects;


/**
 *
 * @author Serhii Khaliavin
 */
public class Reservation {
    
    private Fight fight;

    private Passenger passenger;
    
    private Place place;
    
    private String date;
       
    private String code;

    public Fight getFight() {
        return fight;
    }

    public void setFight(Fight fight) {
        this.fight = fight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

     public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
     public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
 
}
