import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthsService } from 'src/app/core/helpers/auths.service';

@Component({
  selector: 'app-confirm-password',
  templateUrl: './confirm-password.component.html',
  styleUrls: ['./confirm-password.component.css'],
})
export class ConfirmPasswordComponent implements OnInit {
  constructor(private router: Router, private route: ActivatedRoute,private authService:AuthsService) {}
  ngOnInit(): void {}

  myForm = new FormGroup({
    password: new FormControl(
      '',
    ),
  })
  confirmResetPassword(){
    const data = {token:this.route.snapshot.paramMap.get('id'),password:this.myForm.value.password}
    this.authService.confirmResetPassword(data).subscribe((data:any)=>{
      console.log()
    })

  }
}
