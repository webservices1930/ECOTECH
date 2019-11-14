package com.javeriana.ecotech.controller;

import com.javeriana.ecotech.entities.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.javeriana.ecotech.integration.MongoConnection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
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

	@PostMapping(value="{id_service}/users/{id_user}/buy", produces = "application/json")
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


	@GetMapping( value="user/{id_user}", produces = "application/json")
	public List<Servicio> getServiceByUser(String idUser) {

		List<Servicio> buy = new ArrayList<Servicio>();
		MongoCollection<Document> docs = MongoConnection.findCollection(Comentario.collectionName);
		try (MongoCursor<Document> cursor = docs.find().iterator()) {
			while (cursor.hasNext()) {
				Comentario p = gsonController.getGson().fromJson(cursor.next().toJson(), Comentario.class);
				//System.out.println(p.toString());
				//System.out.println(p.getServicio().get_id().toString());
				if (p.getServicio().get_id().toString().equals(idUser)) {
					buy.add(p.getServicio());
				}
			}
		}

		return buy;
	}

}
