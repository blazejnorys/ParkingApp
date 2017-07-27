import { Component, OnInit } from '@angular/core';
import {SecurityService} from "../../security/security.service";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private securityService: SecurityService) { }

  ngOnInit() {
  }

  logout(){
    this.securityService.logout();
  }

}
