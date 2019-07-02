import { AdministradorService } from './../../services/adiministrador.service';
import { Administrador } from './../../services/pessoa';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styleUrls: ['./consulta.component.scss']
})
export class ConsultaComponent implements OnInit {

  private admins:Administrador[] = new Array();
  private titulo:string;

  constructor(private administradorService:AdministradorService, private router: Router) {

   }

  ngOnInit() {
    this.titulo = "Registros Cadastrados!";
    this.administradorService.getAdministradores().subscribe(res => this.admins);
  }

  deletar(codigo:number, index:number): void{
    if(confirm("Deseja realmente excluir esse registro?")){
      this.administradorService.deleteAdministrador(codigo).subscribe(response => {
        this.admins.splice(index,1);
      });
    }
  }

  editar(codigo:number):void{
    this.router.navigate(['consulta-admin',codigo]);
  }


}
