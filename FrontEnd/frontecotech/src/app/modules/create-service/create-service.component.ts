import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ServiceService } from '../../services/service.service';
import { SoapService } from '../../services/soap.service';
import { Router } from '@angular/router';
import { TypeService, Service, Alimentacion, Alojamiento, Otro, Paseo, Transporte } from '../../models/service';
import { toArray } from 'rxjs/operators';
import { Client } from 'ngx-soap';

@Component({
  selector: 'app-create-service',
  templateUrl: './create-service.component.html',
  styleUrls: ['./create-service.component.css']
})
export class CreateServiceComponent implements OnInit {

  constructor(
    private formBuilder: FormBuilder,
    private serviceService: ServiceService,
    private soapService: SoapService,
    private router: Router
  ) { }

  serviceForm: FormGroup;
  public typeService = [];

  ngOnInit() {
    this.buildServiceForm();
    this.typeService = Object.keys(TypeService).map(k => TypeService[k]);
    this.typeService.splice(5);
    console.log(this.typeService);
  }

  goodAction() {
    alert('Creado correctamente.');
    this.router.navigate(['/services']);
  }

  createServiceWithClient( client: Client ) {
    const service = this.serviceForm.value as Service;
    console.log(service);
    console.log(TypeService.Alimentacion.toString());
    if (service.tipo == null) {
      this.serviceService.createService(client, service).subscribe( res => {
        this.goodAction();
      });
    } else if (service.tipo === 'Alimentacion') {
      const alimentacion = this.serviceForm.value as Alimentacion;
      this.serviceService.createServiceAlimentacion(client, alimentacion).subscribe(res => {
        this.goodAction();
      });
    } else if (service.tipo === 'Alojamiento') {
      const alojamiento = this.serviceForm.value as Alojamiento;
      this.serviceService.createServiceAlojamiento(client, alojamiento).subscribe(res => {
        this.goodAction();
      });
    } else if (service.tipo === 'Otro') {
      const otro = this.serviceForm.value as Otro;
      this.serviceService.createServiceOtro(client, otro).subscribe(res => {
        this.goodAction();
      });
    } else if (service.tipo === 'Paseo') {
      const paseo = this.serviceForm.value as Paseo;
      this.serviceService.createServicePaseo(client, paseo).subscribe(res => {
        this.goodAction();
      });
    } else if (service.tipo === 'Transporte') {
      const transporte = this.serviceForm.value as Transporte;
      this.serviceService.createServiceTransporte(client, transporte).subscribe(res => {
        this.goodAction();
      });
    }
  }

  createService() {
    console.log(this.serviceForm);
    this.soapService.client.then(client => {
      this.createServiceWithClient(client as Client);
    });
  }

  private buildServiceForm() {
    this.serviceForm = this.formBuilder.group({
      nombre: ['', [Validators.required]],
      // tipo: ['', ],
      descipcion: ['', [Validators.required]],
      contacto: ['', [Validators.required]],
      costo: ['', [Validators.required]],
      latitud: ['', [Validators.required]],
      longitud: ['', [Validators.required]],
      tipo: ['', [Validators.required]],
      // Paseo && Transporte
      horaSalida: [''],
      horaLlegada: [''],
      trayecto: [''],
      restricciones: [''],
      sugerencias: [''],
      // Alimentacion
      tipoComida: [''],
      // Alojamiento
      numHabitaciones: [''],
      numHuespedes: [''],
      extras: [''],
      // Otro
      tipoServicio: [''],
    });
  }

}
