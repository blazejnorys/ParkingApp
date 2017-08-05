import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParkingMapComponent } from './parking-map.component';

describe('ParkingMapComponent', () => {
  let component: ParkingMapComponent;
  let fixture: ComponentFixture<ParkingMapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParkingMapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParkingMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
