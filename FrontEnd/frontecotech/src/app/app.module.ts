import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './modules/login/login.component';
import { ProfileComponent } from './modules/profile/profile.component';
import { NgxSoapModule } from 'ngx-soap';
import {CookieService} from 'ngx-cookie-service'

import { ServicesListComponent } from './modules/services-list/services-list.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SignupComponent } from './modules/signup/signup.component';
import { DetailsComponent } from './modules/details/details.component';
import { ShopCarComponent } from './modules/shop-car/shop-car.component';
import { CreateServiceComponent } from './modules/create-service/create-service.component';
import { CheckPayComponent } from './modules/check-pay/check-pay.component';

import { NavbarComponent } from './modules/navbar/navbar.component';
import { NotfoundComponent } from './modules/notfound/notfound.component';
import { GoogleMapsModule } from '@angular/google-maps';
import { HttpClient } from 'selenium-webdriver/http';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProfileComponent,
    SignupComponent,
    ServicesListComponent,
    DetailsComponent,
    ShopCarComponent,
    CheckPayComponent,
    CreateServiceComponent,
    NavbarComponent,
    NotfoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxSoapModule,
    FormsModule,
    ReactiveFormsModule,
    GoogleMapsModule,
    HttpClientModule
  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
