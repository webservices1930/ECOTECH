
package co.edu.javeriana.webservice.interfaceservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "crearUsuario", namespace = "http://interfaceservice.webservice.javeriana.edu.co/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crearUsuario", namespace = "http://interfaceservice.webservice.javeriana.edu.co/")
public class CrearUsuario {

    @XmlElement(name = "arg0", namespace = "")
    private co.edu.javeriana.webservice.entities.Usuario arg0;

    /**
     * 
     * @return
     *     returns Usuario
     */
    public co.edu.javeriana.webservice.entities.Usuario getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(co.edu.javeriana.webservice.entities.Usuario arg0) {
        this.arg0 = arg0;
    }

}
