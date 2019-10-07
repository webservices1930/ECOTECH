import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './modules/login/login.component';
import { NgxSoapModule } from 'ngx-soap';
import {CookieService} from 'ngx-cookie-service'

import { ServicesListComponent } from './modules/services-list/services-list.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SignupComponent } from './modules/signup/signup.component';
import { DetailsComponent } from './modules/details/details.component';
import { ShopCarComponent } from './modules/shop-car/shop-car.component';
import { CreateServiceComponent } from './modules/create-service/create-service.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    ServicesListComponent,
    DetailsComponent,
    ShopCarComponent,
    CreateServiceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxSoapModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
