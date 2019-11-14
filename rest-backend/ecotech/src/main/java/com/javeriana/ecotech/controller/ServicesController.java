package com.javeriana.ecotech.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.javeriana.ecotech.entities.Servicio;
import com.javeriana.ecotech.integration.MongoConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

@RestController
@RequestMapping("services")
public class ServicesController {
	private Gson gson = new Gson();

	@PostMapping(value = "", produces = "application/json")
	public Object postService(@RequestBody Object service) {
		Document doc = Document.parse(gson.toJson(service));
		MongoConnection.insertObject("Service", doc);
		return service;
	}
	
	@GetMapping(value = "", produces = "application/json")
	public Object getServices() {
		List<Servicio> servicios = new ArrayList<Servicio>();
		MongoCollection<Document> documents = MongoConnection.findCollection(Servicio.collection);
		try (MongoCursor<Document> cursor = documents.find().iterator()) {
			while (cursor.hasNext()) {
				String str = cursor.next().toJson();
				Servicio s = gson.fromJson(str, Servicio.class);
				((Servicio) s).update();
				servicios.add(s);
			}
		}
		return servicios; 
	}
	@GetMapping(value = "/{id}", produces = "application/json")
	public Object getServicesbyid(@PathVariable String id) {
		System.out.println("ServicioPaseo.leerServicio() -->" + id);
		Document doc = MongoConnection.searchByID(Servicio.collection, id);
		System.out.println(doc.toString());
		//Servicio s = gson.fromJson(doc.toJson(), Servicio.class);
		//s.update();
		return doc;
	}
	
}
