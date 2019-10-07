import { Component, OnInit } from '@angular/core';
import { del } from 'selenium-webdriver/http';
import { delay } from 'q';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-check-pay',
  templateUrl: './check-pay.component.html',
  styleUrls: ['./check-pay.component.css']
})
export class CheckPayComponent implements OnInit {

  private messages = "Su Pago fue Exitoso"
  valor:number = 0;

  constructor(private cookieService: CookieService) { }

  ngOnInit() {
    this.valor = Number(this.cookieService.get("costo"));
  }

  message(){
    alert(this.messages);
    this.cookieService.deleteAll();
    this.cookieService.set('count', '0');
  }

}
