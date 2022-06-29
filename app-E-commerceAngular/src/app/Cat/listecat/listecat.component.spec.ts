import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListecatComponent } from './listecat.component';

describe('ListecatComponent', () => {
  let component: ListecatComponent;
  let fixture: ComponentFixture<ListecatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListecatComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListecatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
