import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicItem } from './medic-item';

describe('MedicItem', () => {
  let component: MedicItem;
  let fixture: ComponentFixture<MedicItem>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MedicItem]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MedicItem);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
