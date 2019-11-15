import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from 'ngx-soap';
import { Service, Alimentacion, Alojamiento, Paseo, Otro, Transporte } from '../models/service';
import { BASE_URL } from '../shared/constants';
import { HttpClient } from '@angular/common/http';
import { Noticia } from '../models/noticia';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  readonly SERVICE_END_POINT = BASE_URL + 'services/';
  readonly SERVICE_NEWS = BASE_URL + 'news/';
  readonly SERVICE_REVIEW = BASE_URL + 'comments/';

  constructor(
    private http: HttpClient,
    ) { }

  /*
    -------BEFORE


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

   getPreguntas(client: Client, idServ: string): Observable<any> {
    const body = {
      arg0: idServ
    };
    console.log(client);

    return client.call('getListaPreguntas', body);
  }

  getPaseobyId(client: Client, id: string) {
    const body = {
      arg0: id
    };
    console.log(client);

    return client.call('leerPaseo', body);
  }
  getAlimentacionbyId(client: Client, id: string) {
    const body = {
      arg0: id
    };
    console.log(client);

    return client.call('leerAlimentacion', body);
  }
  getOtrobyId(client: Client, id: string) {
    const body = {
      arg0: id
    };
    console.log(client);

    return client.call('leerOtro', body);
  }
  getAlojamientobyId(client: Client, id: string) {
    const body = {
      arg0: id
    };
    console.log(client);

    return client.call('leerAlojamiento', body);
  }
  getTransportebyId(client: Client, id: string) {
    const body = {
      arg0: id
    };
    console.log(client);

    return client.call('leerTransporte', body);
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
  */

  getAllServices(): Observable<any> {
    return this.http.get<Service[]>(this.SERVICE_END_POINT, {
      //withCredentials: true
    });
  }

  getServicebyId(id: string) {
    return this.http.get<Service>(`${this.SERVICE_END_POINT}/${id}`, {
      withCredentials: true
    });
  }

  createService(service: Service) {
    return this.http.post<Service>(`${this.SERVICE_END_POINT}`, service);
  }

  getNews(country:string,category:string){
    return this.http.get<any>(`${this.SERVICE_NEWS}/${country}/${category}`);
  }

  getReview(idService:string){
    return this.http.get<any>(`${this.SERVICE_REVIEW}/${idService}`);
  }
}
