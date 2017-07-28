import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomePageComponent } from './home-page/home-page.component';
import {RouterModule} from "@angular/router";
import { NavbarComponent } from './navbar/navbar.component';
import {SecurityModule} from "../security/security.module";

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    SecurityModule
  ],
  exports:[HomePageComponent, NavbarComponent],

  declarations: [HomePageComponent, NavbarComponent]
})
export class HomeModule { }
