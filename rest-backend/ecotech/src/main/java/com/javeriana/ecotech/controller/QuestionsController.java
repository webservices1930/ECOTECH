package com.javeriana.ecotech.controller;

import com.javeriana.ecotech.entities.Cliente;
import com.javeriana.ecotech.entities.Pregunta;
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
public class QuestionsController {

    @Autowired
    private GsonController gsonController;

    @GetMapping( value="/questions/{id_service}", produces = "application/json")
    public List<Pregunta> getQuestions(String idServicio) {

        List<Pregunta> questions = new ArrayList<Pregunta>();
        MongoCollection<Document> docs = MongoConnection.findCollection(Pregunta.collectionName);
        try (MongoCursor<Document> cursor = docs.find().iterator()) {
            while (cursor.hasNext()) {
                Pregunta p = gsonController.getGson().fromJson(cursor.next().toJson(), Pregunta.class);
                //System.out.println(p.toString());
                //System.out.println(p.getServicio().get_id().toString());
                if (p.getServicio().get_id().toString().equals(idServicio)) {
                    questions.add(p);
                }
            }
        }

        return questions;
    }

    @PostMapping(value="/services/{id_service}/questions/users/{id_user}", produces = "application/json")
    public Pregunta addQuestion(@PathVariable String id_service, @PathVariable String id_user, @RequestBody Pregunta question) {
        Pregunta p = new Pregunta();
        LocalDate time = LocalDate.now();
        String fecha = time.toString();

        Document d = MongoConnection.searchByID(Cliente.nameCollection, id_user);
        Cliente c = gsonController.getGson().fromJson(d.toJson(), Cliente.class);

        d = MongoConnection.searchByID(Servicio.collection, id_service);
        Servicio s = gsonController.getGson().fromJson(d.toJson(), Servicio.class);

        System.out.println(s.toString());
        System.out.println(c.toString());

        p.setDescripcion(question.getDescripcion());
        p.setFecha(fecha);
        p.setClientes(c);
        p.setServicio(s);

        String aux = gsonController.getGson().toJson(p);
        System.out.print(aux);
        Document docPregunta = Document.parse(aux);

        MongoConnection.insertObject(Pregunta.collectionName, docPregunta);

        return p;
    }
}
