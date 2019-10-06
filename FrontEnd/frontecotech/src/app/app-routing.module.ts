import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './modules/login/login.component';
import { SignupComponent } from './modules/signup/signup.component';

import { ServicesListComponent } from './modules/services-list/services-list.component';
import { DetailsComponent } from './modules/details/details.component';
import { CreateServiceComponent } from './modules/create-service/create-service.component';




const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'signup',
    component: SignupComponent
  },
  {path: 'services', component: ServicesListComponent },
  {path: 'details/:id', component: DetailsComponent },
  {
    path: 'create-service',
    component: CreateServiceComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
