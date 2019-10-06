import { Injectable } from '@angular/core';
import { SoapService } from './soap.service';
import { Observable } from 'rxjs';
import { Client } from 'ngx-soap';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(
    private soapService: SoapService
  ) { }

  searchByNickname(nickname: string, client: Client): Observable<any> {
    const body = {
      arg0: nickname
    };
    return client.call('leerUsuarioPorNickname', body);
  }

}
