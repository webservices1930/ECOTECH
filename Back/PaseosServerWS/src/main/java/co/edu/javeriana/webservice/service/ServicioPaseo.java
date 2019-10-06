package co.edu.javeriana.webservice.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebService;


import com.google.gson.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import co.edu.javeriana.webservice.entities.*;
import co.edu.javeriana.webservice.mongoBD.MongoConnection;
import co.edu.javeriana.webservice.interfaceservice.InterfaceECHOTECH;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.bson.types.ObjectId;

@WebService(endpointInterface = "co.edu.javeriana.webservice.interfaceservice.InterfaceECHOTECH")
public class ServicioPaseo implements InterfaceECHOTECH {

	private Gson gson;

	public ServicioPaseo() {
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.registerTypeAdapter(ObjectId.class, new JsonSerializer<ObjectId>() {
					@Override
					public JsonElement serialize(ObjectId src, Type typeOfSrc, JsonSerializationContext context) {
						System.out.println("tesjklt");
						System.out.println(src);
						return new JsonPrimitive(src.toHexString());
					}
				})
				.registerTypeAdapter(ObjectId.class, new JsonDeserializer<ObjectId>() {
					@Override
					public ObjectId deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
						return new ObjectId(json.getAsJsonObject().get("$oid").getAsString());
					}
				}).create();
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
	public Alimentacion crearServicioAlimentacion(Alimentacion alimentacion) {
		System.out.println("ServicioPaseo.crearServicioAlimentacion()");
		gson = new GsonBuilder().create();
		String temp = gson.toJson(alimentacion);
		Document doc = Document.parse(temp);
		MongoConnection.insertObject(Servicio.collection, doc);
		return alimentacion;
	}

	@Override
	public Alojamiento crearServicioAlojamiento(Alojamiento alojamiento) {
		System.out.println("ServicioPaseo.crearServicioAlojamiento()");
		gson = new GsonBuilder().create();
		String temp = gson.toJson(alojamiento);
		Document doc = Document.parse(temp);
		MongoConnection.insertObject(Servicio.collection, doc);
		return alojamiento;
	}

	@Override
	public Paseo crearServicioPaseo(Paseo paseo) {
		System.out.println("ServicioPaseo.crearServicioPaseo()");
		gson = new GsonBuilder().create();
		String temp = gson.toJson(paseo);
		Document doc = Document.parse(temp);
		MongoConnection.insertObject(Servicio.collection, doc);
		return paseo;
	}

	@Override
	public Otro crearServicioOtro(Otro otro) {
		System.out.println("ServicioPaseo.crearServicioOtro()");
		gson = new GsonBuilder().create();
		String temp = gson.toJson(otro);
		Document doc = Document.parse(temp);
		MongoConnection.insertObject(Servicio.collection, doc);
		return otro;
	}

	@Override
	public Transporte crearServicioTransporte(Transporte transporte) {
		System.out.println("ServicioPaseo.crearServicioTransporte()");
		gson = new GsonBuilder().create();
		String temp = gson.toJson(transporte);
		Document doc = Document.parse(temp);
		MongoConnection.insertObject(Servicio.collection, doc);
		return transporte;
	}

	@Override
	public Servicio leerServicio(String id) {
		System.out.println("ServicioPaseo.leerServicio() -->" + id);
		Document doc = MongoConnection.searchByID(Servicio.collection, id);
		System.out.println(doc.toString());
		Servicio s = gson.fromJson(doc.toJson(), Servicio.class);
		s.update();
		return s;
	}
	
	@Override
	public Paseo leerPaseo(String id) {
		System.out.println("ServicioPaseo.leerPaseo() -->" + id);
		Document doc = MongoConnection.searchByID(Servicio.collection, id);
		System.out.println(doc.toString());
		Paseo s = gson.fromJson(doc.toJson(), Paseo.class);
		s.update();
		return s;
	}

	@Override
	public List<Servicio> leerTodosServicio() {
		System.out.println("ServicioPaseo.leerTodosServicio()");
		List<Servicio> servicios = new ArrayList<Servicio>();
		MongoCollection<Document> documents = MongoConnection.findCollection(Servicio.collection);
		try (MongoCursor<Document> cursor = documents.find().iterator()) {
			while (cursor.hasNext()) {
				String str = cursor.next().toJson();
				System.out.println(str);
				System.out.println();
				Servicio s = gson.fromJson(str, Servicio.class);
				s.update();
				servicios.add(s);
				System.out.println(s);
				System.out.println(s.get_id().hashCode());
				System.out.println(s.get_id().toStringMongod());
			}
		}
		return servicios;
	}

	@Override
	public Servicio actualizarServicio(String id, Servicio paseo) {
		System.out.println("ServicioPaseo.actualizarServicio()");
		MongoConnection.updateObject(Servicio.collection, id, Document.parse(gson.toJson(paseo)));
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
		p.update();
		return p;
	}

