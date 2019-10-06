package co.edu.javeriana.webservice.entities;

public class Transporte extends Servicio {
	private String horaSalida;
	private String horaLlegada;
	private TipoTransporte tipoTransporte;

	public TipoTransporte getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(TipoTransporte tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	@Override
	public String toString() {
		return "Transporte [horaSalida=" + horaSalida + ", horaLlegada=" + horaLlegada + "]";
	}

	public Transporte(String horaSalida, String horaLlegada) {
		super();
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
	}

}
