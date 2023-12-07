import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './auth/signup/signup.component';
import { LoginComponent } from './auth/login/login.component';
import { ResetpwdComponent } from './auth/resetpwd/resetpwd.component';
import { ConfirmPasswordComponent } from './auth/confirm-password/confirm-password.component';



const routes: Routes = [
  { path: '', redirectTo: '/signin', pathMatch: 'full' }, // Default route to signin
  { path: 'signup', component: SignupComponent },
  { path: 'signin', component: LoginComponent },
  { path: 'resetpassword', component: ResetpwdComponent },
  { path: 'confirmpassword/:id', component: ConfirmPasswordComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
