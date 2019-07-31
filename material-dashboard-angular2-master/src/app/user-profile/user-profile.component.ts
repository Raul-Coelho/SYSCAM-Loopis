import { AdministradorService } from './../services/administrador.service';
import { DatePipe } from '@angular/common';
import { Administrador } from './../models/administrador';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  private titulo:string;
  private admin:any;
  private data : Date;

  constructor(private administradorService: AdministradorService, 
    private router: Router, 
    private activatedRoute: ActivatedRoute, private datapipe: DatePipe) { 
    }

  ngOnInit() {
    this.admin = JSON.parse(sessionStorage.getItem("adminLogado"));
    this.administradorService.getAdministrador(this.admin.email).subscribe(adm =>{
      this.admin = adm;
      sessionStorage.setItem("adminLogado", this.admin);

    });
    
  }

  salvar():void {
      console.log(this.admin);
      let data = this.admin.nascimento.toString();
      this.admin.nascimento = data.split('T')[0];
      this.administradorService.updateAdministrador(this.admin).subscribe(response => {
        if(response == true){
          sessionStorage.setItem("adminLogado", JSON.stringify(this.admin));
          return
        }
        console.log(response);
          
      });
  }

}
