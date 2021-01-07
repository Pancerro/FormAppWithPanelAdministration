import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditSaveToProjectComponent } from './edit-save-to-project.component';

describe('EditSaveToProjectComponent', () => {
  let component: EditSaveToProjectComponent;
  let fixture: ComponentFixture<EditSaveToProjectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditSaveToProjectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditSaveToProjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
