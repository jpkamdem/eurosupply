import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuickLink } from './quick-link';

describe('QuickLink', () => {
  let component: QuickLink;
  let fixture: ComponentFixture<QuickLink>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [QuickLink]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QuickLink);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
