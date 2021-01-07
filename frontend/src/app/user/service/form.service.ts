import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Member} from '../../model/member';
import {UniversityCourses} from '../../model/university-courses';
import {UniversityDepartments} from '../../model/university-departments';
import {Project} from '../../model/project';
import {WebStarterDesc} from '../../model/message/web-starter-desc';

@Injectable({
  providedIn: 'root'
})
export class FormService {

  constructor(private http: HttpClient) { }

  public sendForm(member: Member, idProject: number): Observable<any> {
    const url = 'http://localhost:8080/member/form/' + idProject;
    return this.http.post<any>(url, member, { observe: 'response'});
   }

  public getUniversityCourses(): Observable<UniversityCourses[]> {
    const url = 'http://localhost:8080/member/university-courses';
    return this.http.get<UniversityCourses[]>(url);
  }
  public getUniversityDepartments(): Observable<UniversityDepartments[]> {
    const url = 'http://localhost:8080/member/university-departments';
    return this.http.get<UniversityDepartments[]>(url);
  }
  public getActiveProject(): Observable<Project[]> {
    const url = 'http://localhost:8080/member/active-project';
    return this.http.get<Project[]>(url);
  }
  public getWebStarterDesc(): Observable<WebStarterDesc> {
    const url = 'http://localhost:8080/member/get-web-starter';
    return this.http.get<WebStarterDesc>(url);
  }
}
