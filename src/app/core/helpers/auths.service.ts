import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class AuthsService {
  constructor(private http: HttpClient) {}
  private userRoleSubject = new BehaviorSubject<string | null>(null);
  userRole$ = this.userRoleSubject.asObservable();

  updateUserRole(role: any) {
    this.userRoleSubject.next(role);
  }

  private userTokenSubject = new BehaviorSubject<string | null>(null);
  userToken$ = this.userTokenSubject.asObservable();

  updateUserToken(role: any) {
    this.userTokenSubject.next(role);
  }

  login(data: any): Observable<any> {
    return this.http.post('http://localhost:8089/login', data);
  }
  register(data: any): Observable<any> {
    return this.http.post('http://localhost:8089/register', data);
  }

  initiatePasswordReset(data: any): Observable<any> {
    return this.http.post('http://localhost:8089/initiate', data);
  }

  confirmResetPassword(data: any): Observable<any> {
    return this.http.post('http://localhost:8089/confirm', data);
  }
}
