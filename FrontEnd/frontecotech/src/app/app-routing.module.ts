import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './modules/login/login.component';
import { ServicesListComponent } from './modules/services-list/services-list.component';
import { DetailsComponent } from './modules/details/details.component';


const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'services', component: ServicesListComponent },
  {path: 'details/:id', component: DetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
