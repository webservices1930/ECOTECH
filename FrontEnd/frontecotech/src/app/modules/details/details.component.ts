import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SoapService } from 'src/app/services/soap.service';
import { ServiceService } from 'src/app/services/service.service';
import { Service, Paseo, Alimentacion, Alojamiento, Otro, Transporte } from 'src/app/model/service';
import { Client } from 'ngx-soap';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  idSer: String = 'teamp';
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
