import { Injectable } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot, CanActivate } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class RoleGuardService implements CanActivate {
  path: ActivatedRouteSnapshot[];
  route: ActivatedRouteSnapshot;


  constructor(private userService: UserService, private router: Router) {
  }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return this.userService.decode().pipe(map(user => {
      if (user == null) {
        // navigate to not found page
        this.router.navigate(['/404']);
        return false;
      }
      /*
      if (next.data.role === '*' || user.role === 'ADMIN' || user.role === next.data.role) {
        return true;
      }*/
      // navigate to not found page
      this.router.navigate(['/404']);
      return false;
    }));
  }

}
