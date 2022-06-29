import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeprodclientComponent } from './listeprodclient.component';

describe('ListeprodclientComponent', () => {
  let component: ListeprodclientComponent;
  let fixture: ComponentFixture<ListeprodclientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeprodclientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeprodclientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
