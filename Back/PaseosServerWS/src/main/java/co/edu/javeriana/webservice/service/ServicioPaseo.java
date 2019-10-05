package co.edu.javeriana.webservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import co.edu.javeriana.webservice.entities.*;
import co.edu.javeriana.webservice.interfaceservice.InterfaceComentario;
import co.edu.javeriana.webservice.interfaceservice.InterfacePregunta;
import co.edu.javeriana.webservice.interfaceservice.InterfaceService;
import co.edu.javeriana.webservice.interfaceservice.InterfaceUser;
import co.edu.javeriana.webservice.mongoBD.MongoConnection;

@WebService(endpointInterface = "co.edu.javeriana.webservice.interfaceservice.InterfaceService")
public class ServicioPaseo implements InterfaceService, InterfaceUser, InterfaceComentario, InterfacePregunta {

	private Gson gson;

	public ServicioPaseo() {
		gson = new GsonBuilder().create();
	}

	@Override
	public Servicio crearServicio(Servicio paseo) {
		// TODO Auto-generated method stub
		String temp = gson.toJson(paseo);
		Document doc = Document.parse(temp);
		MongoConnection.insertObject(Servicio.collection, doc);
		return paseo;
	}

	@Override
	public Servicio leerServicio(String id) {
		Document doc = MongoConnection.searchByID(Servicio.collection, id);
		Servicio s = gson.fromJson(doc.toJson(), Servicio.class);
		return s;
	}

	@Override
	public List<Servicio> leerTodosServicio(String id) {
		List<Servicio> servicios = new ArrayList<Servicio>();
		MongoCollection<Document> documents = MongoConnection.findCollection(Servicio.collection);
		try (MongoCursor<Document> cursor = documents.find().iterator()) {
			while (cursor.hasNext()) {
				servicios.add(gson.fromJson(cursor.next().toJson(), Servicio.class));
			}
		}
		return servicios;
	}

	@Override
	public Servicio actualizarServicio(String id, Servicio paseo) {
		MongoConnection.updateObject(Servicio.collection, paseo.get_id(), Document.parse(gson.toJson(paseo)));
		return paseo;
	}

	@Override
	public boolean eliminarServicio(String id) {
		try {
			System.out.println("123456");
			MongoConnection.deleteByID(Servicio.collection, id);
			System.out.println("temp");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
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
