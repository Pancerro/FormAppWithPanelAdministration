import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LaborMarketStatusFormComponent } from './labor-market-status-form.component';

describe('LaborMarketStatusFormComponent', () => {
  let component: LaborMarketStatusFormComponent;
  let fixture: ComponentFixture<LaborMarketStatusFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LaborMarketStatusFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LaborMarketStatusFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
