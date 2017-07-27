import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginFormComponent } from './login-form/login-form.component';
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";

@NgModule({
  imports: [CommonModule, HttpModule, FormsModule],
  exports :[LoginFormComponent],
  declarations: [LoginFormComponent]
})
export class SecurityModule { }
