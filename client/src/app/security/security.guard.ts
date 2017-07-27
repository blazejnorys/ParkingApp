

import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {SecurityService} from "./security.service";

@Injectable()
export class SecurityGuard implements CanActivate{
  constructor(private router: Router, private  securityService: SecurityService){

  }

  canActivate(route:ActivatedRouteSnapshot, state: RouterStateSnapshot):boolean {
    if(this.securityService.isAuthenticated()){
      return true
    }else{
      this.router.navigate(['login'])//nawias kwadratowy, element tablicy bo sie sklada z kilku elemnetu
      //mozna zastapiac byurl
      return false
    }
}
}
