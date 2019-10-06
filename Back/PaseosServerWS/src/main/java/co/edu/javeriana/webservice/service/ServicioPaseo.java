package co.edu.javeriana.webservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;




import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import co.edu.javeriana.webservice.entities.*;
import co.edu.javeriana.webservice.mongoBD.MongoConnection;
import co.edu.javeriana.webservice.interfaceservice.InterfaceECHOTECH;
import com.mongodb.BasicDBObject;
import org.bson.Document;

@WebService(endpointInterface = "co.edu.javeriana.webservice.interfaceservice.InterfaceECHOTECH")
public class ServicioPaseo implements InterfaceECHOTECH {

	private Gson gson;

	public ServicioPaseo() {
		gson = new GsonBuilder().create();
	}

	@Override
	public Servicio crearServicio(Servicio paseo) {
		System.out.println("ServicioPaseo.crearServicio()");
		gson = new GsonBuilder().create();
		// TODO Auto-generated method stub
		String temp = gson.toJson(paseo);
		Document doc = Document.parse(temp);
		MongoConnection.insertObject(Servicio.collection, doc);
		return paseo;
	}

	@Override
	public Servicio leerServicio(String id) {
		System.out.println("ServicioPaseo.leerServicio()");
		Document doc = MongoConnection.searchByID(Servicio.collection, id);
		Servicio s = gson.fromJson(doc.toJson(), Servicio.class);
		return s;
	}

	@Override
	public List<Servicio> leerTodosServicio(String id) {
		System.out.println("ServicioPaseo.leerTodosServicio()");
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
		System.out.println("ServicioPaseo.actualizarServicio()");
		MongoConnection.updateObject(Servicio.collection, paseo.get_id(), Document.parse(gson.toJson(paseo)));
		return paseo;
	}

