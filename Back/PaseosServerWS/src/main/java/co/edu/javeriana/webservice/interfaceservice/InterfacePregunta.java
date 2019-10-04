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
	public Pregunta leerPregunta(Long id);

	@WebMethod
	public List<Pregunta> leerTodosPreguntas(Long id);

	@WebMethod
	public Pregunta actualizarPregunta(Long id, Pregunta pregunta);

	@WebMethod
	public boolean eliminarPregunta(Long id);

}