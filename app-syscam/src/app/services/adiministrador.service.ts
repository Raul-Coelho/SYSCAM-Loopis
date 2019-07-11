import { Administrador } from './pessoa';
import { ConfigService } from './config.service';
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { config, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AdministradorService {

  private baseUrlService = '';

  constructor(private http: HttpClient, private configService: ConfigService) {
    this.baseUrlService = configService.getUrlService() + '/administradores/';
   }

   getAdministradores(){
     return this.http.get(this.baseUrlService);
   }

   addAdministrador(admin:Administrador){
     return this.http.post(this.baseUrlService, admin);
   }

   deleteAdministrador(email:string){
     return this.http.delete(this.baseUrlService + email);
   }

   getAdministrador(email:string){
     return this.http.get(this.baseUrlService + email);
   }

   updateAdministrador(admin: Administrador){
     return this.http.put(this.baseUrlService, admin);
   }
}
