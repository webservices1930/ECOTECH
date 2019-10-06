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
	public Alimentacion crearServicioAlimentacion(Alimentacion alimentacion);

	@WebMethod
	public Alojamiento crearServicioAlojamiento(Alojamiento alojamiento);

	@WebMethod
	public Paseo crearServicioPaseo(Paseo paseo);

	@WebMethod
	public Otro crearServicioOtro(Otro otro);

	@WebMethod
	public Transporte crearServicioTransporte(Transporte transporte);

	@WebMethod
	public Servicio leerServicio(String id);
	
	@WebMethod
	public Paseo leerPaseo(String id);

	@WebMethod
	public Alimentacion leerAlimentacion(String id);

	@WebMethod
	public Alojamiento leerAlojamiento(String id);

	@WebMethod
	public Otro leerOtro(String id);

	@WebMethod
	public Transporte leerTransporte(String id);

	@WebMethod
	public List<Servicio> leerTodosServicio();

	@WebMethod
	public Servicio actualizarServicio(String id, Servicio paseo);

	@WebMethod
	public boolean eliminarServicio(String id);
	
	@WebMethod
	public boolean agregarUsuarioAServicio(String idServicio, String idUsuario);
}
