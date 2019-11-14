import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { count } from 'rxjs/operators';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  carrito: string;

  constructor(
    private cookieService: CookieService,
    public userService: UserService,
    private router: Router,
  ) { }

  ngOnInit() {
    this.carrito = this.cookieService.get('count');
  }

  logout() {
    this.userService.logout();
    this.router.navigate(['/']);
  }

}
