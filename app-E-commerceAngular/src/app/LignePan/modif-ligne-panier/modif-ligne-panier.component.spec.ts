import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifLignePanierComponent } from './modif-ligne-panier.component';

describe('ModifLignePanierComponent', () => {
  let component: ModifLignePanierComponent;
  let fixture: ComponentFixture<ModifLignePanierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifLignePanierComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifLignePanierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
