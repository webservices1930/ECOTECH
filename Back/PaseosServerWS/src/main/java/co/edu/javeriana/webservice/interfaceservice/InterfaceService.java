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
	public Servicio leerServicio(String id);
	
	@WebMethod
	public Paseo leerPaseo(String id);

	@WebMethod
	public List<Servicio> leerTodosServicio();

	@WebMethod
	public Servicio actualizarServicio(String id, Servicio paseo);

	@WebMethod
	public boolean eliminarServicio(String id);
	
	@WebMethod
	public boolean agregarUsuarioAServicio(String idServicio, String idUsuario);
}
