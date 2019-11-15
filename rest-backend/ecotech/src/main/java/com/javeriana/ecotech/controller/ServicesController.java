package com.javeriana.ecotech.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javeriana.ecotech.entities.Servicio;

import com.javeriana.ecotech.entities.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;

import com.javeriana.ecotech.integration.MongoConnection;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("services")
public class ServicesController {
	@Autowired
	private GsonController gsonController;

	@PostMapping(value = "", produces = "application/json")
	public Object postService(@RequestBody Object service) {
		Document doc = Document.parse(gsonController.getGson().toJson(service));
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
				Servicio s = gsonController.getGson().fromJson(str, Servicio.class);
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
		// Servicio s = gson.fromJson(doc.toJson(), Servicio.class);
		// s.update();
		return doc;
	}

	@PostMapping(value = "{id_service}/users/{id_user}/buy", produces = "application/json")
	public Compra buy(@PathVariable String id_service, @PathVariable String id_user) {
		Compra p = new Compra();

		Document d = MongoConnection.searchByID(Cliente.nameCollection, id_user);
		Cliente c = gsonController.getGson().fromJson(d.toJson(), Cliente.class);

		d = MongoConnection.searchByID(Servicio.collection, id_service);
		Servicio s = gsonController.getGson().fromJson(d.toJson(), Servicio.class);

		System.out.println(s.toString());
		System.out.println(c.toString());

		p.setIs_commented(false);
		p.setClientes(c);
		p.setServicio(s);

		String aux = gsonController.getGson().toJson(p);
		System.out.print(aux);
		Document docCompra = Document.parse(aux);

		MongoConnection.insertObject(Compra.collection, docCompra);

		return p;
	}

	@GetMapping(value = "user/{id_user}", produces = "application/json")
	public List<Servicio> getServiceByUser(String idUser) {

		List<Servicio> buy = new ArrayList<Servicio>();
		MongoCollection<Document> docs = MongoConnection.findCollection(Comentario.collectionName);
		try (MongoCursor<Document> cursor = docs.find().iterator()) {
			while (cursor.hasNext()) {
				Comentario p = gsonController.getGson().fromJson(cursor.next().toJson(), Comentario.class);
				// System.out.println(p.toString());
				// System.out.println(p.getServicio().get_id().toString());
				if (p.getServicio().get_id().toString().equals(idUser)) {
					buy.add(p.getServicio());
				}
			}
		}

		return buy;
	}

}
