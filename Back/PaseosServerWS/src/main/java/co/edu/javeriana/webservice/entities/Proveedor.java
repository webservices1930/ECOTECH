package co.edu.javeriana.webservice.entities;

import java.util.List;

public class Proveedor extends Usuario {
	private String telefono;
	private String web;
	private String usuarioTwitter;
	private String usuarioFacebook;
	private String usuarioInstagram;
	private List<Servicio> servicios;

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getUsuarioTwitter() {
		return usuarioTwitter;
	}

	public void setUsuarioTwitter(String usuarioTwitter) {
		this.usuarioTwitter = usuarioTwitter;
	}

	public String getUsuarioFacebook() {
		return usuarioFacebook;
	}

	public void setUsuarioFacebook(String usuarioFacebook) {
		this.usuarioFacebook = usuarioFacebook;
	}

	public String getUsuarioInstagram() {
		return usuarioInstagram;
	}

	public void setUsuarioInstagram(String usuarioInstagram) {
		this.usuarioInstagram = usuarioInstagram;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	@Override
	public String toString() {
		return "Proveedor [telefono=" + telefono + ", web=" + web + ", usuarioTwitter=" + usuarioTwitter
				+ ", usuarioFacebook=" + usuarioFacebook + ", usuarioInstagram=" + usuarioInstagram + ", servicios="
				+ servicios + "]";
	}

}
