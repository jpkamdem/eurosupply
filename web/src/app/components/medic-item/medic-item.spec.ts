import { beforeEach, describe, expect, it } from 'vitest';

import { provideHttpClient } from '@angular/common/http';
import { provideZonelessChangeDetection } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MedicItem } from './medic-item';

describe('MedicItem', () => {
  let component: MedicItem;
  let fixture: ComponentFixture<MedicItem>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MedicItem],
      providers: [
        provideZonelessChangeDetection(),
        provideHttpClient()
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(MedicItem);
    component = fixture.componentInstance;

    fixture.componentRef.setInput('id', 1);
    fixture.componentRef.setInput('name', 'Médicament');
    fixture.componentRef.setInput('quantity', 5);
    fixture.componentRef.setInput('expiration', new Date());

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
