import { Component, OnInit } from '@angular/core';
import { User } from '../user'
import { Projects } from '../projects'
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-assign-project',
  templateUrl: './assign-project.component.html',
  styleUrls: ['./assign-project.component.css']
})
export class AssignProjectComponent implements OnInit {

  constructor(private userService:UserService) { }
   projectUser:Projects={
     userid:parseInt(sessionStorage.getItem("projectid")),
     projectName:"",
     description:""
   };
   addProject(pr:Projects):void
   {
    this.userService.adddProject(pr).subscribe();
    window.location.href = "http://localhost:4200/welcome";
   }
  
  ngOnInit() {
  }

}
