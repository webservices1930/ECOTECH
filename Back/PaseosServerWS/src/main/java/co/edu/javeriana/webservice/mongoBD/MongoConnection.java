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

	public static void findCollection(String nameColection) {
		MongoDatabase mongoBD = mongoClient.getDatabase("Ecotech");
		MongoCollection<Document> coleccion = mongoBD.getCollection(nameColection);

		Document myDoc = coleccion.find().first();
		System.out.println(myDoc.toJson());
	}

	public static void insertObject(String nameColection, Document nDoc) {
		MongoDatabase mongoBD = mongoClient.getDatabase("Ecotech");
		MongoCollection<Document> colection = mongoBD.getCollection(nameColection);

		colection.insertOne(nDoc);
	}

	public static Document searchByID(String nameColection, String _id) {
		MongoDatabase mongoBD = mongoClient.getDatabase("Ecotech");
		MongoCollection<Document> coleccion = mongoBD.getCollection(nameColection);

		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));

		Document doc = coleccion.find(query).first();
		return doc;
	}

	public static void deleteByID(String nameColection, String _id) {
		MongoDatabase mongoBD = mongoClient.getDatabase("Ecotech");
		MongoCollection<Document> coleccion = mongoBD.getCollection(nameColection);

		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(_id));

		coleccion.deleteOne(query);
	}

	public static void closeMongoDB() {
		mongoClient.close();
	}

}
