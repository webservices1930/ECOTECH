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
}
