import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Api} from "../api";
import {Observable} from "rxjs/Observable";
@Injectable()
export class ParkingService {

  constructor(private http: Http, private api: Api ) {
  }

  getAllParkings(): Observable<any> {
    return this.http.get(this.api.parkingPage)
      .map(response => response.json())
  }


}
