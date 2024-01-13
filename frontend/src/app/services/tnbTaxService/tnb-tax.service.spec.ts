import { TestBed } from '@angular/core/testing';

import { TnbTaxService } from './tnb-tax.service';

describe('TnbTaxService', () => {
  let service: TnbTaxService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TnbTaxService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
