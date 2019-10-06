import { Component, OnInit } from '@angular/core';
import { Service } from 'src/app/model/service';
import { ServiceService } from 'src/app/services/service.service';
import { SoapService } from 'src/app/services/soap.service';
import { Client } from 'ngx-soap';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-services-list',
  templateUrl: './services-list.component.html',
  styleUrls: ['./services-list.component.css']
})
export class ServicesListComponent implements OnInit {

  servicios: Service[];
  serviciosTemp: Service[];

  constructor(
    private serviceService: ServiceService,
    private formBuilder: FormBuilder,
    private soapService: SoapService,
  ) { }

  serviceForm: FormGroup;

  ngOnInit() {
    this.soapService.client.then(client => {
      this.serviceService.getAllServices(client as Client).subscribe(res => {
        console.log('Services enviado');
        console.log(res);
        this.servicios = res.result.return;
        this.serviciosTemp = this.servicios.slice();
        console.log('servicios');
        console.log(this.servicios);
      });
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
      if (servicio.nombre.toLowerCase().includes(keyword.toLowerCase()) ) {
        this.servicios.push(servicio);
      }
    });
  }

  private buildServiceForm() {
    this.serviceForm = this.formBuilder.group({
      keyword: ['', ],
    });
  }

}
