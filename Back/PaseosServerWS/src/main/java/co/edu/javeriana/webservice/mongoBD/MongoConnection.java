package co.edu.javeriana.webservice.mongoBD;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
	private static MongoClient mongoClient;
	private static String db = "Ecotech";

	public MongoConnection() {
		MongoClientURI uri = new MongoClientURI(
		"mongodb+srv://admin:admin123@cluster0-qhoob.mongodb.net/admin?retryWrites=true&w=majority");
		mongoClient = new MongoClient(uri);
		//mongoClient = new MongoClient("localhost", 27017);
	}

	public static MongoCollection<Document> findCollection(String nameColection) {
		MongoDatabase mongoBD = mongoClient.getDatabase(db);
		return mongoBD.getCollection(nameColection);
	}

	public static void insertObject(String nameColection, Document nDoc) {
		MongoDatabase mongoBD = mongoClient.getDatabase(db);
		MongoCollection<Document> colection = mongoBD.getCollection(nameColection);

		colection.insertOne(nDoc);
	}

	public static void updateObject(String nameCollection, String _id,  Document nDoc) {
		MongoDatabase mongoBD = mongoClient.getDatabase("Ecotech");
		MongoCollection<Document> collection = mongoBD.getCollection(nameCollection);
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));

		collection.replaceOne(query, nDoc);
	}

	public static Document searchByID(String nameColection, String _id) {
		MongoDatabase mongoBD = mongoClient.getDatabase(db);
		MongoCollection<Document> coleccion = mongoBD.getCollection(nameColection);

		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));

		Document doc = coleccion.find(query).first();
		return doc;
	}


	public static void deleteByID(String nameColection, String _id) {
		MongoDatabase mongoBD = mongoClient.getDatabase(db);
		MongoCollection<Document> coleccion = mongoBD.getCollection(nameColection);

		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));

		coleccion.deleteOne(query);
	}

	public static void closeMongoDB() {
		mongoClient.close();
	}
}
