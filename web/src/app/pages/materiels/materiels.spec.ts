import { beforeEach, describe, expect, it } from 'vitest';

import { provideHttpClient } from '@angular/common/http';
import { provideZonelessChangeDetection } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideRouter } from '@angular/router';
import { routes } from '../../app.routes';
import { Materiels } from './materiels';

describe('Materiels', () => {
  let component: Materiels;
  let fixture: ComponentFixture<Materiels>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Materiels],
      providers: [
        provideZonelessChangeDetection(),
        provideHttpClient(),
        provideRouter(routes)
      ]
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
