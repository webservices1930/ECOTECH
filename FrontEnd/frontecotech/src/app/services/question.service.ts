import { Injectable } from '@angular/core';
import { BASE_URL } from '../shared/constants';
import { HttpClient } from '@angular/common/http';
import { Pregunta } from '../models/pregunta';
import { Observable } from 'rxjs';
import { Cliente } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {


  readonly QUESTION_END_POINT = BASE_URL + 'questions/';

  constructor(
    private http: HttpClient,
  ) { }

  addPregunta(question: Pregunta, idServ: string, idClient: any): Observable<any> {
    /*const cliente: Cliente = {
      _id : idClient
    };
    question.cliente = cliente;
    console.log(question);*/
    console.log(idClient.$oid);
    return this.http.post<any>(`${BASE_URL}services/${idServ}/questions/users/${idClient.$oid}`, question);
  }

  getQuestionsById(idServ: string): Observable<any> {
    return this.http.get<Pregunta>(`${this.QUESTION_END_POINT}${idServ}`, {
    });
  }
}
