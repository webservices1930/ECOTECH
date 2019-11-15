import { Injectable } from '@angular/core';
import { BASE_URL } from '../shared/constants';
import { HttpClient } from '@angular/common/http';
import { Pregunta } from '../models/pregunta';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {


  readonly QUESTION_END_POINT = BASE_URL + 'questions/';

  constructor(
    private http: HttpClient,
  ) { }

  addPregunta(question: Pregunta, idServ: string, idClient: string): Observable<any> {
    return this.http.post<any>(`${BASE_URL}services/${idServ}/questions/users/${idClient}`, question);
  }

  getQuestionsById(idServ: string): Observable<any> {
    return this.http.get<Pregunta>(`${this.QUESTION_END_POINT}${idServ}`, {
    });
  }
}
