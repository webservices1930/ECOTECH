package co.edu.javeriana.webservice;

import javax.xml.ws.Endpoint;

import co.edu.javeriana.webservice.service.ServicioPaseo;

public class ServiciosMain {
 public static void main(String[] args) {
  Endpoint.publish("http://localhost:8080/WS/servicios",new ServicioPaseo());
 }
}