import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifprodComponent } from './modifprod.component';

describe('ModifprodComponent', () => {
  let component: ModifprodComponent;
  let fixture: ComponentFixture<ModifprodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifprodComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifprodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
