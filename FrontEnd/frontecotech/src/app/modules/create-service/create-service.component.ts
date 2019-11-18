import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ServiceService } from '../../services/service.service';
import { Router } from '@angular/router';
import { TypeService, Service, Alimentacion, Alojamiento, Otro, Paseo, Transporte } from '../../models/service';
import { toArray } from 'rxjs/operators';
import { Client } from 'ngx-soap';
import { Pais } from 'src/app/models/pais';

@Component({
  selector: 'app-create-service',
  templateUrl: './create-service.component.html',
  styleUrls: ['./create-service.component.scss']
})
export class CreateServiceComponent implements OnInit {

  paises: Array<Pais>;
  pais: Pais;

  constructor(
    private formBuilder: FormBuilder,
    private serviceService: ServiceService,
    private router: Router,
    private service: ServiceService
  ) { }

  serviceForm: FormGroup;
  public typeService = [];

  ngOnInit() {
    this.buildServiceForm();
    this.typeService = Object.keys(TypeService).map(k => TypeService[k]);
    this.typeService.splice(5);
    console.log(this.typeService);
    this.service.getDeltailsCountri().subscribe(res => {
      this.paises = res;
      console.log('_----------------------');
      console.log(this.paises);

    });
  }

  goodAction() {
    alert('Creado correctamente.');
    this.router.navigate(['/services']);
  }

  createService() {
    this.serviceForm.value.tipo = this.serviceForm.value.tipo.toUpperCase();
    const service = this.serviceForm.value as Service;
    const s: string = this.serviceForm.get('fotos').value;
    console.log(s);
    service.fotos = [];
    service.fotos.push(s);
    service.pais = this.pais;
    console.log(service);
    console.log(TypeService.Alimentacion.toString());

    /*

    -------------BEFORE
    if (service.tipo == null) {
      this.serviceService.createService(client, service).subscribe( res => {
        this.goodAction();
      });
    } else if (service.tipo === 'Alimentacion'.toUpperCase()) {
      const alimentacion = this.serviceForm.value as Alimentacion;
      this.serviceService.createServiceAlimentacion(client, alimentacion).subscribe(res => {
        this.goodAction();
      });
    } else if (service.tipo === 'Alojamiento'.toUpperCase()) {
      const alojamiento = this.serviceForm.value as Alojamiento;
      this.serviceService.createServiceAlojamiento(client, alojamiento).subscribe(res => {
        this.goodAction();
      });
    } else if (service.tipo === 'Otro'.toUpperCase()) {
      const otro = this.serviceForm.value as Otro;
      this.serviceService.createServiceOtro(client, otro).subscribe(res => {
        this.goodAction();
      });
    } else if (service.tipo === 'Paseo'.toUpperCase()) {
      const paseo = this.serviceForm.value as Paseo;
      this.serviceService.createServicePaseo(client, paseo).subscribe(res => {
        this.goodAction();
      });
    } else if (service.tipo === 'Transporte'.toUpperCase()) {
      const transporte = this.serviceForm.value as Transporte;
      this.serviceService.createServiceTransporte(client, transporte).subscribe(res => {
        this.goodAction();
      });
    }*/

    this.serviceService.createService(service).subscribe(res => {
      this.goodAction();
    });
  }

  searchCountry(event: any) {
    console.log(event.target.value);
    this.pais = this.paises[event.target.value];
    console.log(this.pais);
  }


  private buildServiceForm() {
    this.serviceForm = this.formBuilder.group({
      nombre: ['', [Validators.required]],
      // tipo: ['', ],
      descripcion: ['', [Validators.required]],
      contacto: ['', [Validators.required]],
      costo: ['', [Validators.required]],
      latitud: ['', [Validators.required]],
      longitud: ['', [Validators.required]],
      fotos: ['', [Validators.required]],
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