	@Override
	public boolean eliminarServicio(String id) {
		try {
			System.out.println("ServicioPaseo.eliminarServicio()");
			MongoConnection.deleteByID(Servicio.collection, id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Pregunta crearPregunta(Pregunta comentario) {
		System.out.println("ServicioPaseo.crearPregunta()");
		String com = gson.toJson(comentario);
		Document doc = Document.parse(com);
		MongoConnection.insertObject(Pregunta.collectionName, doc);
		return comentario;
	}

	@Override
	public Pregunta leerPregunta(String id) {
		System.out.println("ServicioPaseo.leerPregunta()");
		Document doc = MongoConnection.searchByID(Pregunta.collectionName, id);
		Pregunta p = gson.fromJson(doc.toJson(), Pregunta.class);
		return p;
	}

	@Override
	public List<Pregunta> leerTodosPreguntas() {
		System.out.println("ServicioPaseo.leerTodosPreguntas()");
		MongoCollection<Document> col = MongoConnection.findCollection(Pregunta.collectionName);
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		try (MongoCursor<Document> cursor = col.find().iterator()) {
			while (cursor.hasNext()) {
				preguntas.add(gson.fromJson(cursor.next().toJson(), Pregunta.class));
			}
		}

		return preguntas;
	}

	@Override
	public Pregunta actualizarPregunta(String id, Pregunta pregunta) {
		System.out.println();
		String p = gson.toJson(pregunta);
		Document doc = Document.parse(p);
		MongoConnection.updateObject(Pregunta.collectionName, id, doc);
		return pregunta;
	}

	@Override
	public boolean eliminarPregunta(String id) {
		try {
			System.out.println("ServicioPaseo.eliminarPregunta()");
			MongoConnection.deleteByID(Pregunta.collectionName, id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Comentario crearComentario(Comentario comentario) {
		System.out.println("ServicioPaseo.crearComentario()");
		String com = gson.toJson(comentario);
		Document doc = Document.parse(com);
		MongoConnection.insertObject(comentario.collectionName, doc);

		return comentario;
	}

	@Override
	public Comentario leerComentario(String id) {
		System.out.println("ServicioPaseo.leerComentario()");
		Document doc = MongoConnection.searchByID(Comentario.collectionName, id);

		Comentario c = gson.fromJson(doc.toJson(), Comentario.class);

		return c;
	}

	@Override
	public List<Comentario> leerTodosComentarios() {
		System.out.println("ServicioPaseo.leerTodosComentarios()");
		MongoCollection<Document> col = MongoConnection.findCollection(Comentario.collectionName);
		List<Comentario> comentarios = new ArrayList<Comentario>();

		try (MongoCursor<Document> cursor = col.find().iterator()) {
			while (cursor.hasNext()) {
				comentarios.add(gson.fromJson(cursor.next().toJson(), Comentario.class));
			}
		}
		return comentarios;
	}

	@Override
	public Comentario actualizarComentario(String id, Comentario comentario) {
		System.out.println("ServicioPaseo.actualizarComentario()");
		String c = gson.toJson(comentario);
		Document doc = Document.parse(c);
		MongoConnection.updateObject(comentario.collectionName, id, doc);

		return comentario;
	}

	@Override
	public boolean eliminarComentario(String id) {
		try {
			System.out.println("ServicioPaseo.eliminarComentario()");
			MongoConnection.deleteByID(Comentario.collectionName, id.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Usuario crearUsuario(Usuario user) {
		System.out.println("ServicioPaseo.crearUsuario()");
		String userJson = gson.toJson(user);

		Usuario userInDB = leerUsuarioPorNickname(user.getNickname());
		if (userInDB != null) {
			return null;
		}
		Document document = Document.parse(userJson);
		MongoConnection.insertObject(Usuario.nameCollection, document);
		return user;
	}

	@Override
	public Usuario leerUsuario(String id) {
		System.out.println("ServicioPaseo.leerUsuario()");
		Document document = MongoConnection.searchByID(Usuario.nameCollection, id);
		return gson.fromJson(document.toJson(), Usuario.class);
	}

	@Override
	public List<Usuario> leerTodosUsuarios() {
		System.out.println("ServicioPaseo.leerTodosUsuarios()");
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
		System.out.println("ServicioPaseo.actualizarUsuario()");
		String userJson = gson.toJson(usuario);
		Document document = Document.parse(userJson);
		MongoConnection.updateObject(Usuario.nameCollection, id, document);
		return usuario;
	}

	@Override
	public boolean eliminarUsuario(String id) {
		System.out.println("ServicioPaseo.eliminarUsuario()");
		MongoConnection.deleteByID(Usuario.nameCollection, id);
		return true;
	}

	@Override
	public Usuario leerUsuarioPorNickname(String nickname) {
		System.out.println("ServicioPaseo.leerUsuarioPorNickname()");
		MongoCollection<Document> coleccion = MongoConnection.findCollection(Usuario.nameCollection);

		BasicDBObject query = new BasicDBObject();
		query.put("nickname", nickname);
		Document document = coleccion.find(query).first();
		if (document == null) {
			return null;
		}
		return gson.fromJson(document.toJson(), Usuario.class);
	}

	@Override
	public boolean login(String nickname, String password) {
		System.out.println("ServicioPaseo.login()");
		MongoCollection<Document> coleccion = MongoConnection.findCollection(Usuario.nameCollection);

		BasicDBObject query = new BasicDBObject();
		query.put("nickname", nickname);
		query.put("password", password);
		Document document = coleccion.find(query).first();
		return document != null;
	}

	@Override
	public boolean agregarUsuarioAServicio(String idServicio, String idUsuario) {
		try {
			System.out.println("ServicioPaseo.agregarUsuarioAServicio()");
			Document doc = MongoConnection.searchByID(Usuario.nameCollection, idUsuario);
			Cliente u = gson.fromJson(doc.toJson(), Cliente.class);
			System.out.println(u instanceof Cliente);
			List<String> serviciosCliente = u.getServicios();
			serviciosCliente.add(idServicio);
			u.setServicios(serviciosCliente);
			String s = gson.toJson(u);
			Document docupdate = Document.parse(s);
			MongoConnection.updateObject(Usuario.nameCollection, idUsuario, docupdate);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
