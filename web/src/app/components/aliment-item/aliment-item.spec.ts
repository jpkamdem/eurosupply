import { beforeEach, describe, expect, it } from 'vitest';

import { provideHttpClient } from '@angular/common/http';
import { provideZonelessChangeDetection } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AlimentItem } from './aliment-item';

describe('AlimentItem', () => {
  let component: AlimentItem;
  let fixture: ComponentFixture<AlimentItem>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlimentItem],
      providers: [
        provideZonelessChangeDetection(),
        provideHttpClient()
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(AlimentItem);
    component = fixture.componentInstance;

    fixture.componentRef.setInput('id', 1);
    fixture.componentRef.setInput('name', 'Pommes');
    fixture.componentRef.setInput('quantity', 5);
    fixture.componentRef.setInput('expiration', new Date());
    fixture.componentRef.setInput('unit', 'kg');

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
