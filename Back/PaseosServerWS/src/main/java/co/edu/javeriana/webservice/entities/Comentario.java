package co.edu.javeriana.webservice.entities;

public class Comentario {
	public static final String collectionName = "Comments";
	private transient long _id;
	private String descripcion;
	private String fecha;
	private Cliente cliente;
	private Servicio servicio;

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		this._id = id;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + _id + ", descripcion=" + descripcion + ", fecha=" + fecha + ", cliente=" + cliente
				+ ", servicio=" + servicio + "]";
	}

	public Comentario(long id, String descripcion, String fecha, Cliente cliente, Servicio servicio) {
		super();
		this._id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.cliente = cliente;
		this.servicio = servicio;
	}

	public Comentario() {
		super();
	}

}
