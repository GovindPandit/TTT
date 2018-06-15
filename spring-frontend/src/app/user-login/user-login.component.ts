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
       
     if(this.u.password==this.dbUser.password)
    {
      alert("welcome "+this.dbUser.username);
      window.location.href="http://localhost:4200/home";
    }
    else
    {
        alert("incorrect username or password");
      
    }
  }

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
