
package co.edu.javeriana.webservice.interfaceservice.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "leerTodosServicioResponse", namespace = "http://interfaceservice.webservice.javeriana.edu.co/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "leerTodosServicioResponse", namespace = "http://interfaceservice.webservice.javeriana.edu.co/")
public class LeerTodosServicioResponse {

    @XmlElement(name = "return", namespace = "")
    private List<co.edu.javeriana.webservice.entities.Servicio> _return;

    /**
     * 
     * @return
     *     returns List<Servicio>
     */
    public List<co.edu.javeriana.webservice.entities.Servicio> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<co.edu.javeriana.webservice.entities.Servicio> _return) {
        this._return = _return;
    }

}
