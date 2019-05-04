import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {SlaUser} from "../../shared/models/slaUser";
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {Config} from "../../../config";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private currentUserSubject: BehaviorSubject<SlaUser>;
  public currentUser: Observable<SlaUser>;

  constructor(private http: HttpClient, private config: Config) {
    this.currentUserSubject = new BehaviorSubject<SlaUser>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): SlaUser {
    return this.currentUserSubject.value;
  }

  login(username: string, password: string) {
    return this.http.post<any>(`${this.config.apiUrl}/users/authenticate`, {username, password})
      .pipe(map(user => {
        // login successful if there's a jwt token in the response
        if (user && user.token) {
          // store user details and jwt token in local storage
          localStorage.setItem('currentUser', JSON.stringify(user));
          this.currentUserSubject.next(user);
        }
        return user;
      }));
  }

  logout(){
    // remove user from local storage
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }


}