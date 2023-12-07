import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthsService } from 'src/app/core/helpers/auths.service';
import { CustomValidator } from '../customValidator'; 
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  userNotFound = false;
  formSubmitted = false;
  error = '';
  constructor(
    private auth: AuthsService,
    private route: Router,
  ) {}

  loginForm = new FormGroup({
    login: new FormControl('', [
      Validators.required,
      CustomValidator.emailValidator,
    ]),
    password: new FormControl('', [
      Validators.required,
      CustomValidator.passwordValidator,
    ]),
  });

  login() {
    this.formSubmitted = true;
    this.auth.login(this.loginForm.value).subscribe(
      (data: any) => {
        console.log(data);
        this.auth.updateUserRole(data.role);
        if (data.role === 'UNIVERSITY') {
          this.route.navigate(['/signup']);
        }
         if (data.role === 'STUDENT') {
           this.route.navigate(['/signup']);
         }
            if (data.role === 'SUPERADMIN') {
              this.route.navigate(['/signup']);
            }
      },
      (error: any) => {
        console.log(error.error.message);
        this.error = error.error.message;
        this.userNotFound = true;
      }
    );
  }

}
