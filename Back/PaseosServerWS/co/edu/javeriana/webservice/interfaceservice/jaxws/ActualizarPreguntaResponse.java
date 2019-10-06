
package co.edu.javeriana.webservice.interfaceservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "actualizarPreguntaResponse", namespace = "http://interfaceservice.webservice.javeriana.edu.co/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarPreguntaResponse", namespace = "http://interfaceservice.webservice.javeriana.edu.co/")
public class ActualizarPreguntaResponse {

    @XmlElement(name = "return", namespace = "")
    private co.edu.javeriana.webservice.entities.Pregunta _return;

    /**
     * 
     * @return
     *     returns Pregunta
     */
    public co.edu.javeriana.webservice.entities.Pregunta getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(co.edu.javeriana.webservice.entities.Pregunta _return) {
        this._return = _return;
    }

}
