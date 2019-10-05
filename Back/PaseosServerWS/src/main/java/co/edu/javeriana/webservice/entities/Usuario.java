package co.edu.javeriana.webservice.entities;

public class Usuario {
	public static final String nameCollection = "User";
	private transient String _id;
	private String nombre;
	private String fechaNacimiento;
	private String foto;
	private String descripcion;
	private String nickname;
	private String correo;
	private String password;

	public Usuario() {
	};

	public Usuario(String _id, String nombre, String fechaNacimiento, String foto, String descripcion, String nickname,
			String correo) {
		super();
		this._id = _id;
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
		return "Usuario [id=" + _id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", foto=" + foto
				+ ", descripcion=" + descripcion + ", nickname=" + nickname + ", correo=" + correo + "]";
	}

	public String getId() {
		return _id;
	}

	public void setId(String _id) {
		this._id = _id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
