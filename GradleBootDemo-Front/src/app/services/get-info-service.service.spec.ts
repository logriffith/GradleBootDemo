import { TestBed } from '@angular/core/testing';

import { GetInfoServiceService } from './get-info-service.service';

describe('GetInfoServiceService', () => {
  let service: GetInfoServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetInfoServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
