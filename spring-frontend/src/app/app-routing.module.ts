import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserLoginComponent } from './user-login/user-login.component'
import { UserHomeComponent } from './user-home/user-home.component'
import { RegisterUserComponent } from './register-user/register-user.component'
import { AssignProjectComponent } from './assign-project/assign-project.component'


const routes:Routes=[
  {path:'welcome',component:UserDetailsComponent},
  {path:'home',component:UserHomeComponent},
  {path:'login',component:UserLoginComponent},
  {path:'register',component:RegisterUserComponent},
  {path:'assignproject',component:AssignProjectComponent},
  {path:'',redirectTo:'/home',pathMatch:"full"}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports:[RouterModule],
  declarations: []
})
export class AppRoutingModule { }
