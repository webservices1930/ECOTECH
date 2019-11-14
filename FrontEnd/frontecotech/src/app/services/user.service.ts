import { Injectable } from '@angular/core';
import { Observer, Observable, of } from 'rxjs';
import { User, Cliente, Proveedor } from '../models/user.model';
import { map, catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { BASE_URL } from '../shared/constants';
import { handleError } from './error-handler';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  readonly USER_END_POINT = BASE_URL + 'users/';
  tryGetUser = true;
  userToReturn: User = null;

  constructor(
    private http: HttpClient,
    private cookieService: CookieService,
  ) { }

  /*
  -----------------------------------Before


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

  */


  loginUser(nickname: string, password: string) {
    const formHeaders = new HttpHeaders();
    formHeaders.append('Content-Type', 'application/x-www-form-urlencoded');
    const formParams = new HttpParams()
      .set('nickname', nickname)
      .set('password', password);
    return this.http.post(`${BASE_URL}login`, null, {
      headers: formHeaders,
      params: formParams,
      withCredentials: true
    }).pipe(
      map(_ => {
        this.tryGetUser = true;
        return _;
      }),
      catchError(handleError)
    );
  }

  createUser(user: User): Observable<User> {
    return this.http.post<User>(`${BASE_URL}public/users/`, user);
  }

  logout(): void {
    this.http.post(`${BASE_URL}logout`, '', {
      withCredentials: true
    }).subscribe(_ => {
      this.userToReturn = null;
      this.cookieService.delete('JSESSIONID');
      this.tryGetUser = false;
    });
  }

  updateUser(userId: number, user: User): Observable<User> {
    return this.http.put<User>(`${this.USER_END_POINT}${userId}`, user, {
      withCredentials: true
    });
  }

  deleteUser(userId: number) {
    return this.http.delete<User>(`${this.USER_END_POINT}${userId}`, {
      withCredentials: true
    });
  }

  getLoggedUser(): Observable<User> {
    return this.http.get<User>(`${BASE_URL}current-user`, {
      withCredentials: true
    }).pipe(
      map(userLogged => {
        this.userToReturn = userLogged;
        return userLogged;
      })
    );
  }


  getUserById(userId: number): Observable<User> {
    return this.http.get<User>(`${this.USER_END_POINT}${userId}`, {
      withCredentials: true
    });
  }

  getUserByNickName(nickname: string): Observable<User> {
    return this.http.get<User>(`${this.USER_END_POINT}${nickname}`, {
      withCredentials: true
    });
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.USER_END_POINT, {
      withCredentials: true
    });
  }

  decode(): Observable<any> {
    if (this.userToReturn == null && this.tryGetUser) {
      return this.getLoggedUser().pipe(
        catchError(error => {
          console.log(error);
          if (error.status === 401) {
            console.log('Voy a eliminar');
            this.cookieService.delete('JSESSIONID');
            this.tryGetUser = false;
          }
          return error;
        })
      );
    } else {
      return of(this.userToReturn);
    }

  }

  isAdmin(): Observable<boolean> {
    return this.decode().pipe(
      map(user => {
        return user != null && user.role === 'ADMIN';
      })
    );
  }

  isClient(): Observable<boolean> {
    return this.decode().pipe(
      map(user => {
        return user != null && user.rolUsuario === 'CLIENTE';
      })
    );
  }
  isProvider(): Observable<boolean> {
    return this.decode().pipe(
      map(user => {
        return user != null && user.rolUsuario === 'PROVEEDOR';
      })
    );
  }

  isAuthenticated(): Observable<boolean> {
    return this.decode().pipe(
      map(user => {
        return user != null;
      })
    );
  }
}
