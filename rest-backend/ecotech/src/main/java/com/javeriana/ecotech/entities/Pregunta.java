package com.javeriana.ecotech.entities;

import org.bson.types.ObjectId;

public class Pregunta {
	public static final String collectionName = "Questions";
	private ObjectId _id;
	private String id;
	private String descripcion;
	private String fecha;
	private String respuesta;
	private Cliente clientes;
	private Servicio servicio;

	public void update() {
		this.id = this._id.toString();
	}

	public void setId(String id) {
		this.id = id;
	}

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId id) {
		this._id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "Pregunta [id=" + _id + ", descripcion=" + descripcion + ", fecha=" + fecha + ", respuesta=" + respuesta
				+ ", clientes=" + clientes + ", servicio=" + servicio + "]";
	}

	public Pregunta(ObjectId id, String descripcion, String fecha, String respuesta, Cliente clientes,
			Servicio servicio) {
		super();
		this._id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.respuesta = respuesta;
		this.clientes = clientes;
		this.servicio = servicio;
	}

	public Pregunta() {
		super();
	}

}
