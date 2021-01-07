import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddOrEditUniversityCoursesModalComponent } from './add-or-edit-university-courses-modal.component';

describe('AddOrEditUniversityCoursesModalComponent', () => {
  let component: AddOrEditUniversityCoursesModalComponent;
  let fixture: ComponentFixture<AddOrEditUniversityCoursesModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddOrEditUniversityCoursesModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddOrEditUniversityCoursesModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
