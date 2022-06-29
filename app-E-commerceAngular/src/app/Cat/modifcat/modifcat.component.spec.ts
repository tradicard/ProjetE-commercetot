import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifcatComponent } from './modifcat.component';

describe('ModifcatComponent', () => {
  let component: ModifcatComponent;
  let fixture: ComponentFixture<ModifcatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifcatComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifcatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
