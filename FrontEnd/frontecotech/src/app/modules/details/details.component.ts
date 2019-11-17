import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceService } from 'src/app/services/service.service';
import { Service, Paseo, Alimentacion, Alojamiento, Otro, Transporte } from 'src/app/models/service';
import { Client } from 'ngx-soap';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';
import { Pregunta } from 'src/app/models/pregunta';
import { CookieService } from 'ngx-cookie-service';
import { QuestionService } from '../../services/question.service';
import { WeatherService } from '../../services/weather.service';
import { isInteger } from '@ng-bootstrap/ng-bootstrap/util/util';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent implements OnInit {
  idSer = 'teamp';
  service: any;
  servicelat: String="";
  servicelon: String="";
  json: any;
  climal:String;
  climaS:String;
  descriptionl:String;
  descriptionS:String;
  // paseo: Paseo;
  // alimentacion: Alimentacion;
  // alojamiento: Alojamiento;
  // otro: Otro;
  // transporte: Transporte;
  pregunta = '';
  preguntastemp: Pregunta[] = [];
  user: User;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserService,
    private serviceService: ServiceService,
    private questionService: QuestionService,
    private cookieService: CookieService,
    private weatherService: WeatherService
  ) { }

  ngOnInit() {

    this.userService.decode().subscribe(res => {
      console.log('USER');
      this.user = res;
      console.log(res);
    });

    this.route.paramMap.subscribe(params => {
      this.idSer = params.get('id');
      console.log(this.idSer);
      this.questionService.getQuestionsById(this.idSer).subscribe(
        res => {
          console.log('Preguntas');
          console.log(res);
          this.preguntastemp = res;
          console.log(this.preguntastemp);
        }
      );



      /*
      this.soapService.client.then(client => {
        this.serviceService.getServicebyId(client as Client, this.idSer).subscribe(res => {
          console.log('Services enviado');
          console.log(res);
          this.service = res.result.return;
          console.log('servicio');
          console.log(this.service);
          if(this.service.tipo==='PASEO')
          {
            this.soapService.client.then(client => {
              this.serviceService.getPaseobyId(client as Client, this.idSer).subscribe(response =>{
                  console.log('Paseo');
                  console.log(response);
                  this.paseo = response.result.return;
              });
            });
          }
          if(this.service.tipo==='ALIMENTACION')
          {
            this.soapService.client.then(client => {
              this.serviceService.getAlimentacionbyId(client as Client, this.idSer).subscribe(response =>{
                  console.log('Alimentacion');
                  console.log(response);
                  this.alimentacion = response.result.return;
              });
            });
          }
          if(this.service.tipo==='ALOJAMIENTO')
          {
            this.soapService.client.then(client => {
              this.serviceService.getAlojamientobyId(client as Client, this.idSer).subscribe(response =>{
                  console.log('Alojameiento');
                  console.log(response);
                  this.alojamiento = response.result.return;
              });
            });
          }
          if(this.service.tipo=='OTRO')
          {
            this.soapService.client.then(client => {
              this.serviceService.getOtrobyId(client as Client, this.idSer).subscribe(response =>{
                  console.log('Otro');
                  console.log(response);
                  this.otro = response.result.return;
              });
            });
          }
          if(this.service.tipo=='TRANSPORTE')
          {
            this.soapService.client.then(client => {
              this.serviceService.getTransportebyId(client as Client, this.idSer).subscribe(response =>{
                  console.log('Transporta');
                  console.log(response);
                  this.transporte = response.result.return;
              });
            });
          }


        });

      });*/
      this.serviceService.getServicebyId(this.idSer).subscribe(res => {
        console.log('Services enviado');
        console.log(res);
        this.service = res;
        this.weatherService.getWeather(res.latitud.toString(),res.longitud.toString())
        .subscribe(
          res2=>this.json=res2,
          err2=>console.log(err2)
        );
        console.log('servicio');
        console.log(this.service);
      });
    });


  }
  addService() {
    const countServices = this.cookieService.get('count');
    const num = Number(countServices) + 1;
    console.log('Cookie creada');
    this.cookieService.set('SCS' + num, '' + this.idSer);
    this.cookieService.set('count', '' + num);
    console.log('Cookie creada');
  }

  pregutar() {
    // this.preguntastemp.push(this.pregunta);

    const question = {
      descripcion: this.pregunta
    }  as Pregunta;
    console.log(this.user);

    this.questionService.addPregunta( question , this.idSer, this.user._id).subscribe(res => {
      console.log('Pregunta enviado');
      console.log(res);
      this.preguntastemp.push(res);
    });


  }
  submitweather(fechal,fechaS){
    
    let date1 = new Date(`${fechal.value} 12:00:00`);
    let date2 = new Date(`${fechaS.value} 12:00:00`);
    let dateaux;
    let climaS:number;
    let climaL:number;
    for(let vara=0;vara<40;vara++){
     dateaux=new Date(this.json.list[vara].dt_txt);
     console.log(dateaux);
     if(dateaux.getTime()===date1.getTime()){
        climaL=(this.json.list[vara].main.temp-273);
        this.descriptionl=this.json.list[vara].weather[0].description;
     }else if(dateaux.getTime()===date2.getTime()){
        climaS=(this.json.list[vara].main.temp-273);
        this.descriptionS=this.json.list[vara].weather[0].description;
     }  
    }

    this.climal=`${climaL} ºC`;
    this.climaS=`${climaS} ºC`;
  }

}
