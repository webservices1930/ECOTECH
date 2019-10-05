package co.edu.javeriana.webservice.mongoBD;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
	private static MongoClient mongoClient;
	

	public MongoConnection() {
//		MongoClientURI uri = new MongoClientURI(
//				"mongodb+srv://admin:admin123@cluster0-qhoob.mongodb.net/admin?retryWrites=true&w=majority");
//		mongoClient = new MongoClient(uri);
		mongoClient = new MongoClient("localhost", 27017);
		
	}

	public static void buscarCollection(String nombreColeccion) {
		MongoDatabase baseDeDatos = mongoClient.getDatabase("Ecotech");
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

		Document myDoc = coleccion.find().first();
		System.out.println(myDoc.toJson());
	}

	public static void insertarObjeto(String nombreColeccion, Document nDoc) {
		MongoDatabase baseDeDatos = mongoClient.getDatabase("Ecotech");
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

		coleccion.insertOne(nDoc);
	}

	public static Document buscarEnColeccionPorID(String nombreColeccion, String _id) {
		MongoDatabase baseDeDatos = mongoClient.getDatabase("Ecotech");
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

		// Se crea el query con un objeto ID del tipo que utiliza MongoDB
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));

		Document doc = coleccion.find(query).first();
		return doc;
	}

	public static void eliminarEnColeccionPorID(String nombreColeccion, String _id) {
		MongoDatabase baseDeDatos = mongoClient.getDatabase("Ecotech");
		MongoCollection<Document> coleccion = baseDeDatos.getCollection(nombreColeccion);

		// Se crea el query con un objeto ID del tipo que utiliza MongoDB
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));

		coleccion.deleteOne(query);
	}

	public static void cerrarConexionMongoDB() {
		mongoClient.close();
	}

}
