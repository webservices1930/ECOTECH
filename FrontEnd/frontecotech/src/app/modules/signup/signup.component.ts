import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { SoapService } from '../../services/soap.service';
import { Router } from '@angular/router';
import { Client } from 'ngx-soap';
import { User } from '../../models/user.model';

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private soapService: SoapService,
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
    });
  }
  signup() {
    const userToCreate = this.userForm.value as User;
    this.soapService.client.then( client => {
      this.userService.createUser(userToCreate, client as Client).subscribe( res => {

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

}
