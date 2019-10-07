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
        this.servicios = res.result.return;
      });
    });
    this.cargarServicios();
  }

  cargarServicios(){
    console.log('cargando servicios');
    var numServicios = Number(this.cookieService.get("count"));
    for(var i=1;i<=numServicios;i++){
      var cookie = this.cookieService.get("SCS"+i);
      for(let j of this.servicios){
        if(j.id == cookie){
          this.serviciosTemp.push(j);
        }
      }
    }
  }  

}
