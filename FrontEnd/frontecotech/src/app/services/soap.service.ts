import { Injectable } from '@angular/core';
import { NgxSoapService, Client } from 'ngx-soap';

@Injectable({
  providedIn: 'root'
})
export class SoapService {

  public client: Client;

  constructor(private soap: NgxSoapService) {
    this.soap.createClient('assets/WebService.wsdl').then(client => {
      this.client = client;
      console.log(this.client);

    })
      .catch(err => console.log('Error', err));
  }

}
