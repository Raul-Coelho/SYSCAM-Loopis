import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {
  private urlService:string;

  constructor() {

    this.urlService = 'https://syscamloopis-api.herokuapp.com/';

  }

  getUrlService(): string {

    return this.urlService;
  }
}
