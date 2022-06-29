import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeprodComponent } from './listeprod.component';

describe('ListeprodComponent', () => {
  let component: ListeprodComponent;
  let fixture: ComponentFixture<ListeprodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeprodComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeprodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
