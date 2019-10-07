import { Component, OnInit } from '@angular/core';
import { Service } from 'src/app/models/service';
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

  arrayServicios: Service[];
  servicios: Service[] = [];
  valor: number = 0;

  constructor(
    private serviceService: ServiceService,
    private formBuilder: FormBuilder,
    private soapService: SoapService,
    private cookieService: CookieService) { }

  ngOnInit() {
    this.soapService.client.then(client => {
      this.serviceService.getAllServices(client as Client).subscribe(res => {
        console.log('Services enviado');
        this.arrayServicios = res.result.return;
        console.log(res);
        console.log(this.arrayServicios);
        this.cargarServicios();
      });
    });
    
  }

  cargarServicios(){
    console.log('cargando servicios');
    var numServicios = Number(this.cookieService.get("count"));
    for(var i=1;i<=numServicios;i++){
      var cookie = this.cookieService.get("SCS"+(i));
      for(var j =0;j<this.arrayServicios.length;j++){
        if(this.arrayServicios[j].id === cookie){
          this.valor = Number(this.arrayServicios[j].costo)+this.valor;
          this.servicios.push(this.arrayServicios[j]);
        }
      }
    }
  }  

  borrarService(idServ:string){
    console.log(idServ)
    this.cookieService.delete("SCS"+idServ);
    var numServicios = Number(this.cookieService.get("count"))-1;
    //this.cookieService.set("count",""+numServicios);
  }

  checkout(){
    this.cookieService.set("costo",""+this.valor);
  }

}
