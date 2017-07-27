import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UsersModule } from './users/users.module';
import { SecurityService } from './security/security.service';
import { UsersService } from './users/users.service';
import { Api } from './api';
import {SecurityModule} from "./security/security.module";
import {routerModule} from "./app.routing";
import {SecurityGuard} from "./security/security.guard";
import {HomeModule} from "./home/home.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    UsersModule,
    SecurityModule,
    HomeModule,
    routerModule

  ],
  providers: [
    SecurityService,
    Api,
    SecurityGuard,
    UsersService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
