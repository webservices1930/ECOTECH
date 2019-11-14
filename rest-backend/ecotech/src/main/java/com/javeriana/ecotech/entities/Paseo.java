package com.javeriana.ecotech.entities;

public class Paseo extends Servicio {
	private String horaSalida;
	private String horaLlegada;
	private String trayecto;
	private String restricciones;
	private String sugerencias;

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

	public String getTrayecto() {
		return trayecto;
	}

	public void setTrayecto(String trayecto) {
		this.trayecto = trayecto;
	}

	public String getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(String restricciones) {
		this.restricciones = restricciones;
	}

	public String getSugerencias() {
		return sugerencias;
	}

	public void setSugerencias(String sugerencias) {
		this.sugerencias = sugerencias;
	}

	@Override
	public String toString() {
		return "Paseo [horaSalida=" + horaSalida + ", horaLlegada=" + horaLlegada + ", trayecto=" + trayecto
				+ ", restricciones=" + restricciones + ", sugerencias=" + sugerencias + "]";
	}

	public Paseo(String horaSalida, String horaLlegada, String trayecto, String restricciones, String sugerencias) {
		super();
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.trayecto = trayecto;
		this.restricciones = restricciones;
		this.sugerencias = sugerencias;
	}

	public Paseo() {
		super();
	}

}
