import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HoursListComponent } from './hours-list.component';

describe('HoursListComponent', () => {
  let component: HoursListComponent;
  let fixture: ComponentFixture<HoursListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HoursListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HoursListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
