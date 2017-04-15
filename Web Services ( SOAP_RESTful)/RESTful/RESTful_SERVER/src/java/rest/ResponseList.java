package rest;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Serhii Khaliavin
 */

@XmlRootElement(name = "List")
@XmlAccessorType(XmlAccessType.NONE)
public class ResponseList {
    
    
        public ResponseList() {
    }
    
    @XmlElement(name = "Country")
    private List<String> list;

    
    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
    
}
