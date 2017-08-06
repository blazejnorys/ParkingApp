///<reference path="../../../../node_modules/@types/googlemaps/index.d.ts"/>
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parking-map',
  templateUrl: './parking-map.component.html',
  styleUrls: ['./parking-map.component.css']
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
  ["Parking u Joli",52.237596, 20.969286],
  ["Parking dla najszybszych",52.215387, 20.971774],
  ["Parking przy kebabie",52.207982, 21.051864],
  ["Parking JakoTaki",52.249894, 21.06886],
  ["Parking Zawsze pełny",52.193878, 21.026892]
];


function setMarkers(map){

  for (var i=0; i<parkingList.length;i++){
    var parking = parkingList[i];
    var marker = new google.maps.Marker({
      position: {lat: +parking[1], lng: +parking[2]},
      map: map,
      title: String(parking[0]),
      animation: google.maps.Animation.DROP

    });
    marker.addListener('click', function() {
      infowindow.open(map, marker);
    });


  }
}

var contentString = '<div id="content">'+
  '<div id="siteNotice">'+
  '</div>'+
  '<h1 id="firstHeading" class="firstHeading">Uluru</h1>'+
  '<div id="bodyContent">'+
  '<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large ' +
  'sandstone rock formation in the southern part of the '+
  'Northern Territory, central Australia. It lies 335&#160;km (208&#160;mi) '+
  'south west of the nearest large town, Alice Springs; 450&#160;km '+
  '(280&#160;mi) by road. Kata Tjuta and Uluru are the two major '+
  'features of the Uluru - Kata Tjuta National Park. Uluru is '+
  'sacred to the Pitjantjatjara and Yankunytjatjara, the '+
  'Aboriginal people of the area. It has many springs, waterholes, '+
  'rock caves and ancient paintings. Uluru is listed as a World '+
  'Heritage Site.</p>'+
  '<p>Attribution: Uluru, <a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">'+
  'https://en.wikipedia.org/w/index.php?title=Uluru</a> '+
  '(last visited June 22, 2009).</p>'+
  '</div>'+
  '</div>';
var infowindow = new google.maps.InfoWindow({
  content: contentString
});
