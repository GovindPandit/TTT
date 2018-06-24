import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule}  from '@angular/forms'
import { HttpClientModule} from '@angular/common/http'

import { AppComponent } from './app.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { AppRoutingModule } from './/app-routing.module';
import { UserLoginComponent } from './user-login/user-login.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { AssignProjectComponent } from './assign-project/assign-project.component';

@NgModule({
  declarations: [
    AppComponent,
    UserDetailsComponent,
    UserLoginComponent,
    RegisterUserComponent,
    UserHomeComponent,
    AssignProjectComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
