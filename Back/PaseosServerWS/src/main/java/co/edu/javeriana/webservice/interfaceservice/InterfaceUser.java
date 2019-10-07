package co.edu.javeriana.webservice.interfaceservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import co.edu.javeriana.webservice.entities.Cliente;
import co.edu.javeriana.webservice.entities.Proveedor;
import co.edu.javeriana.webservice.entities.Usuario;

@WebService
public interface InterfaceUser {

	@WebMethod
	public Usuario crearUsuario(Usuario user);

	@WebMethod
	public Usuario leerUsuario(String id);

	@WebMethod
	public List<Usuario> leerTodosUsuarios();

	@WebMethod
	public Usuario actualizarUsuario(String id, Usuario usuario);

	@WebMethod
	public boolean eliminarUsuario(String id);

	@WebMethod
	public Usuario leerUsuarioPorNickname(String nickname);

	@WebMethod
	public boolean login(String nickname, String password);

	@WebMethod
	public Cliente obtenerClientePorNickname(String nickname);

	@WebMethod
	public Proveedor obtenerProveedorPorNickname(String nickname);

	@WebMethod
	public Cliente crearCliente(Cliente cliente);

	@WebMethod
	public Proveedor crearProveedor(Proveedor proveedor);
}
