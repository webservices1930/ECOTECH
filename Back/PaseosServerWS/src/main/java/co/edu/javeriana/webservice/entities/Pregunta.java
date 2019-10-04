package co.edu.javeriana.webservice.entities;

public class Pregunta {
	private long id;
	private String descripcion;
	private String fecha;
	private String respuesta;
	private Cliente clientes;
	private Servicio servicio;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", descripcion=" + descripcion + ", fecha=" + fecha + ", respuesta=" + respuesta
				+ ", clientes=" + clientes + ", servicio=" + servicio + "]";
	}

	public Pregunta(long id, String descripcion, String fecha, String respuesta, Cliente clientes, Servicio servicio) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.respuesta = respuesta;
		this.clientes = clientes;
		this.servicio = servicio;
	}

	public Pregunta() {
		super();
	}

}
