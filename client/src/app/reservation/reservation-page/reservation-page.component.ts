import { Component, OnInit } from '@angular/core';
import {ReservationService} from "../reservation.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-reservation-page',
  templateUrl: './reservation-page.component.html',
  styleUrls: ['./reservation-page.component.css']
})
export class ReservationPageComponent implements OnInit {

  constructor(private reservationService : ReservationService, private router: Router) { }

  private reservation = {

      beginDate: '',
      endDate: '',
  };


  ngOnInit() {
    this.reservationService.getAllReservation().subscribe(reservationPage => this.reservations = reservationPage.reservations)
  }

  addReservation() {
    this.reservationService.addNewReservation(this.reservation)
      .subscribe(() => {
        console.log(this.reservation)
        this.router.navigateByUrl("/reservation")
      })
  }
  reservations = []
}
