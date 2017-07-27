import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpModule } from '@angular/http';
import {FormsModule} from "@angular/forms";
import {RegisterFormComponent} from "./register-form/register-form.component";

@NgModule({
  imports: [
    CommonModule,
    HttpModule,
    FormsModule
  ],
  exports:[RegisterFormComponent],
  declarations: [RegisterFormComponent]
})
export class UsersModule { }
