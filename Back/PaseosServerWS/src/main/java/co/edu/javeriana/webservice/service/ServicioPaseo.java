package co.edu.javeriana.webservice.service;

import java.util.List;

import javax.jws.WebService;

import co.edu.javeriana.webservice.entities.*;
import co.edu.javeriana.webservice.interfaceservice.InterfaceComentario;
import co.edu.javeriana.webservice.interfaceservice.InterfacePregunta;
import co.edu.javeriana.webservice.interfaceservice.InterfaceService;
import co.edu.javeriana.webservice.interfaceservice.InterfaceUser;

@WebService(endpointInterface = "co.edu.javeriana.webservice.interfaceservice.InterfaceService")
public class ServicioPaseo implements InterfaceService, InterfaceUser, InterfaceComentario, InterfacePregunta {

	@Override
	public Servicio crearServicio(Servicio paseo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Servicio leerServicio(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Servicio> leerTodosServicio(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Servicio actualizarPaseo(Long id, Servicio paseo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarPaseo(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pregunta crearPregunta(Pregunta comentario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pregunta leerPregunta(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pregunta> leerTodosPreguntas(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pregunta actualizarPregunta(Long id, Pregunta pregunta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarPregunta(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comentario crearComentario(Comentario comentario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comentario leerComentario(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comentario> leerTodosComentarios(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comentario actualizarComentario(Long id, Comentario comentario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarComentario(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario crearUsuario(Usuario paseo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario leerUsuario(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> leerTodosUsuarios(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario actualizarUsuario(Long id, Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarUsuario(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
