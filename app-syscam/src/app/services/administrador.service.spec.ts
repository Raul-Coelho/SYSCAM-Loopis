import { TestBed } from '@angular/core/testing';

import { AdministradorService } from './adiministrador.service';

describe('PessoaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdministradorService = TestBed.get(AdministradorService);
    expect(service).toBeTruthy();
  });
});
