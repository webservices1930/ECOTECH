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

	public Servicio() {
	}

	public Servicio(String nombre, long costo, String contacto, String descripcion, long latitud, long longitud,
			List<Long> calificaciones, List<String> fotos) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.contacto = contacto;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.calificaciones = calificaciones;
		this.fotos = fotos;
	}

	public Servicio(long id, String nombre, long costo, String contacto, String descripcion, long latitud,
			long longitud, List<Long> calificaciones, List<String> fotos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.contacto = contacto;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.calificaciones = calificaciones;
		this.fotos = fotos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getCosto() {
		return costo;
	}

	public void setCosto(long costo) {
		this.costo = costo;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getLatitud() {
		return latitud;
	}

	public void setLatitud(long latitud) {
		this.latitud = latitud;
	}

	public long getLongitud() {
		return longitud;
	}

	public void setLongitud(long longitud) {
		this.longitud = longitud;
	}

	public List<Long> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Long> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public List<String> getFotos() {
		return fotos;
	}

	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}

}
