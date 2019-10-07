package co.edu.javeriana.webservice.entities;

public class Alojamiento extends Servicio {
	private int numHabitaciones;
	private int numHuespedes;
	private String extras;
	private TipoAlojamiento tipoAlojamiento;

	public TipoAlojamiento getTipoAlojamiento() {
		return tipoAlojamiento;
	}

	public void setTipoAlojamiento(TipoAlojamiento tipoAlojamiento) {
		this.tipoAlojamiento = tipoAlojamiento;
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public int getNumHuespedes() {
		return numHuespedes;
	}

	public void setNumHuespedes(int numHuespedes) {
		this.numHuespedes = numHuespedes;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	@Override
	public String toString() {
		return "Alojamiento [numHabitaciones=" + numHabitaciones + ", numHuespedes=" + numHuespedes + ", extras="
				+ extras + "]";
	}

	public Alojamiento(int numHabitaciones, int numHuespedes, String extras) {
		super();
		this.numHabitaciones = numHabitaciones;
		this.numHuespedes = numHuespedes;
		this.extras = extras;
	}

	public Alojamiento() {
		super();
	}

}
