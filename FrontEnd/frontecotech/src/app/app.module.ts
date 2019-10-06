import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './modules/login/login.component';
import { ProfileComponent } from './modules/profile/profile.component';
import { NgxSoapModule } from 'ngx-soap';

import { ServicesListComponent } from './modules/services-list/services-list.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SignupComponent } from './modules/signup/signup.component';
import { DetailsComponent } from './modules/details/details.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProfileComponent,
    SignupComponent,
    ServicesListComponent,
    DetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxSoapModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
