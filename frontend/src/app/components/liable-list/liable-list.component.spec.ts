import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LiableListComponent } from './liable-list.component';

describe('LiableListComponent', () => {
  let component: LiableListComponent;
  let fixture: ComponentFixture<LiableListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LiableListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LiableListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
