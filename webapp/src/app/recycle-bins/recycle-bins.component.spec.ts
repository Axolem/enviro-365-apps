import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecycleBinsComponent } from './recycle-bins.component';

describe('RecycleBinsComponent', () => {
  let component: RecycleBinsComponent;
  let fixture: ComponentFixture<RecycleBinsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecycleBinsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecycleBinsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
