import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ReservationService} from "../reservation.service";
import {UsersService} from "../../users/users.service";

@Component({
  selector: 'app-hours-list',
  templateUrl: './hours-list.component.html',
  styleUrls: ['./hours-list.component.css']
})
export class HoursListComponent {

  private id;
  private activeUser;

  private reservation = {
    parking: {
      id: -1,
      location:"",
      name:"",
      slots:""
    },
    profile: {
      id: -1,//this.activeUser.id,
      name:"",
      surname:""
    },
    beginDate: "2017-07-28T09:26:48.566Z",
    endDate: "2017-07-28T09:26:48.566Z"
  }

  constructor(private reservationService: ReservationService, private usersService: UsersService, private router: Router, private route: ActivatedRoute) {
    this.id = this.route.snapshot.paramMap.get('id');
    this.activeUser = usersService.getActiveUser();
  }

  addReservation() {
    console.log(this.reservation)
    this.reservation.parking.id = this.id
    this.reservation.profile.id = this.activeUser.id
    this.reservationService.addNewReservation(this.reservation)
      .subscribe(() => {
        console.log(this.reservation)
        this.router.navigateByUrl("")
      }, () => {
        console.log('failed')
      })


  }
}
