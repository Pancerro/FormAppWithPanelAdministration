import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddOrEditUniversityDepartmentsModalComponent } from './add-or-edit-university-departments-modal.component';

describe('AddOrEditUniversityDepartmentsModalComponent', () => {
  let component: AddOrEditUniversityDepartmentsModalComponent;
  let fixture: ComponentFixture<AddOrEditUniversityDepartmentsModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddOrEditUniversityDepartmentsModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddOrEditUniversityDepartmentsModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
