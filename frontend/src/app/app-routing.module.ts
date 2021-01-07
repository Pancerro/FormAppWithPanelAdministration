import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './admin/login/login-service/guard/auth.guard';
import { LoginComponent } from './admin/login/login.component';
import { PanelComponent } from './admin/panel/panel.component';
import { FormComponent } from './user/form/form.component';


const routes: Routes = [
  { path: '', component: FormComponent},
  { path: 'user', loadChildren: () => import('./user/member.module').then(mod => mod.MemberModule)},
  { path: 'administration-panel', component: PanelComponent, canActivate: [AuthGuard]},
  { path: 'login', component: LoginComponent },
  { path: '**', redirectTo: '/user', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }
