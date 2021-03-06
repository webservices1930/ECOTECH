import { Component, OnInit } from '@angular/core';
import { Service } from 'src/app/models/service';
import { ServiceService } from 'src/app/services/service.service';

import { Client } from 'ngx-soap';
import { FormGroup, FormBuilder } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-services-list',
  templateUrl: './services-list.component.html',
  styleUrls: ['./services-list.component.scss']
})
export class ServicesListComponent implements OnInit {

  servicios: Service[];
  serviciosTemp: Service[];
  user: string;

  constructor(
    private serviceService: ServiceService,
    private userService: UserService,
    private formBuilder: FormBuilder,
  ) { }

  serviceForm: FormGroup;

  ngOnInit() {
    console.log('HOLAAAAAAA');

    this.serviceService.getAllServices().subscribe(res => {
      console.log('Services enviado');
      console.log(res);
      this.servicios = res;
      this.serviciosTemp = this.servicios.slice();
      console.log('servicios');
      console.log(this.servicios);
    });

    this.userService.decode().subscribe(res => {
      console.log('USER');
      this.user = res.nickname;
      console.log(res);
    });
    this.buildServiceForm();
  }
  profile() {

  }

  search() {
    const keyword = this.serviceForm.value.keyword;
    this.searchLocal(keyword);
  }

  private searchLocal(keyword: string) {
    this.servicios = [];
    this.serviciosTemp.forEach(servicio => {
      if (servicio.nombre.toLowerCase().includes(keyword.toLowerCase())) {
        this.servicios.push(servicio);
      }
    });
  }

  private buildServiceForm() {
    this.serviceForm = this.formBuilder.group({
      keyword: ['',],
    });
  }

  private searchType(event: any) {
    console.log(event.target.value);
    this.servicios = [];
    this.serviciosTemp.forEach(servicio => {
      if (servicio.tipo.toLowerCase().includes(event.target.value.toLowerCase())) {
        this.servicios.push(servicio);
      }
    });
  }

}
