
import {RouterModule} from "@angular/router";
import {LoginFormComponent} from "./security/login-form/login-form.component";
import {SecurityGuard} from "./security/security.guard";
import {RegisterFormComponent} from "./users/register-form/register-form.component";
import {HomePageComponent} from "./home/home-page/home-page.component";
import {ReservationPageComponent} from "./reservation/reservation-page/reservation-page.component";
import {ParkingComponent} from "./parking/parking-page/parking.component";
import {HoursListComponent} from "./reservation/hours-list/hours-list.component";


const routesConfig = [
  {
    path: 'reservation', component: ReservationPageComponent, canActivate: [SecurityGuard],
  },
  {
    path: 'register', component: RegisterFormComponent
  },
  {
    path: 'parking', component: ParkingComponent, canActivate: [SecurityGuard],
  },
  {
    path: 'newReservation/:id', component: HoursListComponent,  canActivate: [SecurityGuard]
  },
  {
    path: 'home', component: HomePageComponent,
  },
  {
    path: '**', redirectTo:'home', //canActivate :[SecurityGuard]
  }
]
// jak bedzie w adresie login to zrenderuje nam sie login form cponent
export const routerModule  = RouterModule.forRoot(routesConfig)
