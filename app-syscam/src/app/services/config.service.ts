import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private urlService:string;

  constructor() {

    this.urlService = 'http://localhost:8085';

  }

  getUrlService(): string {

    return this.urlService;
  }
}
