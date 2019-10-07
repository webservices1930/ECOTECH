import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SoapService } from 'src/app/services/soap.service';
import { ServiceService } from 'src/app/services/service.service';
import { Service, Paseo } from 'src/app/models/service';
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
  pregunta: string = '';
  preguntas: string[] = [];

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
        });
      });
    });


  }


}
