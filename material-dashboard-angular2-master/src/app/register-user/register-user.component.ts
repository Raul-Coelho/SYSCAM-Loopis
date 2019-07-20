import { Administrador } from './../models/administrador';
import { DatePipe } from '@angular/common';
import { AdministradorService } from './../services/administrador.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.scss']
})
export class RegisterUserComponent implements OnInit {

  private titulo:string;
  private admin:any;
  private data : Date;

  constructor(private administradorService: AdministradorService, 
    private router: Router, 
    private activatedRoute: ActivatedRoute, private datapipe: DatePipe) { }

  ngOnInit() {
    this.admin = new Administrador();
    
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
