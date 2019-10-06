
package co.edu.javeriana.webservice.interfaceservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "crearServicioResponse", namespace = "http://interfaceservice.webservice.javeriana.edu.co/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crearServicioResponse", namespace = "http://interfaceservice.webservice.javeriana.edu.co/")
public class CrearServicioResponse {

    @XmlElement(name = "return", namespace = "")
    private co.edu.javeriana.webservice.entities.Servicio _return;

    /**
     * 
     * @return
     *     returns Servicio
     */
    public co.edu.javeriana.webservice.entities.Servicio getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(co.edu.javeriana.webservice.entities.Servicio _return) {
        this._return = _return;
    }

}
