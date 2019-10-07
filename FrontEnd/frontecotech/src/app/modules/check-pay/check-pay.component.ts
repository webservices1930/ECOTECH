import { Component, OnInit } from '@angular/core';
import { del } from 'selenium-webdriver/http';
import { delay } from 'q';

@Component({
  selector: 'app-check-pay',
  templateUrl: './check-pay.component.html',
  styleUrls: ['./check-pay.component.css']
})
export class CheckPayComponent implements OnInit {

  private messages = "Su Pago fue Exitoso"

  constructor() { }

  ngOnInit() {
  }

  message(){
    delay(3000);
    alert(this.messages);
  }

}
