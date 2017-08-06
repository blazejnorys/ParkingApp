import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ParkingComponent } from './parking-page/parking.component';
import {RouterModule} from "@angular/router";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {ReservationModule} from "../reservation/reservation.module";
import {ParkingMapComponent} from "./parking-map/parking-map.component";

@NgModule({
  imports: [
    CommonModule,
    HttpModule,
    FormsModule,
    RouterModule,
    ReservationModule
  ],
  exports:[ParkingComponent, ParkingMapComponent],
  declarations: [ParkingComponent, ParkingMapComponent]
})
export class ParkingModule { }
