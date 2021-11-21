import { TestBed } from '@angular/core/testing';

import { UpdateFavoriteService } from './update-favorite.service';

describe('UpdateFavoriteService', () => {
  let service: UpdateFavoriteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateFavoriteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
