import { AdministradorService } from './services/adiministrador.service';
import { Http } from '@angular/http';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [
    RouterModule
  ],
  providers:[
  ]
})
export class AppRoutingModule { }
