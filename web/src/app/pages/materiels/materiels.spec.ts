import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Materiels } from './materiels';

describe('Materiels', () => {
  let component: Materiels;
  let fixture: ComponentFixture<Materiels>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Materiels]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Materiels);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
