import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Client } from 'ngx-soap';
import { SoapService } from '../../services/soap.service';
import { Router } from '@angular/router';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { User } from '../../models/user.model';
import { CookieService } from 'ngx-cookie-service';


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
    private router: Router,
    private cookieService: CookieService
  ) { }

  userForm: FormGroup;

  ngOnInit() {
    this.buildUserForm();
    this.cookieService.deleteAll();
    this.cookieService.set('count', '0');
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
              const userToSave = result.result.return;
              localStorage.setItem('user', JSON.stringify(userToSave));
              this.router.navigate(['/profile']);
            }
          );
        } else {
          alert('Usuario o contraseña incorrecto.');
        }
      });
    });

  }
}
