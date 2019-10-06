import { Injectable } from '@angular/core';
import { SoapService } from './soap.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(
    private soapService: SoapService
  ) { }

  searchByNickname(nickname: String): Observable<any> {
    const body = {
      arg0: nickname
    };
    return this.soapService.client.call('leerUsuarioPorNickname', body);
  }

}
