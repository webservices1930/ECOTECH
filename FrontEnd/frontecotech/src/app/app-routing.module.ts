import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './modules/login/login.component';
import { ProfileComponent } from './modules/profile/profile.component';
import { SignupComponent } from './modules/signup/signup.component';

import { ServicesListComponent } from './modules/services-list/services-list.component';
import { DetailsComponent } from './modules/details/details.component';
import { CreateServiceComponent } from './modules/create-service/create-service.component';
import { RoleGuardService } from './auth/role-guard.service';




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
    path: 'services',
    component: ServicesListComponent,
    canActivate: [RoleGuardService],
    data: { rol: 'CLIENTE' }
  },
  {path: 'details/:id', component: DetailsComponent },
  {
    path: 'create-service',
    component: CreateServiceComponent,
    canActivate: [RoleGuardService],
    data: { rol: 'PROVEEDOR' }
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
