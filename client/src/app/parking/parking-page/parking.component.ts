import { Component, OnInit } from '@angular/core';
import {ParkingService} from "../parking.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-parking',
  templateUrl: './parking.component.html',
  styleUrls: ['./parking.component.css']
})
export class ParkingComponent implements OnInit {


  parkings=[];
  constructor(private parkingService : ParkingService, private router: Router) { }

  ngOnInit() {
    this.parkingService.getAllParkings().subscribe(parkingPage => this.parkings = parkingPage.parkings)
  }

}
