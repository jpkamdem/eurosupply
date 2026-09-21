import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Nourishment } from './nourishment';

describe('Nourishment', () => {
  let component: Nourishment;
  let fixture: ComponentFixture<Nourishment>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Nourishment]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Nourishment);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
