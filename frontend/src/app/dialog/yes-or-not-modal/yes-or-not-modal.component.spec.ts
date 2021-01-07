import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YesOrNotModalComponent } from './yes-or-not-modal.component';

describe('YesOrNotModalComponent', () => {
  let component: YesOrNotModalComponent;
  let fixture: ComponentFixture<YesOrNotModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YesOrNotModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YesOrNotModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
