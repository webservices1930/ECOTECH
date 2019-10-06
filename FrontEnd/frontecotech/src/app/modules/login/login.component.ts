import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../../models/user.model';
import { SoapService } from '../../services/soap.service';
import { Client } from 'ngx-soap';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

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
      nickname: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  login() {
    const user = this.userForm.value as User;
    console.log(user);
    this.soapService.client.then( client => {
      this.userService.login(user.nickname, user.password, client as Client ).subscribe(res => {
        console.log('Login enviado');
        const credentialsCorrect = res.result.return;
        console.log(credentialsCorrect);
        if (res.result.return) {
          this.userService.getUserByNickName(user.nickname, client as  Client).subscribe(
            result => {
              let userToSave = result.result.return;
              console.log(userToSave);
            }
          );
        } else {
          alert('Usuario o contraseña incorrecto.');
        }
      });
    });

  }
}
