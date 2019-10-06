import { Component, OnInit } from '@angular/core';
import { Service } from 'src/app/model/service';
import { ServiceService } from 'src/app/services/service.service';

@Component({
  selector: 'app-services-list',
  templateUrl: './services-list.component.html',
  styleUrls: ['./services-list.component.css']
})
export class ServicesListComponent implements OnInit {

  servicios: Service[];

  constructor(
    private serviceService: ServiceService
  ) { }

  ngOnInit() {

  }
  refresh() {
    this.serviceService.getAllServices().subscribe(res => {
      console.log('services enviado');
      console.log(res);
      console.log(res.result.return[0]);
      this.servicios = res.result.return;
      console.log('servicios');
      console.log(this.servicios);
      
      
    });
  }

}
