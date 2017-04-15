package rest;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import objects.Fight;

/**
 *
 * @author Serhii Khaliavin
 */

@XmlRootElement(name = "FightList")
@XmlAccessorType(XmlAccessType.NONE)
public class FightList {
    
    
        public FightList() {
    }
    
    @XmlElement(name = "Fight")
    private List<Fight> list;

    
    public List<Fight> getList() {
        return list;
    }

    public void setList(List<Fight> list) {
        this.list = list;
    }
    
}
