import { Component, OnInit } from '@angular/core';
import { User , USERS } from '../user'
import { UserService } from  '../user.service'

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  users:User[];
  user:User=
  {
      userid:null,
      username:"",
      phone_number:"",
      password:""
  }
  //1st way
  //users=USERS;
  constructor(private userService:UserService) { }
  
  onDelete(userdetails:User):void
  {
      var status=confirm("Do you want to continue?");
      if(status)
      {
        this.userService.deleteUsers(userdetails).subscribe();
        window.location.href = "http://localhost:4200/home";
      }
  }

  electedUser:User;
  onView(userDetails:User):void
  {
    this.electedUser=userDetails;
  }


  onUpdate(userdetails:User):void
  {
      this.userService.updateUsers(userdetails).subscribe();
      window.location.href = "http://localhost:4200/home";
  }

  addUser(userdetails:User):void
  {
      this.userService.addUsers(userdetails).subscribe();
      window.location.href = "http://localhost:4200/home";
  }

  selectedUser:User;
  onEdit(userdetails:User):void
  {
    this.selectedUser=userdetails;
  }
  getUsers():void
  {
    //2nd way using service
    //this.users=this.userService.gtUsers();

    //3rd using observable
    this.userService.getUsers().subscribe(users => this.users =users);
  }
  ngOnInit() {
    this.getUsers();
  }

}
