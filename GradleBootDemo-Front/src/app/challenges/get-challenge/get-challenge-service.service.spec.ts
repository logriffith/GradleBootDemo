import { TestBed } from '@angular/core/testing';

import { GetChallengeServiceService } from './get-challenge-service.service';

describe('GetChallengeServiceService', () => {
  let service: GetChallengeServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetChallengeServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
