import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService} from '../user.service'

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  
  dbUser:User;

  constructor(private userService:UserService) { }
u:any={}

  login() {
    
    this.userService.loginClicked(this.u).subscribe(dbUser => this.dbUser = dbUser);  
       
    // if(this.dbUser.status==="NB")
    // {
    if(this.u.password===this.dbUser.password)
    {
      sessionStorage.setItem("role", this.dbUser.role);
      sessionStorage.setItem("userid", this.dbUser.username);
      alert("welcome "+this.dbUser.username);
      window.location.href="http://localhost:4200/welcome";
    }
    else
    {
        alert("incorrect username or password");
      
    }
  }
  // else
  // {
  //     alert("your profile is not reviwed by hr yet or blocked !!!");
  // }
  
  onLoginClicked():void
  {
    
    this.userService.loginClicked(this.dbUser).subscribe(data=>this.dbUser=data);
    // if(this.dbUser.password===usern.password)
    // {
    //   alert("welcome "+this.dbUser.username);
    //   window.location.href="http://localhost:4200/home";
    // }
    // else
    // {
    //   alert("incorrect username or password");
    // }
  }

  
  ngOnInit() {
    
  }

}
