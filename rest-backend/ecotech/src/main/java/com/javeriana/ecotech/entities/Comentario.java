package com.javeriana.ecotech.entities;

import org.bson.types.ObjectId;

public class Comentario {
	public static final String collectionName = "Comments";
	private ObjectId _id;
	private String id;
	private String descripcion;
	private String fecha;
	private Cliente cliente;
	private Servicio servicio;

	public void update(){
		this.id = this._id.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId id) {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + _id + ", descripcion=" + descripcion + ", fecha=" + fecha + ", cliente=" + cliente
				+ ", servicio=" + servicio + "]";
	}

	public Comentario(ObjectId id, String descripcion, String fecha, Cliente cliente, Servicio servicio) {
		super();
		this._id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.cliente = cliente;
		this.servicio = servicio;
	}

	public Comentario() {
		super();
	}

}
