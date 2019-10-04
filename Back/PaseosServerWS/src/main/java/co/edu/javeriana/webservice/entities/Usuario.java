package co.edu.javeriana.webservice.entities;

public class Usuario {
	private long id;
	private String nombre;
	private String fechaNacimiento;
	private String foto;
	private String descripcion;
	private String nickname;
	private String correo;
	
	public Usuario() {};

	public Usuario(long id, String nombre, String fechaNacimiento, String foto, String descripcion, String nickname,
			String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.foto = foto;
		this.descripcion = descripcion;
		this.nickname = nickname;
		this.correo = correo;
	}

	public Usuario(String nombre, String fechaNacimiento, String foto, String descripcion, String nickname,
			String correo) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.foto = foto;
		this.descripcion = descripcion;
		this.nickname = nickname;
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", foto=" + foto
				+ ", descripcion=" + descripcion + ", nickname=" + nickname + ", correo=" + correo + "]";
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
