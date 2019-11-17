package com.javeriana.ecotech.controller;

import com.javeriana.ecotech.entities.Cliente;
import com.javeriana.ecotech.entities.Comentario;
import com.javeriana.ecotech.entities.Servicio;
import com.javeriana.ecotech.integration.MongoConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = { "*" })
public class CommentsController {

    @Autowired
    private GsonController gsonController;

    @GetMapping( value="/comments/{id_service}", produces = "application/json")
    public List<Comentario> getComments(@PathVariable String idServicio) {

        List<Comentario> comments = new ArrayList<Comentario>();
        MongoCollection<Document> docs = MongoConnection.findCollection(Comentario.collectionName);
        try (MongoCursor<Document> cursor = docs.find().iterator()) {
            while (cursor.hasNext()) {
                Comentario p = gsonController.getGson().fromJson(cursor.next().toJson(), Comentario.class);
                //System.out.println(p.toString());
                //System.out.println(p.getServicio().get_id().toString());
                if (p.getServicio().get_id().toString().equals(id_service)) {
                    comments.add(p);
                }
            }
        }

        return comments;
    }

    @PostMapping(value="/services/{id_service}/comments/users/{id_user}", produces = "application/json")
    public Comentario addComment(@PathVariable String id_service,@PathVariable String id_user, @RequestBody Comentario comment) {
        //Comentario comment = gsonController.getGson().fromJson(commentJson.toString(), Comentario.class);
        Comentario p = new Comentario();
        LocalDate time = LocalDate.now();
        String fecha = time.toString();

        Document d = MongoConnection.searchByID(Cliente.nameCollection, id_user);
        Cliente c = gsonController.getGson().fromJson(d.toJson(), Cliente.class);

        d = MongoConnection.searchByID(Servicio.collection, id_service);
        Servicio s = gsonController.getGson().fromJson(d.toJson(), Servicio.class);

        System.out.println(s.toString());
        System.out.println(c.toString());

        p.setDescripcion(comment.getDescripcion());
        p.setFecha(fecha);
        p.setCliente(c);
        p.setServicio(s);

        String aux = gsonController.getGson().toJson(p);
        System.out.print(aux);
        Document docComentario = Document.parse(aux);

        MongoConnection.insertObject(Comentario.collectionName, docComentario);

        return p;
    }
}
