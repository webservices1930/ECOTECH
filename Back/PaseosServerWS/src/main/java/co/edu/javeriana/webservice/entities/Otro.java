package co.edu.javeriana.webservice.entities;

public class Otro extends Servicio {
	private String tipoServicio;

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	@Override
	public String toString() {
		return "Otro [tipoServicio=" + tipoServicio + "]";
	}

	public Otro(String tipoServicio) {
		super();
		this.tipoServicio = tipoServicio;
	}

	public Otro() {
		super();
	}

}
