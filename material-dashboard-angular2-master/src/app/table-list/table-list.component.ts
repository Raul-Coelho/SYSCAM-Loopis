import { Administrador } from './../models/administrador';
import { AdministradorService } from './../services/administrador.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.css']
})
export class TableListComponent implements OnInit {

  private admins:any;
  private titulo:string;

  constructor(private administradorService:AdministradorService, private router: Router) {

   }

  ngOnInit() {
    this.administradorService.getAdministradores().subscribe(res => this.admins = res);
  
  }

  deletar(admin:Administrador):void{
    if(confirm("Deseja realmente excluir esse Admin?")){
      this.administradorService.deleteAdministrador(admin.email).subscribe(res =>{
        if(res == true){
          this.administradorService.getAdministradores().subscribe(res => this.admins = res);
          return
        }
      });
    }
  }
 
}
