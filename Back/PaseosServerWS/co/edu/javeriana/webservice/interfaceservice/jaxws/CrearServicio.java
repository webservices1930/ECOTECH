
package co.edu.javeriana.webservice.interfaceservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "crearServicio", namespace = "http://interfaceservice.webservice.javeriana.edu.co/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crearServicio", namespace = "http://interfaceservice.webservice.javeriana.edu.co/")
public class CrearServicio {

    @XmlElement(name = "arg0", namespace = "")
    private co.edu.javeriana.webservice.entities.Servicio arg0;

    /**
     * 
     * @return
     *     returns Servicio
     */
    public co.edu.javeriana.webservice.entities.Servicio getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(co.edu.javeriana.webservice.entities.Servicio arg0) {
        this.arg0 = arg0;
    }

}
