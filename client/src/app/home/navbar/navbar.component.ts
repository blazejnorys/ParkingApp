import { Component, OnInit } from '@angular/core';
import {SecurityService} from "../../security/security.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private securityService: SecurityService ) { }

  ngOnInit() {
  }

}
