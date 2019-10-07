package co.edu.javeriana.webservice.entities;

import java.util.List;

public class Cliente extends Usuario {
	private String di;
	private List<String> idServicios;
	private List<Pregunta> preguntas;
	private List<Comentario> comentarios;

	public String getDi() {
		return di;
	}

	public void setDi(String di) {
		this.di = di;
	}

	public List<String> getServicios() {
		return idServicios;
	}

	public void setServicios(List<String> servicios) {
		this.idServicios = servicios;
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
		String toStringUser = super.toString();
		return "Cliente [di=" + di + ", servicios=" + idServicios + ", preguntas=" + preguntas + ", comentarios="
				+ comentarios + "]"+ toStringUser ;
	}

	public Cliente(String di, List<String> servicios, List<Pregunta> preguntas, List<Comentario> comentarios) {
		super();
		this.di = di;
		this.idServicios = servicios;
		this.preguntas = preguntas;
		this.comentarios = comentarios;
	}

	public Cliente() {
		super();
	}

}
