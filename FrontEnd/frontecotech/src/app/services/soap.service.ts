import { Injectable } from '@angular/core';
import { NgxSoapService, Client } from 'ngx-soap';
import { Observable, of, from } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SoapService {



  constructor(private soap: NgxSoapService) {

  }

  get client() {
    return this.soap.createClient('assets/WebService.wsdl')
      .catch(err => console.log('Error', err));
  }

}
