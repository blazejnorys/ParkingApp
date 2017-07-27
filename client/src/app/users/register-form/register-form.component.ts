import { Component, OnInit } from '@angular/core';
import {UsersService} from "../users.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  constructor(private usersService:UsersService, private router:Router ) { }


  private profile = {
    profileDto: {
      name: '',
      surname: ''
    },
    login: '',
    password:''
  };

  loginError: boolean;


  register() {
    this.usersService.registerNewProfile(this.profile)
      .subscribe(() => {
          console.log(this.profile)
          this.router.navigateByUrl("/login")
        })
  }

  ngOnInit() {
  }



}
