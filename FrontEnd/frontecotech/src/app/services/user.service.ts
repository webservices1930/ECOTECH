import { Injectable } from '@angular/core';
import { SoapService } from './soap.service';
import { Observer, Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private soapService: SoapService
  ) { }

  login(nickname: string, password: string): Observable<any> {
    const body = {
      nickname,
      password
    };
    return this.soapService.client.call('login', body);
  }

}
