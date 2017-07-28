import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UsersModule } from './users/users.module';
import { SecurityService } from './security/security.service';
import { UsersService } from './users/users.service';
import { Api } from './api';
import {SecurityModule} from "./security/security.module";
import {routerModule} from "./app.routing";
import {SecurityGuard} from "./security/security.guard";
import {HomeModule} from "./home/home.module";
import {Reservationservice} from "./reservation/reservation.service";
import {ReservationModule} from "./reservation/reservation.module";
import {ParkingModule} from "./parking/parking.module";
import {ParkingService} from "./parking/parking.service";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    UsersModule,
    SecurityModule,
    HomeModule,
    routerModule,
    ReservationModule,
    ParkingModule

  ],
  providers: [
    SecurityService,
    Api,
    SecurityGuard,
    UsersService,
    Reservationservice,
    ParkingService,

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
