import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddOrEditMemberModalComponent } from './add-or-edit-member-modal.component';

describe('EditMemberModalComponent', () => {
  let component: AddOrEditMemberModalComponent;
  let fixture: ComponentFixture<AddOrEditMemberModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddOrEditMemberModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddOrEditMemberModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
