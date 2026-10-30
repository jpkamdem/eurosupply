import { beforeEach, describe, expect, it } from 'vitest';

import { provideZonelessChangeDetection } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideRouter } from '@angular/router';
import { routes } from '../../app.routes';
import { QuickLink } from './quick-link';

describe('QuickLink', () => {
  let component: QuickLink;
  let fixture: ComponentFixture<QuickLink>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [QuickLink],
      providers: [
        provideZonelessChangeDetection(),
        provideRouter(routes)]
    })
      .compileComponents();

    fixture = TestBed.createComponent(QuickLink);
    component = fixture.componentInstance;

    fixture.componentRef.setInput('path', 'materiel');
    fixture.componentRef.setInput('textLink', 'Matériel');

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
