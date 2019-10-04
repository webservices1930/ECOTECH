package co.edu.javeriana.webservice.interfaceservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import co.edu.javeriana.webservice.entities.Usuario;

@WebService
public interface InterfaceUser {

	@WebMethod
	public Usuario crearUsuario(Usuario paseo);

	@WebMethod
	public Usuario leerUsuario(Long id);

	@WebMethod
	public List<Usuario> leerTodosUsuarios(Long id);

	@WebMethod
	public Usuario actualizarUsuario(Long id, Usuario usuario);

	@WebMethod
	public boolean eliminarUsuario(Long id);
}
