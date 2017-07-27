
import {RouterModule} from "@angular/router";
import {LoginFormComponent} from "./security/login-form/login-form.component";
import {SecurityGuard} from "./security/security.guard";
import {RegisterFormComponent} from "./users/register-form/register-form.component";
import {HomePageComponent} from "./home/home-page/home-page.component";


const routesConfig = [
  {
    path: 'login', component: LoginFormComponent
  },
  {
    path: 'register', component: RegisterFormComponent
  },
  {
    path: 'home', component: HomePageComponent, canActivate: [SecurityGuard]
  },
  {
    path: '**', redirectTo:'login', //canActivate :[SecurityGuard]
  }
]
// jak bedzie w adresie login to zrenderuje nam sie login form cponent
export const routerModule  = RouterModule.forRoot(routesConfig)
