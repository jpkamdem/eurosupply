import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Aliments } from './aliments';

describe('Aliments', () => {
  let component: Aliments;
  let fixture: ComponentFixture<Aliments>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Aliments]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Aliments);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
