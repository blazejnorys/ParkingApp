import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ParkingComponent } from './parking-page/parking.component';
import {RouterModule} from "@angular/router";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {ReservationModule} from "../reservation/reservation.module";

@NgModule({
  imports: [
    CommonModule,
    HttpModule,
    FormsModule,
    RouterModule,
    ReservationModule
  ],
  exports:[ParkingComponent],
  declarations: [ParkingComponent]
})
export class ParkingModule { }
