package co.edu.javeriana.webservice.interfaceservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import co.edu.javeriana.webservice.entities.Pregunta;

@WebService
public interface InterfacePregunta {

	@WebMethod
	public Pregunta crearPregunta(Pregunta comentario);

	@WebMethod
	public Pregunta leerPregunta(String id);

	@WebMethod
	public List<Pregunta> leerTodosPreguntas();

	@WebMethod
	public Pregunta actualizarPregunta(String id, Pregunta pregunta);

	@WebMethod
	public boolean eliminarPregunta(String id);
	
	@WebMethod
	public Pregunta agregarPregunta(String descripcion, String idServicio, String idCliente);

}