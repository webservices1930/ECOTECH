import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { count } from 'rxjs/operators';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  carrito:string;

  constructor(private cookieService: CookieService) { }

  ngOnInit() {
    this.carrito = this.cookieService.get("count");
  }

}
