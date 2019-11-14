import { Component, OnInit } from '@angular/core';
import { Service } from 'src/app/models/service';
import { ServiceService } from 'src/app/services/service.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-shop-car',
  templateUrl: './shop-car.component.html',
  styleUrls: ['./shop-car.component.scss']
})
export class ShopCarComponent implements OnInit {

  arrayServicios: Service[];
  servicios: Service[] = [];
  valor = 0;

  constructor(
    private serviceService: ServiceService,
    private formBuilder: FormBuilder,
    private cookieService: CookieService) { }

  ngOnInit() {

    this.serviceService.getAllServices().subscribe(res => {
      console.log('Services enviado');
      this.arrayServicios = res.result.return;
      console.log(res);
      console.log(this.arrayServicios);
      this.cargarServicios();
    });


  }

  cargarServicios() {
    console.log('cargando servicios');
    const numServicios = Number(this.cookieService.get('count'));
    for (let i = 1; i <= numServicios; i++) {
      const cookie = this.cookieService.get('SCS' + (i));
      // tslint:disable-next-line: prefer-for-of
      for (let j = 0; j < this.arrayServicios.length; j++) {
        if (this.arrayServicios[j].id === cookie) {
          this.valor = Number(this.arrayServicios[j].costo) + this.valor;
          this.servicios.push(this.arrayServicios[j]);
        }
      }
    }
  }

  borrarService(idServ: string) {
    console.log(idServ);
    this.servicios.splice(Number(idServ) - 1, 1);
    this.cookieService.deleteAll();
    this.cookieService.set('count', '' + this.servicios.length);
    this.valor = 0;
    for (let i = 1; i <= this.servicios.length; i++) {
      this.cookieService.set('SCS' + i, '' + this.servicios[i - 1].id);
      this.valor = this.valor + Number(this.servicios[i - 1].costo);
    }
  }

  checkout() {
    this.cookieService.set('costo', '' + this.valor);
  }

}
