import { Component, OnInit } from '@angular/core';
import { Service } from 'src/app/model/service';
import { ServiceService } from 'src/app/services/service.service';
import { SoapService } from 'src/app/services/soap.service';
import { Client } from 'ngx-soap';

@Component({
  selector: 'app-services-list',
  templateUrl: './services-list.component.html',
  styleUrls: ['./services-list.component.css']
})
export class ServicesListComponent implements OnInit {

  servicios: Service[];

  constructor(
    private serviceService: ServiceService,
    private soapService: SoapService
  ) { }

  ngOnInit() {
    this.soapService.client.then(client => {
      this.serviceService.getAllServices(client as Client).subscribe(res => {
        console.log('Services enviado');
        console.log(res);
        this.servicios = res.result.return;
        console.log('servicios');
        console.log(this.servicios);
      });
    });
  }
  profile() {
    
  }

}
