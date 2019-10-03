package co.edu.javeriana.webservice.entities;

public class Usuario {
	private long id;
	private String nombre;
	private String edad;
	private String foto;
	private String descripcion;

	public Usuario() {
	}

	public Usuario(long id, String nombre, String edad, String foto, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.foto = foto;
		this.descripcion = descripcion;
	}

	public Usuario(String nombre, String edad, String foto, String descripcion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.foto = foto;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
