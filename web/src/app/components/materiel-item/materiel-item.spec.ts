import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaterielItem } from './materiel-item';

describe('MaterielItem', () => {
  let component: MaterielItem;
  let fixture: ComponentFixture<MaterielItem>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MaterielItem]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MaterielItem);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
