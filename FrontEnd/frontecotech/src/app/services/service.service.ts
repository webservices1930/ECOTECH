import { Injectable } from '@angular/core';
import { SoapService } from './soap.service';
import { Observable } from 'rxjs';
import { Client } from 'ngx-soap';
import { Service, Alimentacion, Alojamiento, Paseo, Otro, Transporte } from '../models/service';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(
    private soapService: SoapService
    ) { }


  getAllServices(client: Client): Observable<any> {
    const body = {
    };
    return client.call('leerTodosServicio', body);
  }

  getServicebyId(client: Client, id: string) {
    const body = {
      arg0: id
    };
    return client.call('leerServicio', body);
  }

  addPregunta(client: Client, descrip: string, idServ: string, idClient: string): Observable<any> {
    const body = {
      arg0: descrip,
      arg1: idServ,
      arg2: idClient
    };
    console.log(client);
    
    return client.call('agregarPregunta', body);
  }

  getPaseobyId(client: Client, id: string) {
    const body = {
      arg0: id
    };
    console.log(client);
    
    return client.call('leerPaseo', body);
  }

  createService(client: Client, service: Service) {
    const body = {
      arg0: service
    };
    return client.call('crearServicio', body);
  }
  
  createServiceAlimentacion(client: Client, alimentacion: Alimentacion) {
    const body = {
      arg0: alimentacion
    };
    return client.call('crearServicioAlimentacion', body);
  }

  createServiceAlojamiento(client: Client, alojamiento: Alojamiento) {
    const body = {
      arg0: alojamiento
    };
    return client.call('crearServicioAlojamiento', body);
  }
  createServicePaseo(client: Client, paseo: Paseo) {
    const body = {
      arg0: paseo
    };
    return client.call('crearServicioPaseo', body);
  }
  createServiceOtro(client: Client, otro: Otro) {
    const body = {
      arg0: otro
    };
    return client.call('crearServicioOtro', body);
  }
  createServiceTransporte(client: Client, transporte: Transporte) {
    const body = {
      arg0: transporte
    };
    return client.call('crearServicioTransporte', body);
  }
}
