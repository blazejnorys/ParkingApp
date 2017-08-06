///<reference path="../../../../node_modules/@types/googlemaps/index.d.ts"/>
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parking-map',
  templateUrl: './parking-map.component.html',
  styleUrls: ['./parking-map.component.css'],

})

export class ParkingMapComponent  implements OnInit{

  ngOnInit() {

    var mapProp = {
      center: new google.maps.LatLng(52.229833, 21.011643),
      zoom: 11,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);

    setMarkers(map);

  }

}
var parkingList = [
  ["Parking u Joli",52.237596, 20.969286,1,"8 pln/hr","00-24"],
  ["Parking dla najszybszych",52.215387, 20.971774,2,"6 pln/hr","8-22"],
  ["Parking przy kebabie",52.207982, 21.051864,3,"5 pln/hr","6-22"],
  ["Parking JakoTaki",52.249894, 21.06886,4,"4 pln/hr","10-20"],
  ["Parking Zawsze pełny",52.193878, 21.026892,5,"3 pln/hr","10-14"]
];


function setMarkers(map){

  for (var i=0; i<parkingList.length;i++){
    var parking = parkingList[i];
    var marker = new google.maps.Marker({
      position: {lat: +parking[1], lng: +parking[2]},
      map: map,
      label: String(parking[3]),
      title: String(parking[0]),
      animation: google.maps.Animation.DROP

    });
    buildInfoWindow(marker,map,parking);
  }
}

function buildInfoWindow(marker,map,parking) {
  var contentString =
    '<div id="content">' +
    '<div id="siteNotice">' +
    '</div>' +
    '<h6 id="firstHeading" class="firstHeading">' + String(parking[0])  + '</h6>' +
    '<br id="bodyContent" >' + 'Price: ' + String(parking[4])+
    '<br>'+'Opening hours: '+ String(parking[5])+'</br>'+
    '</div>' +
    '</div>';

  var infowindow = new google.maps.InfoWindow({
    content: contentString
  });
  marker.addListener('click', function () {
    infowindow.open(map, marker);

    setTimeout(function () { infowindow.close(); }, 4000);

  });
}
