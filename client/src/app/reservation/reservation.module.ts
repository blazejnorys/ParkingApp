import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservationPageComponent } from './reservation-page/reservation-page.component';
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {RouterModule} from "@angular/router";
import { HoursListComponent } from './hours-list/hours-list.component';
import { NewReservationComponent } from './new-reservation/new-reservation.component';
import { ParkingMapComponent } from '../parking/parking-map/parking-map.component';
import {AgmCoreModule} from "@agm/core";

@NgModule({
  imports: [
    CommonModule,
    HttpModule,
    FormsModule,
    RouterModule
  ],
  exports: [ReservationPageComponent,HoursListComponent, NewReservationComponent],
  declarations: [ReservationPageComponent, HoursListComponent, NewReservationComponent]
})
export class ReservationModule { }
