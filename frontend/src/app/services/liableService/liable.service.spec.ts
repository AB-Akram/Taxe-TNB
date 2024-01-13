import { TestBed } from '@angular/core/testing';

import { LiableService } from './liable.service';

describe('LiableService', () => {
  let service: LiableService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LiableService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
