import { AdministradorService } from './services/adiministrador.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(private adminService: AdministradorService){

    this.adminService.getAdministradores().subscribe(result=>{
      console.log(result);
    });
    this.adminService.getAdministradores();
  }
}
