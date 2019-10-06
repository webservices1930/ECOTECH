import { Injectable } from '@angular/core';
import { SoapService } from './soap.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(
    private soapService: SoapService
    ) { }


  getAllServices(): Observable<any> {
    const body = {
      arg0: '?'
    };
    return this.soapService.client.call('leerTodosServicio', body);
  }
}
