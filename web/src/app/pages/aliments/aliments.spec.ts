import { beforeEach, describe, expect, it } from 'vitest';

import { provideHttpClient } from '@angular/common/http';
import { provideZonelessChangeDetection } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideRouter } from '@angular/router';
import { routes } from '../../app.routes';
import { Aliments } from './aliments';

describe('Aliments', () => {
  let component: Aliments;
  let fixture: ComponentFixture<Aliments>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Aliments],
      providers: [
        provideZonelessChangeDetection(),
        provideHttpClient(),
        provideRouter(routes)
      ]
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
