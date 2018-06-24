import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {
  u:string;
  
  constructor() {
    sessionStorage.setItem("role", "");
    this.u=sessionStorage.getItem("role");
   }

  ngOnInit() {

  }

}
