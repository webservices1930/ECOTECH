import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './modules/login/login.component';
import { SignupComponent } from './modules/signup/signup.component';

import { ServicesListComponent } from './modules/services-list/services-list.component';
import { DetailsComponent } from './modules/details/details.component';

import { ShopCarComponent} from './modules/shop-car/shop-car.component';

import { CreateServiceComponent } from './modules/create-service/create-service.component';
import { CheckPayComponent } from './modules/check-pay/check-pay.component';





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

  {path: 'shopCar', component: ShopCarComponent },
  {path: 'check', component: CheckPayComponent },

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
