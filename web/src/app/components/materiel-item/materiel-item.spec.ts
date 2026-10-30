import { beforeEach, describe, expect, it } from 'vitest';

import { provideHttpClient } from '@angular/common/http';
import { provideZonelessChangeDetection } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MaterielItem } from './materiel-item';

describe('MaterielItem', () => {
  let component: MaterielItem;
  let fixture: ComponentFixture<MaterielItem>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MaterielItem],
      providers: [
        provideZonelessChangeDetection(),
        provideHttpClient()
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(MaterielItem);
    component = fixture.componentInstance;

    fixture.componentRef.setInput('id', 1)
    fixture.componentRef.setInput('name', 'Marteau')
    fixture.componentRef.setInput('quantity', 5)

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
