import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Api } from '../api';
import 'rxjs/add/operator/map';

@Injectable()
export class UsersService {

  constructor(private http: Http, private api: Api ) {
  }

  getActiveUser(): Observable<any> {
    return this.http.get(this.api.activeUser)
      .map(response => response.json())
  }

  registerNewProfile(user:any):Observable<any>{
    return this.http.post(this.api.registerUser, user)

  }
}
