import { Injectable } from '@angular/core';
import { User , USERS} from './user'
import { Observable, of } from 'rxjs';
import { HttpClient,HttpClientModule,HttpHeaders} from '@angular/common/http'
import { catchError, map , tap } from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  //2nd way
  // gtUsers(): User[] {
  //   return USERS;
  // }
  constructor(private http:HttpClient) { }
  private userUrl = 'http://localhost:8080/SpringMVCWithRest/';
  
    
    getUsers():Observable<User[]>
    {
      //return of (USERS);
      return this.http.get<User[]>(this.userUrl);
      //.pipe(tap(User=>this.log("fetched users")),catchError(this.handleError('getUsers', [])));
    }

    deleteUsers(user:User):Observable<User>
    {
      //return of (USERS);
      
      const id=typeof user==="number"?user:user.userid;
      const deleteUrl=`${this.userUrl}${id}`;
      return this.http.delete<User>(deleteUrl);
      //.pipe(tap(User=>this.log("fetched users")),catchError(this.handleError('getUsers', [])));
    }
    
  addUsers(user:User):Observable<User>
    {
      //return of (USERS);
      return this.http.post<User>(this.userUrl,user);
      //.pipe(tap(User=>this.log("fetched users")),catchError(this.handleError('getUsers', [])));
    }

    loginClicked(user:User)
    {
      const url="http://localhost:8080/SpringMVCWithRest/user";
      return this.http.post<User>(url,user);
    }

    updateUsers(user:User):Observable<User>
    {
      //return of (USERS);
      return this.http.put<User>(this.userUrl,user);
      //.pipe(tap(User=>this.log("fetched users")),catchError(this.handleError('getUsers', [])));
    }

}
