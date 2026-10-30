import { beforeEach, describe, expect, it } from 'vitest';

import { provideHttpClient } from '@angular/common/http';
import { provideZonelessChangeDetection } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideRouter } from '@angular/router';
import { routes } from '../../app.routes';
import { Medics } from './medics';

describe('Medics', () => {
  let component: Medics;
  let fixture: ComponentFixture<Medics>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Medics],
      providers: [
        provideZonelessChangeDetection(),
        provideHttpClient(),
        provideRouter(routes)
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(Medics);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
