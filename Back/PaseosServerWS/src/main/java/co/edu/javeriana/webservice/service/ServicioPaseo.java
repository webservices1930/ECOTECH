package co.edu.javeriana.webservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.print.Doc;

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
import co.edu.javeriana.webservice.interfaceservice.*;
import co.edu.javeriana.webservice.mongoBD.MongoConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.types.ObjectId;

@WebService(endpointInterface = "co.edu.javeriana.webservice.interfaceservice.InterfaceECHOTECH")
public class ServicioPaseo implements InterfaceECHOTECH {

	private Gson gson;

	public ServicioPaseo()
	{
		gson = new GsonBuilder().create();
	}

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
	public Usuario crearUsuario(Usuario user) {
		String userJson = gson.toJson(user);

		Usuario userInDB = leerUsuarioPorNickname(user.getNickname());
		if( userInDB != null )
		{
			return null;
		}
		Document document = Document.parse(userJson);
		MongoConnection.insertObject(Usuario.nameCollection, document);
		return user;
	}

	@Override
	public Usuario leerUsuario(String id) {
		Document document = MongoConnection.searchByID(Usuario.nameCollection, id);
		return gson.fromJson(document.toJson(), Usuario.class);
	}

	@Override
	public List<Usuario> leerTodosUsuarios() {
		List<Usuario> users = new ArrayList<>();
		MongoCollection<Document> documents = MongoConnection.findCollection(Usuario.nameCollection);
		try (MongoCursor<Document> cursor = documents.find().iterator()) {
			while (cursor.hasNext()) {
				users.add(gson.fromJson(cursor.next().toJson(), Usuario.class));
			}
		}
		return users;
	}

	@Override
	public Usuario actualizarUsuario(String id, Usuario usuario) {
		String userJson = gson.toJson(usuario);
		Document document = Document.parse(userJson);
		MongoConnection.updateObject(Usuario.nameCollection, id, document);
		return usuario;
	}

	@Override
	public boolean eliminarUsuario(String id) {
		MongoConnection.deleteByID(Usuario.nameCollection, id);
		return true;
	}

	@Override
	public Usuario leerUsuarioPorNickname(String nickname) {
		MongoCollection<Document> coleccion = MongoConnection.findCollection(Usuario.nameCollection);

		BasicDBObject query = new BasicDBObject();
		query.put("nickname", nickname);
		Document document = coleccion.find(query).first();
		if( document == null )
		{
			return null;
		}
		return gson.fromJson(document.toJson(), Usuario.class);
	}

	@Override
	public boolean login(String nickname, String password) {
		MongoCollection<Document> coleccion = MongoConnection.findCollection(Usuario.nameCollection);

		BasicDBObject query = new BasicDBObject();
		query.put("nickname", nickname);
		query.put("password", password);
		Document document = coleccion.find(query).first();
		return document != null;
	}

}
