package exceptions;

import javax.xml.ws.WebFault;

/**
 *
 * @author Serhii Khaliavin
 */
@WebFault
public class Exceptions extends Exception{
    
    
    public Exceptions(String string){
    
    super(string);
    
    }    
}
