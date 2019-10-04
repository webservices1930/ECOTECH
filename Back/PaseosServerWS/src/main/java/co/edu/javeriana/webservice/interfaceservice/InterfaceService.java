package co.edu.javeriana.webservice.interfaceservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import co.edu.javeriana.webservice.entities.*;

@WebService
public interface InterfaceService {

	@WebMethod
	public Servicio crearServicio(Servicio paseo);

	@WebMethod
	public Servicio leerServicio(Long id);

	@WebMethod
	public List<Servicio> leerTodosServicio(Long id);

	@WebMethod
	public Servicio actualizarPaseo(Long id, Servicio paseo);

	@WebMethod
	public boolean eliminarPaseo(Long id);
}
