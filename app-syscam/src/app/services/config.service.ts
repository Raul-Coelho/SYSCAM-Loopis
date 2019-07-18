import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private urlService:string;

  constructor() {

    this.urlService = 'http://localhost:8090';

  }

  getUrlService(): string {

    return this.urlService;
  }
}
