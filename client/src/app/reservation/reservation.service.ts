import {Observable} from "rxjs/Observable";
import {Api} from "../api";
import {Http} from "@angular/http";
import {Injectable} from "@angular/core";


@Injectable()
export class Reservationservice {

  constructor(private http: Http, private api: Api ) {
  }

  getAllReservation(): Observable<any> {
    return this.http.get(this.api.reservationPage)
      .map(response => response.json())
  }

  addNewReservation(user:any):Observable<any>{
    return this.http.post(this.api.reservationPage, user)

  }
}
