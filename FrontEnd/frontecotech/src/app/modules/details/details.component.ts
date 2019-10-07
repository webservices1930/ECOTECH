import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SoapService } from 'src/app/services/soap.service';
import { ServiceService } from 'src/app/services/service.service';
import { Service, Paseo, Alimentacion, Alojamiento, Otro, Transporte } from 'src/app/models/service';
import { Client } from 'ngx-soap';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';
import { Pregunta } from 'src/app/models/pregunta';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  idSer: string = 'teamp';
  service: Service;
  paseo: Paseo;
  alimentacion: Alimentacion;
  alojamiento: Alojamiento;
  otro: Otro;
  transporte: Transporte;
  pregunta: string = '';
  preguntastemp: Pregunta[] = [];
  user: User;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserService,
    private serviceService: ServiceService,
    private soapService: SoapService
  ) { }

  ngOnInit() {

    this.userService.decode().subscribe(res => {
      console.log("USER");
      this.user = res;
      console.log(res);
    });

    this.route.paramMap.subscribe(params => {
      this.idSer = params.get('id');

      this.soapService.client.then(client => {
        this.serviceService.getPreguntas(client as Client, this.idSer).subscribe(
          res => {
            console.log('Pregutnas'); 
            console.log(res);
            this.preguntastemp = res.result.return;
            console.log(this.preguntastemp);
          }
        );
      });

      console.log(this.idSer);
      this.soapService.client.then(client => {
        this.serviceService.getServicebyId(client as Client, this.idSer).subscribe(res => {
          console.log('Services enviado');
          console.log(res);
          this.service = res.result.return;
          console.log('servicio');
          console.log(this.service);
          if(this.service.tipo=='PASEO')
          {
            this.soapService.client.then(client => {
              this.serviceService.getPaseobyId(client as Client, this.idSer).subscribe(response =>{
                  console.log('Paseo');
                  console.log(response);
                  this.paseo = response.result.return;
              });
            });
          }
          if(this.service.tipo=='ALIMENTACION')
          {
            this.soapService.client.then(client => {
              this.serviceService.getPaseobyId(client as Client, this.idSer).subscribe(response =>{
                  console.log('Alimentacion');
                  console.log(response);
                  this.alimentacion = response.result.return;
              });
            });
          }
          if(this.service.tipo=='ALOJAMIENTO')
          {
            this.soapService.client.then(client => {
              this.serviceService.getPaseobyId(client as Client, this.idSer).subscribe(response =>{
                  console.log('Alojameiento');
                  console.log(response);
                  this.alojamiento = response.result.return;
              });
            });
          }
          if(this.service.tipo=='OTRO')
          {
            this.soapService.client.then(client => {
              this.serviceService.getPaseobyId(client as Client, this.idSer).subscribe(response =>{
                  console.log('Otro');
                  console.log(response);
                  this.otro = response.result.return;
              });
            });
          }
          if(this.service.tipo=='TRANSPORTE')
          {
            this.soapService.client.then(client => {
              this.serviceService.getPaseobyId(client as Client, this.idSer).subscribe(response =>{
                  console.log('Transporta');
                  console.log(response);
                  this.transporte = response.result.return;
              });
            });
          }


        });
      });
    });
  }

  pregutar(){
    //this.preguntastemp.push(this.pregunta);

    this.soapService.client.then(client => {
      this.serviceService.addPregunta(client as Client, this.pregunta, this.idSer, this.user.id).subscribe(res => {
        console.log('Pregunta enviado');
        console.log(res);
        this.preguntastemp.push(res.result.return);
      });
    });

  }

}
