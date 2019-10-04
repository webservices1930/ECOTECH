package co.edu.javeriana.webservice.entities;

public class Alimentacion extends Servicio {
	private String tipoComida;

	public Alimentacion() {
		super();
	}

	public Alimentacion(String tipoComida) {
		super();
		this.tipoComida = tipoComida;
	}

	public String getTipoComida() {
		return tipoComida;
	}

	public void setTipoComida(String tipoComida) {
		this.tipoComida = tipoComida;
	}

	@Override
	public String toString() {
		return "Alimentacion [tipoComida=" + tipoComida + ", getTipoComida()=" + getTipoComida() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
