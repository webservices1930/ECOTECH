import { Injectable } from '@angular/core';
import { SoapService } from './soap.service';
import { Observer, Observable } from 'rxjs';
import { Client } from 'ngx-soap';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private soapService: SoapService
  ) { }

  login(nickname: string, password: string, client: Client): Observable<any> {
    const body = {
      arg0: nickname,
      arg1: password
    };

    return client.call('login', body);
  }

  getUserByNickName(nickname: string,  client: Client ): Observable<any> {
    const body = {
      arg0: nickname,
    };

    return client.call('leerUsuarioPorNickname', body);
  }


}
