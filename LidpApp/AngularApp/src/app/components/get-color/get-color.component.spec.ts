import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetColorComponent } from './get-color.component';

describe('GetColorComponent', () => {
  let component: GetColorComponent;
  let fixture: ComponentFixture<GetColorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetColorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetColorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
