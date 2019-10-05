package co.edu.javeriana.webservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.sun.xml.ws.developer.SchemaValidation;

import co.edu.javeriana.webservice.entities.*;
import co.edu.javeriana.webservice.interfaceservice.InterfaceComentario;
import co.edu.javeriana.webservice.interfaceservice.InterfacePregunta;
import co.edu.javeriana.webservice.interfaceservice.InterfaceService;
import co.edu.javeriana.webservice.interfaceservice.InterfaceUser;
import co.edu.javeriana.webservice.mongoBD.MongoConnection;

@WebService(endpointInterface = "co.edu.javeriana.webservice.interfaceservice.InterfaceService")
public class ServicioPaseo implements InterfaceService, InterfaceUser, InterfaceComentario, InterfacePregunta {

	private Gson gson;
	@Override
	public Servicio crearServicio(Servicio paseo) {
		gson = new GsonBuilder().create();
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
		String com = gson.toJson(comentario);
		
		Document doc = Document.parse(com);
		
		MongoConnection.insertObject(comentario.collectionName, doc);
		return comentario;
	}

	@Override
	public Pregunta leerPregunta(String id) {
		Document doc = MongoConnection.searchByID(Pregunta.collectionName, id);
		
		Pregunta p = gson.fromJson(doc.toJson(), Pregunta.class);
		
		return p;
	}

	@Override
	public List<Pregunta> leerTodosPreguntas() {
		MongoCollection<Document> col = MongoConnection.findCollection(Pregunta.collectionName);
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		
		try(MongoCursor<Document> cursor = col.find().iterator()) {
			while (cursor.hasNext()) {
				preguntas.add(gson.fromJson(cursor.next().toJson(), Pregunta.class));
			}
		}
		
		return preguntas;
	}

	@Override
	public Pregunta actualizarPregunta(String id, Pregunta pregunta) {
		String p = gson.toJson(pregunta);
		Document doc = Document.parse(p);
		MongoConnection.updateObject(pregunta.collectionName, id, doc);
		return pregunta;
	}

	@Override
	public boolean eliminarPregunta(String id) {
		try {
			MongoConnection.deleteByID(Pregunta.collectionName, id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Comentario crearComentario(Comentario comentario) {
		String com = gson.toJson(comentario);
		Document doc = Document.parse(com);
		MongoConnection.insertObject(comentario.collectionName, doc);
		
		return comentario;
	}

	@Override
	public Comentario leerComentario(String id) {
		Document doc = MongoConnection.searchByID(Comentario.collectionName, id);
		
		Comentario c = gson.fromJson(doc.toJson(), Comentario.class);
		
		return c;
	}

	@Override
	public List<Comentario> leerTodosComentarios() {
		MongoCollection<Document> col = MongoConnection.findCollection(Comentario.collectionName);
		List<Comentario> comentarios = new ArrayList<Comentario>();
		
		try(MongoCursor<Document> cursor = col.find().iterator()) {
			while (cursor.hasNext()) {
				comentarios.add(gson.fromJson(cursor.next().toJson(), Comentario.class));
			}
		}
		return comentarios;
	}

	@Override
	public Comentario actualizarComentario(String id, Comentario comentario) {
		String c = gson.toJson(comentario);
		Document doc = Document.parse(c);
		MongoConnection.updateObject(comentario.collectionName, id, doc);
		
		return comentario;
	}

	@Override
	public boolean eliminarComentario(String id) {
		try {
			MongoConnection.deleteByID(Comentario.collectionName, id.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
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
