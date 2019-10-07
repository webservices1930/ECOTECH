import { Injectable } from '@angular/core';
import { SoapService } from './soap.service';
import { Observer, Observable, of } from 'rxjs';
import { Client } from 'ngx-soap';
import { User, Cliente, Proveedor } from '../models/user.model';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  tryGetUser = true;
  userToReturn: User = null;

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

  createUser( user: User, client: Client ): Observable<any> {
    const body = {
      arg0: user,
    };

    return client.call('crearUsuario', body);
  }

  createClient( cliente: Cliente, client: Client ): Observable<any> {
    const body = {
      arg0: cliente,
    };

    return client.call('crearCliente', body);
  }

  createProveedor( proveedor: Proveedor, client: Client ): Observable<any> {
    const body = {
      arg0: proveedor,
    };

    return client.call('crearProveedor', body);
  }

  getProviderByNickname(nickname: string, client: Client): Observable<any> {
    const body = {
      arg0: nickname,
    };

    return client.call('obtenerProveedorPorNickname', body);
  }

  getClienteByNickname(nickname: string, client: Client): Observable<any> {
    const body = {
      arg0: nickname,
    };

    return client.call('obtenerClientePorNickname', body);
  }

  decode(): Observable<any> {
    if (this.userToReturn == null ) {
      this.userToReturn = JSON.parse(localStorage.getItem('user'));
      return of(this.userToReturn);
    } else {
      return of(this.userToReturn);
    }
  }


}
