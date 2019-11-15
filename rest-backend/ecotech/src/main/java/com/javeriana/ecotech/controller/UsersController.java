package com.javeriana.ecotech.controller;

import com.javeriana.ecotech.entities.Usuario;
import com.javeriana.ecotech.exeptions.EntityValidationException;
import com.javeriana.ecotech.integration.MongoConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("users")
public class UsersController {

    @Autowired
    private GsonController gsonController;



    @PostMapping( value="login", produces = "application/json")
    public Usuario login(@RequestBody Usuario usuario) {
        MongoCollection<Document> collection = MongoConnection.findCollection(Usuario.nameCollection);
        BasicDBObject query = new BasicDBObject();
        query.put("nickname", usuario.getNickname());
        query.put("password", usuario.getPassword());
        Document document = collection.find(query).first();
        return gsonController.getGson().fromJson(document.toJson(), Usuario.class);
    }


    @GetMapping( value="{nickname}", produces = "application/json")
    public Object getUserByNickname(@PathVariable String nickname) {
        MongoCollection<Document> collection = MongoConnection.findCollection(Usuario.nameCollection);

        BasicDBObject query = new BasicDBObject();
        query.put("nickname", nickname);
        Document document = collection.find(query).first();
        if (document == null) {
            return null;
        }
        System.out.println(document.toJson());
        return document.toJson();
    }


    @GetMapping( value="id/{id}", produces = "application/json")
    public Object getUserById(@PathVariable String id) {
        Document document = MongoConnection.searchByID(Usuario.nameCollection, id);
        //Usuario u = gson.fromJson(document.toJson(), Usuario.class);
        //u.update();
        return document.toJson();
    }

    @PostMapping( value="", produces = "application/json")
    public Object createUser(@RequestBody Object user) {

        Usuario userGson = gsonController.getGson().fromJson(user.toString(), Usuario.class);
        Object userInDB = getUserByNickname(userGson.getNickname());
        if (userInDB != null) {
            throw new EntityValidationException("Usuario ya existe.");
        }
        Document document = Document.parse(gsonController.getGson().toJson(user));
        MongoConnection.insertObject(Usuario.nameCollection, document);
        return user;
    }


    @GetMapping( value="", produces = "application/json")
    public List<Object> getAllUsers() {
        List<Object> users = new ArrayList<>();
        MongoCollection<Document> documents = MongoConnection.findCollection(Usuario.nameCollection);
        try (MongoCursor<Document> cursor = documents.find().iterator()) {
            while (cursor.hasNext()) {
                //Usuario u =gsonController.getGson().fromJson(cursor.next().toJson(), Usuario.class);
                //u.update();
                users.add(cursor.next().toJson());
            }
        }
        return users;
    }
}
