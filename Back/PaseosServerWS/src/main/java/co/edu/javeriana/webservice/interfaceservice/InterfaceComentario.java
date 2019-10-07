package co.edu.javeriana.webservice.interfaceservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import co.edu.javeriana.webservice.entities.Comentario;

@WebService
public interface InterfaceComentario {

	@WebMethod
	public Comentario crearComentario(Comentario comentario);

	@WebMethod
	public Comentario leerComentario(String id);

	@WebMethod
	public List<Comentario> leerTodosComentarios();

	@WebMethod
	public Comentario actualizarComentario(String id, Comentario comentario);

	@WebMethod
	public boolean eliminarComentario(String id);
}
