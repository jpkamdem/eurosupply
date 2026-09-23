import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlimentItem } from './aliment-item';

describe('AlimentItem', () => {
  let component: AlimentItem;
  let fixture: ComponentFixture<AlimentItem>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlimentItem]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlimentItem);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