	@Override
	public List<Pregunta> leerTodosPreguntas() {
		System.out.println("ServicioPaseo.leerTodosPreguntas()");
		MongoCollection<Document> col = MongoConnection.findCollection(Pregunta.collectionName);
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		try (MongoCursor<Document> cursor = col.find().iterator()) {
			while (cursor.hasNext()) {
				Pregunta p = gson.fromJson(cursor.next().toJson(), Pregunta.class);
				p.update();
				preguntas.add(p);
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
		MongoConnection.insertObject(Comentario.collectionName, doc);

		return comentario;
	}

	@Override
	public Comentario leerComentario(String id) {
		System.out.println("ServicioPaseo.leerComentario()");
		Document doc = MongoConnection.searchByID(Comentario.collectionName, id);

		Comentario c = gson.fromJson(doc.toJson(), Comentario.class);
		c.update();
		return c;
	}

	@Override
	public List<Comentario> leerTodosComentarios() {
		System.out.println("ServicioPaseo.leerTodosComentarios()");
		MongoCollection<Document> col = MongoConnection.findCollection(Comentario.collectionName);
		List<Comentario> comentarios = new ArrayList<Comentario>();

		try (MongoCursor<Document> cursor = col.find().iterator()) {
			while (cursor.hasNext()) {
				Comentario c = gson.fromJson(cursor.next().toJson(), Comentario.class);
				c.update();
				comentarios.add(c);
			}
		}
		return comentarios;
	}

	@Override
	public Comentario actualizarComentario(String id, Comentario comentario) {
		System.out.println("ServicioPaseo.actualizarComentario()");
		String c = gson.toJson(comentario);
		Document doc = Document.parse(c);
		MongoConnection.updateObject(Comentario.collectionName, id, doc);

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
		Usuario u = gson.fromJson(document.toJson(), Usuario.class);
		u.update();
		return u;
	}

	@Override
	public List<Usuario> leerTodosUsuarios() {
		System.out.println("ServicioPaseo.leerTodosUsuarios()");
		List<Usuario> users = new ArrayList<>();
		MongoCollection<Document> documents = MongoConnection.findCollection(Usuario.nameCollection);
		try (MongoCursor<Document> cursor = documents.find().iterator()) {
			while (cursor.hasNext()) {
				Usuario u =gson.fromJson(cursor.next().toJson(), Usuario.class);
				u.update();
				users.add(u);
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
		System.out.println(document.toJson());
		Usuario u = gson.fromJson(document.toJson(), Usuario.class);
		u.update();
		return u;
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
	public Cliente obtenerClientePorNickname(String nickname) {
		System.out.println("ServicioPaseo.obtenerClientePorNickname()");
		MongoCollection<Document> coleccion = MongoConnection.findCollection(Usuario.nameCollection);

		BasicDBObject query = new BasicDBObject();
		query.put("nickname", nickname);
		Document document = coleccion.find(query).first();
		if (document == null) {
			return null;
		}
		System.out.println(document.toJson());
		Cliente u = gson.fromJson(document.toJson(), Cliente.class);
		u.update();
		return u;
	}

	@Override
	public Proveedor obtenerProveedorPorNickname(String nickname) {
		System.out.println("ServicioPaseo.obtenerProveedorPorNickname()");
		MongoCollection<Document> coleccion = MongoConnection.findCollection(Usuario.nameCollection);

		BasicDBObject query = new BasicDBObject();
		query.put("nickname", nickname);
		Document document = coleccion.find(query).first();
		if (document == null) {
			return null;
		}
		System.out.println(document.toJson());
		Proveedor u = gson.fromJson(document.toJson(), Proveedor.class);
		u.update();
		return u;
	}

	@Override
	public Cliente crearCliente(Cliente cliente) {
		System.out.println("ServicioPaseo.crearUsuario()");
		String userJson = gson.toJson(cliente);

		Usuario clienteInDB = leerUsuarioPorNickname(cliente.getNickname());
		if (clienteInDB != null) {
			return null;
		}
		Document document = Document.parse(userJson);
		MongoConnection.insertObject(Usuario.nameCollection, document);
		return cliente;
	}

	@Override
	public Proveedor crearProveedor(Proveedor proveedor) {
		System.out.println("ServicioPaseo.crearUsuario()");
		String userJson = gson.toJson(proveedor);

		Usuario proveedorInDB = leerUsuarioPorNickname(proveedor.getNickname());
		if (proveedorInDB != null) {
			return null;
		}
		Document document = Document.parse(userJson);
		MongoConnection.insertObject(Usuario.nameCollection, document);
		return proveedor;
	}

	@Override
	public boolean agregarUsuarioAServicio(String idServicio, String idUsuario) {
		try {
			System.out.println("ServicioPaseo.agregarUsuarioAServicio()");
			Document doc = MongoConnection.searchByID(Usuario.nameCollection, idUsuario);
			Cliente u = gson.fromJson(doc.toJson(), Cliente.class);
			System.out.println(u != null);
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
