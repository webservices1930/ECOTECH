import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SoapService } from 'src/app/services/soap.service';
import { ServiceService } from 'src/app/services/service.service';
import { Service, Paseo, Alimentacion, Alojamiento, Otro, Transporte } from 'src/app/models/service';
import { Client } from 'ngx-soap';

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
  preguntas: string[] = [];
  preguntastemp: string[] = [];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private serviceService: ServiceService,
    private soapService: SoapService
  ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.idSer = params.get('id');
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
    this.preguntastemp.push(this.pregunta);
  }

}
