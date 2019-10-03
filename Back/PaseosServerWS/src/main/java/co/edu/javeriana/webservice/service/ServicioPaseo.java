package co.edu.javeriana.webservice.service;

import java.util.List;

import javax.jws.WebService;

import co.edu.javeriana.webservice.entities.*;

@WebService(endpointInterface = "co.edu.javeriana.webservice.service.PaseosService")
public class ServicioPaseo implements PaseosService {

	@Override
	public Servicio crearServicio(Servicio paseo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Servicio leerServicio(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Servicio> leerTodosServicio(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Servicio actualizarPaseo(Long id, Servicio paseo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarPaseo(Long id) {
		// TODO Auto-generated method stub
		return false;
	}




}
