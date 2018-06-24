import { Component, OnInit } from '@angular/core';
import { User } from '../user'
import { UserService } from  '../user.service'
import { AssignProjectComponent } from '../assign-project/assign-project.component'

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  users:User[];
  userss:User[];
  assignmentProjectComponent:AssignProjectComponent;
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
  //1st way
  //users=USERS;
  role:string;
  username=sessionStorage.getItem("userid");
  searchBy:string;
  search:string;
  projectstatus:string;
  
  constructor(private userService:UserService) { 
    this.role=sessionStorage.getItem("role");
    if(this.role==null || this.role=="")
    {
      alert("Please login first");
      window.location.href = "http://localhost:4200/login";
    }
  }
  
  assignProject(us:User):void
  {
    sessionStorage.setItem("projectid",us.userid+"");
    window.location.href = "http://localhost:4200/assignproject"
    
  }
  onDelete(userdetails:User):void
  {
      var status=confirm("Do you want to continue?");
      if(status)
      {
        this.userService.deleteUsers(userdetails).subscribe();
        if(this.role=="hr")
        window.location.href = "http://localhost:4200/welcome";
        else
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
      window.location.href = "http://localhost:4200/welcome";
  }

  addUser(userdetails:User):void
  {
      this.userService.addUsers(userdetails).subscribe();
      window.location.href = "http://localhost:4200/welcome";
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
  searchUsers(searchBy:string,search:string):void
  {
    this.userService.searchUsers(this.searchBy,this.search).subscribe(userss => this.userss =userss);
  }
  projectStatus(searchBy:string,search:string):void
  {
    this.userService.searchUsers(this.searchBy,this.search).subscribe(userss => this.userss =userss);
  }
  ngOnInit() {
	
		this.getUsers();
  }

}
