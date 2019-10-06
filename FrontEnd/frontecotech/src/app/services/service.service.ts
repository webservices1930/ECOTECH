import { Injectable } from '@angular/core';
import { SoapService } from './soap.service';
import { Observable } from 'rxjs';
import { Client } from 'ngx-soap';

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

  getServicebyId(client: Client, id: String){
    const body = {
      'arg0': id
    };
    return client.call('leerServicio', body);
  }

  getPaseobyId(client: Client, id: String){
    const body = {
      'arg0': id
    };
    return client.call('leerPaseo', body);
  }
}
