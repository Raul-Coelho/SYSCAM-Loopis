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
    private activatedRoute: ActivatedRoute, private datapipe: DatePipe) { }

  ngOnInit() {
    
  }

  salvar():void {
      console.log(this.admin);
      let data = this.admin.nascimento.toString();
      this.admin.nascimento = data.split('T')[0];
      this.administradorService.addAdministrador(this.admin).subscribe(response => {
        this.admin = new Administrador();
        console.log(response);
        
        
      });
  }

}
