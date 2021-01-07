import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddOrEditProjectComponent } from './add-or-edit-project.component';

describe('AddOrEditProjectComponent', () => {
  let component: AddOrEditProjectComponent;
  let fixture: ComponentFixture<AddOrEditProjectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddOrEditProjectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddOrEditProjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
