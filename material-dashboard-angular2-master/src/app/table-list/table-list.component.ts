import { ConfirmationDialogComponent } from './../components/confirmation-dialog/confirmation-dialog.component';
import { MatDialogRef, MatDialog } from '@angular/material';
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

  private admins: any;
  private titulo: string;

  constructor(private administradorService: AdministradorService, private router: Router, public dialog: MatDialog) {

  }

  ngOnInit() {
    this.administradorService.getAdministradores().subscribe(res => this.admins = res);

  }

  openDialog(admin: Administrador): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: "Do you confirm the deletion of this data?"
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        console.log('Yes clicked');
        this.deletar(admin);
      }
    });
  }



  deletar(admin: Administrador): void {
    this.administradorService.deleteAdministrador(admin.email).subscribe(res => {
      if (res == true) {
        this.administradorService.getAdministradores().subscribe(res => this.admins = res);
        return
      }
    });
  }

}
