import { TestBed } from '@angular/core/testing';

import { WasteTypeService } from './waste-type.service';

describe('WasteTypeService', () => {
  let service: WasteTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WasteTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
