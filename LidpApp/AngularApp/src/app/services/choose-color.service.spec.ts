import { TestBed } from '@angular/core/testing';

import { ChooseColorService } from './choose-color.service';

describe('ChooseColorService', () => {
  let service: ChooseColorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChooseColorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
