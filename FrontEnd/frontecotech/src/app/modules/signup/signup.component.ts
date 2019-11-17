import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { UserService } from '../../services/user.service';

import { Router } from '@angular/router';
import { Client } from 'ngx-soap';
import { User, Cliente, Proveedor } from '../../models/user.model';

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  options = [
    {id: 1, name: 'PROVEEDOR'},
    {id: 2, name: 'CLIENTE'},
  ];

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private router: Router
  ) { }
  userForm: FormGroup;
  ngOnInit() {
    this.buildUserForm();
  }


  private buildUserForm() {
    this.userForm = this.formBuilder.group({
      nombre: ['', [Validators.required]],
      descripcion: ['', [Validators.required]],
      correo: ['', [Validators.required]],
      fechaNacimiento: ['', [Validators.required]],
      nickname: ['', [Validators.required]],
      password: ['', [Validators.required]],
      foto: [''],
      rolUsuario: [''],
      di: [''],
      usuarioTwitter: [''],
      usuarioFacebook: [''],
      usuarioInstagram: [''],
      web: [''],
      telefono: [''],
      selectedValue: ['', [Validators.required]],
    });
  }

  signup() {
    /*
    if (this.userForm.value.selectedValue === '2') {
      this.userForm.value.rolUsuario = 'CLIENTE';
      const clientToCreate = this.userForm.value as Cliente;

      this.userService.createClient(clientToCreate).subscribe( res => {
        if ( res.result != null ) {
          alert('Usuario creado');
          this.router.navigate(['/login']);
        } else {
            alert('Nickname ya existe.');
        }
      }, error => {
        alert('Nickname ya existe.');
      });


    }

    if (this.userForm.value.selectedValue === '1') {
      this.userForm.value.rolUsuario = 'PROVEEDOR';
      const providerToCreate = this.userForm.value as Proveedor;
      this.soapService.client.then( client => {
        this.userService.createProveedor(providerToCreate, client as Client).subscribe( res => {
          if ( res.result != null ) {
            alert('Usuario creado');
            this.router.navigate(['/login']);
          } else {
              alert('Nickname ya existe.');
          }
        }, error => {
          alert('Nickname ya existe.');
        });
      });
    }
    */
   const userToCreate = this.userForm.value as User;
   if (this.userForm.value.selectedValue === '1') {
     this.userForm.value.rolUsuario = 'PROVEEDOR';
   }

   if (this.userForm.value.selectedValue === '2') {
     this.userForm.value.rolUsuario = 'CLIENTE';
   }

   this.userService.createUser(userToCreate).subscribe( res => {
     alert('Usuario creado');
     this.router.navigate(['/login']);

   }, error => {
     alert('Nickname ya existe.');
   });

  }

}
