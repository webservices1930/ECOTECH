package co.edu.javeriana.webservice.entities;

import java.util.List;

public class Cliente extends Usuario {
	private String di;
	private List<Servicio> servicios;
	private List<Pregunta> preguntas;
	private List<Comentario> comentarios;

	public String getDi() {
		return di;
	}

	public void setDi(String di) {
		this.di = di;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Cliente [di=" + di + ", servicios=" + servicios + ", preguntas=" + preguntas + ", comentarios="
				+ comentarios + "]";
	}

	public Cliente(String di, List<Servicio> servicios, List<Pregunta> preguntas, List<Comentario> comentarios) {
		super();
		this.di = di;
		this.servicios = servicios;
		this.preguntas = preguntas;
		this.comentarios = comentarios;
	}

	public Cliente() {
		super();
	}

}
