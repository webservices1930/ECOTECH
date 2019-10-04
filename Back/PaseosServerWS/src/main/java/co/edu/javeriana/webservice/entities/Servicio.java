package co.edu.javeriana.webservice.entities;

import java.util.List;

public class Servicio {
	private long id;
	private String nombre;
	private long costo;
	private String contacto;
	private String descripcion;
	private long latitud;
	private long longitud;
	private List<Long> calificaciones;
	private List<String> fotos;
	private List<Comentario> comentarios;
	private List<Pregunta> preguntas;

	

}
