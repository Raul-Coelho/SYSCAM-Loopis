import { Administrador } from './../models/administrador';
import { AdministradorService } from './../services/administrador.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  private admin:Administrador;

  constructor(private administradorService: AdministradorService, 
    private router: Router, 
    private activatedRoute: ActivatedRoute,) {

   }

  ngOnInit() {
    this.admin = new Administrador();
  }

  login():void{
    this.administradorService.login(this.admin).subscribe(response => {
      this.admin = new Administrador();
      this.router.navigate(['dashboard']);
      console.log(response);
    })
  }

}
