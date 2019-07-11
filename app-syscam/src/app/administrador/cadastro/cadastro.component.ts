import { AdministradorService } from './../../services/adiministrador.service';
import { Administrador } from './../../services/pessoa';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss']
})
export class CadastroComponent implements OnInit {

  private titulo:string;
  private admin:any;
  private data : Date;

  constructor(private administradorService: AdministradorService, 
    private router: Router, 
    private activatedRoute: ActivatedRoute, private datapipe: DatePipe) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(parametro => {
      if(parametro["email"] == undefined){
        this.titulo = "Cadastro de Novo ADMIN";
        this.admin = new Administrador();
        this.data = new Date();
        
      }
      else{
        this.titulo = "Editar informações de Admin"
        this.administradorService.getAdministrador(parametro["email"]).subscribe(res => this.admin = res);
      }
    });
  }

  salvar():void {
    console.log(this.admin);
    //  if(this.admin.email == undefined){
      // this.data = new Date();
      let data = this.admin.nascimento.toString();
      this.admin.nascimento = data.split('T')[0];
      this.administradorService.addAdministrador(this.admin).subscribe(response => {
        this.admin = new Administrador();
        console.log(response);
        
        
      });
    // }else{
    //   this.administradorService.updateAdministrador(this.admin).subscribe(response => {
    //     this.router.navigate(['/consulta-admin']);
    //   });
    // }
  }
}
