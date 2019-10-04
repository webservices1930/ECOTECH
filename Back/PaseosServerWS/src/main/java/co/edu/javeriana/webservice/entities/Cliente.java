package co.edu.javeriana.webservice.entities;

import java.util.List;

public class Cliente extends Usuario {
	private long id;
	private List<Servicio> servicios;
	private List<Pregunta> preguntas;
}
