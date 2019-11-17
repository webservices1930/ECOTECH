import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './modules/login/login.component';
import { ProfileComponent } from './modules/profile/profile.component';
import { SignupComponent } from './modules/signup/signup.component';

import { ServicesListComponent } from './modules/services-list/services-list.component';
import { DetailsComponent } from './modules/details/details.component';

import { ShopCarComponent} from './modules/shop-car/shop-car.component';

import { CreateServiceComponent } from './modules/create-service/create-service.component';
import { RoleGuardService } from './auth/role-guard.service';
import { NotfoundComponent } from './modules/notfound/notfound.component';
import { CheckPayComponent } from './modules/check-pay/check-pay.component';
import {NewsComponent} from './modules/news/news.component';





const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'profile',
    component: ProfileComponent,
    canActivate: [RoleGuardService],
    data: { rol: '*' }
  },
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'news',
    component: NewsComponent
  },
  {
    path: 'services',
    component: ServicesListComponent,
    canActivate: [RoleGuardService],
    data: { rol: '*' }
  },
  {
    path: 'shopCar',
     component: ShopCarComponent,
    canActivate: [RoleGuardService],
    data: { rol: 'CLIENTE' }
  },
  {
    path: 'check',
     component: CheckPayComponent,
    canActivate: [RoleGuardService],
    data: { rol: 'CLIENTE' }
  },
  {
    path: 'details/:id',
     component: DetailsComponent,
     canActivate: [RoleGuardService],
    data: { rol: '*' }
  },
  {
    path: 'create-service',
    component: CreateServiceComponent,
    canActivate: [RoleGuardService],
    data: { rol: 'PROVEEDOR' }
  },
  {
    path: '**',
    component: NotfoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
