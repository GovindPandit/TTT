import { Component, OnInit } from '@angular/core';
import { User } from '../user'
import { UserService } from  '../user.service'

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {
  user:User=
  {
      userid:null,
      username:"",
      phone_number:"",
      password:"",
      status:"",
      role:"",
      skills:""
  }
  u=sessionStorage.getItem("role");
  addUser(userdetails:User):void
  {
      this.userService.addUsers(userdetails).subscribe();
      if(userdetails.role=="Tech Mentor" && this.u=='')
      window.location.href = "http://localhost:4200/login";
      else
      window.location.href = "http://localhost:4200/welcome";
  }
  constructor(private userService:UserService) { }

  ngOnInit() {
  }

}
