import { CadastroComponent } from './app/administrador/cadastro/cadastro.component';
import { ConsultaComponent } from './app/administrador/consulta/consulta.component';
import { HomeComponent } from './app/home/home.component';
import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

const appRoutes: Routes = [
    { path: 'home',                    component: HomeComponent },
    { path: '',                        component: HomeComponent },
    { path: 'consulta-admin',         component: ConsultaComponent },
    { path: 'cadastro-admin',         component: CadastroComponent },
    { path: 'cadastro-admin/:codigo', component: CadastroComponent }
 
];
 
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);