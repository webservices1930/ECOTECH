import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  URI: String="";
  apiKey: String="936ccc6b48efadaec28ddfbcb4b1d01b";
  constructor(private httpClient : HttpClient) { 
    this.URI=`https://api.openweathermap.org/data/2.5/forecast?appid=${this.apiKey}&lat=`;
  }
  getWeather(lat: String,lon: String){
    return this.httpClient.get(`${this.URI}${lat}&lon=${lon}`);
  }
}
