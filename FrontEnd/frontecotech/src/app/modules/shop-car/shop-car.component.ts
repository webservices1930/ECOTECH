import { Component, OnInit } from '@angular/core';
import { Service } from 'src/app/model/service';
import { ServiceService } from 'src/app/services/service.service';
import { SoapService } from 'src/app/services/soap.service';
import { Client } from 'ngx-soap';
import { FormGroup, FormBuilder } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-shop-car',
  templateUrl: './shop-car.component.html',
  styleUrls: ['./shop-car.component.css']
})
export class ShopCarComponent implements OnInit {

  servicios: Service[];
  serviciosTemp: Service[];

  constructor(
    private serviceService: ServiceService,
    private formBuilder: FormBuilder,
    private soapService: SoapService,
    private cookieService: CookieService) { }

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
    this.cargarServicios();
  }

  cargarServicios(){
    var numServicios = Number(this.cookieService.get("count"));
    for(var i=0;i<10){

    }
  }  

}
