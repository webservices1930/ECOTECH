
package co.edu.javeriana.webservice.interfaceservice.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "leerTodosComentariosResponse", namespace = "http://interfaceservice.webservice.javeriana.edu.co/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "leerTodosComentariosResponse", namespace = "http://interfaceservice.webservice.javeriana.edu.co/")
public class LeerTodosComentariosResponse {

    @XmlElement(name = "return", namespace = "")
    private List<co.edu.javeriana.webservice.entities.Comentario> _return;

    /**
     * 
     * @return
     *     returns List<Comentario>
     */
    public List<co.edu.javeriana.webservice.entities.Comentario> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<co.edu.javeriana.webservice.entities.Comentario> _return) {
        this._return = _return;
    }

}
