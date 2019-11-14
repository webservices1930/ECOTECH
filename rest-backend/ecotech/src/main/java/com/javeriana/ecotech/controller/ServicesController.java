package com.javeriana.ecotech.controller;

import org.bson.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.javeriana.ecotech.entities.Alimentacion;
import com.javeriana.ecotech.entities.Servicio;
import com.javeriana.ecotech.integration.MongoConnection;

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

}
