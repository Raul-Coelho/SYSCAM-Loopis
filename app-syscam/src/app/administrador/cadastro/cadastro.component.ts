import { AdministradorService } from './../../services/adiministrador.service';
import { Administrador } from './../../services/pessoa';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss']
})
export class CadastroComponent implements OnInit {

  private titulo:string;
  private admin:Administrador = new Administrador;

  constructor(private administradorService: AdministradorService, 
    private router: Router, 
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {

    this.activatedRoute.params.subscribe(parametro => {
      if(parametro["codigo"] == undefined){
        this.titulo = "Cadastro de Novo ADMIN"
      }
      else{
        this.titulo = "Editar informações de Admin"
        // this.administradorService.getAdministrador(Number(parametro["codigo"])).subscribe(res => this.admin = res);
      }
    });
  }

  salvar():void {
     if(this.admin.codigo == undefined){
      this.administradorService.addAdministrador(this.admin).subscribe(response => {
        this.admin = new Administrador();
      });
    }else{
      this.administradorService.updateAdministrador(this.admin).subscribe(response => {
        this.router.navigate(['/consulta-admin']);
      });
    }
  }
}
