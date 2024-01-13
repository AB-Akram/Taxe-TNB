import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TnbTaxListComponent } from './tnb-tax-list.component';

describe('TnbTaxListComponent', () => {
  let component: TnbTaxListComponent;
  let fixture: ComponentFixture<TnbTaxListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TnbTaxListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TnbTaxListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
