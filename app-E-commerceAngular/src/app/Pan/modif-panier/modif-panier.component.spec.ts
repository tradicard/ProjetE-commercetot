import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifPanierComponent } from './modif-panier.component';

describe('ModifPanierComponent', () => {
  let component: ModifPanierComponent;
  let fixture: ComponentFixture<ModifPanierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifPanierComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifPanierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
