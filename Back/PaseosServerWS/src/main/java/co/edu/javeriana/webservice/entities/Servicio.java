package co.edu.javeriana.webservice.entities;

import org.bson.types.ObjectId;

import java.util.List;

public class Servicio {
	public static final String collection = "Service";
	private ObjectId _id;
	private String id;
	private TipoServicio tipo;
	private String nombre;
	private long costo;
	private String contacto;
	private String descripcion;
	private long latitud;
	private long longitud;
	private transient List<Long> calificaciones;
	private List<String> fotos;
//	private transient List<Comentario> comentarios;
//	private transient List<Pregunta> preguntas;

	public void update(){
		this.id = this._id.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public TipoServicio getTipo() {
		return tipo;
	}

	public void setTipo(TipoServicio tipo) {
		this.tipo = tipo;
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

//	public List<Comentario> getComentarios() {
//		return comentarios;
//	}
//
//	public void setComentarios(List<Comentario> comentarios) {
//		this.comentarios = comentarios;
//	}
//
//	public List<Pregunta> getPreguntas() {
//		return preguntas;
//	}
//
//	public void setPreguntas(List<Pregunta> preguntas) {
//		this.preguntas = preguntas;
//	}

	@Override
	public String toString() {
		return "Servicio [id=" + _id + ", nombre=" + nombre + ", costo=" + costo + ", contacto=" + contacto
				+ ", descripcion=" + descripcion + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", calificaciones=" + calificaciones + ", fotos=" + fotos + "]"+ id;
	}

	public Servicio(ObjectId _id, String nombre, long costo, String contacto, String descripcion, long latitud,
			long longitud, List<Long> calificaciones, List<String> fotos, List<Comentario> comentarios,
			List<Pregunta> preguntas) {
		super();
		this._id = _id;
		this.nombre = nombre;
		this.costo = costo;
		this.contacto = contacto;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.calificaciones = calificaciones;
		this.fotos = fotos;
//		this.comentarios = comentarios;
//		this.preguntas = preguntas;
	}

	public Servicio(String nombre, long costo, String contacto, String descripcion, long latitud, long longitud,
			List<Long> calificaciones, List<String> fotos, List<Comentario> comentarios, List<Pregunta> preguntas) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.contacto = contacto;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.calificaciones = calificaciones;
		this.fotos = fotos;
//		this.comentarios = comentarios;
//		this.preguntas = preguntas;
	}

	public Servicio() {
		super();
		this.nombre = "No data";
		this.costo = -1;
		this.contacto = "No data";
		this.descripcion = "No data";
		this.latitud = -1;
		this.longitud = -1;
		this.tipo = TipoServicio.OTRO;
	}

}
