import { ConfigService } from './services/config.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Http, HttpModule } from '@angular/http';
import { AdministradorService } from './services/adiministrador.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { CadastroComponent } from './administrador/cadastro/cadastro.component';
import { ConsultaComponent } from './administrador/consulta/consulta.component';
import { MenuComponent } from './administrador/menu/menu.component';
import { routing } from 'src/app.routes';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CadastroComponent,
    ConsultaComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    routing
  ],
  providers: [
    ConfigService,
    AdministradorService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
