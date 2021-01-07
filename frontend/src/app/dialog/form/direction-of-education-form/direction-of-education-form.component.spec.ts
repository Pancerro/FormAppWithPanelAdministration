import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DirectionOfEducationFormComponent } from './direction-of-education-form.component';

describe('DirectionOfEducationFormComponent', () => {
  let component: DirectionOfEducationFormComponent;
  let fixture: ComponentFixture<DirectionOfEducationFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DirectionOfEducationFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DirectionOfEducationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
