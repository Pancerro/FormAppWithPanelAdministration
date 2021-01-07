import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Charts } from 'src/app/model/charts';
import {Member} from '../../model/member';
import {Project} from '../../model/project';
import {UniversityCourses} from '../../model/university-courses';
import {UniversityDepartments} from '../../model/university-departments';
import {SaveMemberToProject} from '../../model/save-member-to-project';
import {AcceptEmail} from '../../model/message/accept-email';
import {WebStarterDesc} from '../../model/message/web-starter-desc';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  public getAuth(): Observable<any> {
    const url = 'http://localhost:8080/admin/basicauth';
    return this.http.get<any>(url);
  }


  /// przepis na admin panel -- chyba

  public getActiveProject(): Observable<Project[]> {
    const url = 'http://localhost:8080/member/active-project';
    return this.http.get<Project[]>(url);
  }
  public getUniversityCourses(): Observable<UniversityCourses[]> {
    const url = 'http://localhost:8080/member/university-courses';
    return this.http.get<UniversityCourses[]>(url);
  }
  public getUniversityDepartments(): Observable<UniversityDepartments[]> {
    const url = 'http://localhost:8080/member/university-departments';
    return this.http.get<UniversityDepartments[]>(url);
  }
  public addUniversityDepartment(addUniversityDepartment: UniversityDepartments): Observable<any> {
    const url = 'http://localhost:8080/admin/add-university-department';
    return this.http.post<any>(url, addUniversityDepartment, { observe: 'response'});
  }

  public editUniversityDepartment(editUniversityDepartment: UniversityDepartments): Observable<UniversityDepartments> {
    const url = 'http://localhost:8080/admin/edit-university-department';
    return this.http.put<UniversityDepartments>(url, editUniversityDepartment);
  }
  public deleteUniversityDepartment(id: number): Observable<any> {
    const url = 'http://localhost:8080/admin/delete-university-department/' + id;
    return this.http.delete<UniversityDepartments>(url);
  }
  public addUniversityCourses(addUniversityCourses: UniversityCourses): Observable<any> {
    const url = 'http://localhost:8080/admin/add-university-courses';
    return this.http.post<any>(url, addUniversityCourses, { observe: 'response'});
  }
  public editUniversityCourses(editUniversityCourses: UniversityCourses): Observable<UniversityCourses> {
    const url = 'http://localhost:8080/admin/edit-university-courses';
    return this.http.put<UniversityCourses>(url, editUniversityCourses);
  }
  public deleteUniversityCourses(id: number): Observable<any> {
    const url = 'http://localhost:8080/admin/delete-university-courses/' + id;
    return this.http.delete<UniversityDepartments>(url);
  }
  /// przepis na admin panel -- chyba

  public getMember(): Observable<Member[]> {
    const url = 'http://localhost:8080/admin/all-member';
    return this.http.get<Member[]>(url);
  }
  public addMember(member: Member, idProject: number): Observable<any> {
    const url = 'http://localhost:8080/member/form/' + idProject;
    return this.http.post<any>(url, member, { observe: 'response'});
  }
  public editMember(member: Member): Observable<Member> {
    const editMember: Member = {
      idMember: member.idMember,
      basicInformation: member.basicInformation,
      contactDetails: member.contactDetails,
      laborMarketStatus: member.laborMarketStatus,
      directionOfEducation: member.directionOfEducation,
      additionalInformation: member.additionalInformation,
      statement: member.statement
    };
    const url = 'http://localhost:8080/admin/edit-member';
    return this.http.put<Member>(url, editMember);
  }
  public deleteMember(id: number): Observable<any> {
    const url = 'http://localhost:8080/admin/delete-member/' + id;
    return this.http.delete(url);
  }
  public getChartsAge(): Observable<Charts[]> {
    const url = 'http://localhost:8080/admin/get-charts-age';
    return this.http.get<Charts[]>(url);
  }
  public getChartsSex(): Observable<Charts[]> {
    const url = 'http://localhost:8080/admin/get-charts-sex';
    return this.http.get<Charts[]>(url);
  }
  public getChartsEducation(): Observable<Charts[]> {
    const url = 'http://localhost:8080/admin/get-charts-education';
    return this.http.get<Charts[]>(url);
  }
  public getChartsArea(): Observable<Charts[]> {
    const url = 'http://localhost:8080/admin/get-charts-area';
    return this.http.get<Charts[]>(url);
  }

  public getChartsCourses(): Observable<Charts[]> {
    const url = 'http://localhost:8080/admin/get-charts-courses';
    return this.http.get<Charts[]>(url);
  }

  public getSaveToProject(): Observable<SaveMemberToProject[]> {
    const url = 'http://localhost:8080/admin/get-save-to-project';
    return this.http.get<SaveMemberToProject[]>(url);
  }
  public addSaveToProject(saveMemberToProject: SaveMemberToProject): Observable<any> {
    const url = 'http://localhost:8080/admin/add-save-to-project';
    return this.http.post<any>(url, saveMemberToProject, { observe: 'response'});
  }
  public editSaveToProject(saveMemberToProject: SaveMemberToProject): Observable<SaveMemberToProject> {
    const url = 'http://localhost:8080/admin/edit-save-to-project';
    return this.http.put<SaveMemberToProject>(url, saveMemberToProject);
  }
  public deleteSaveToProject(idSave: number): Observable<any> {
    const url = 'http://localhost:8080/admin/delete-save-to-project/' + idSave;
    return this.http.delete(url);
  }

  public getProject(): Observable<Project[]> {
    const url = 'http://localhost:8080/admin/get-project';
    return this.http.get<Project[]>(url);
  }
  public addProject(project: Project): Observable<any> {
    const url = 'http://localhost:8080/admin/add-project';
    return this.http.post<any>(url, project, { observe: 'response'});
  }
  public editProject(project: Project): Observable<SaveMemberToProject> {
    const url = 'http://localhost:8080/admin/edit-project';
    return this.http.put<SaveMemberToProject>(url, project);
  }
  public deleteProject(idProject: number): Observable<any> {
    const url = 'http://localhost:8080/admin/delete-project/' + idProject;
    return this.http.delete(url);
  }
  public getChartsCountMemberInProject(): Observable<Charts[]> {
    const url = 'http://localhost:8080/admin/get-charts-member-in-project';
    return this.http.get<Charts[]>(url);
  }
  public getAcceptEmail(): Observable<AcceptEmail> {
    const url = 'http://localhost:8080/admin/get-accept-email';
    return this.http.get<AcceptEmail>(url);
  }
  public  addAcceptEmail(acceptEmail: AcceptEmail): Observable<any>  {
    const url = 'http://localhost:8080/admin/add-accept-email';
    return this.http.post<any>(url, acceptEmail, { observe: 'response'});
  }
  public editAcceptEmail(acceptEmail: AcceptEmail): Observable<AcceptEmail> {
    console.log(acceptEmail);
    const url = 'http://localhost:8080/admin/edit-accept-email';
    return this.http.put<AcceptEmail>(url, acceptEmail);
  }
  public deleteAcceptEmail(): Observable<any> {
      const url = 'http://localhost:8080/admin/delete-accept-email';
      return this.http.delete(url);
  }
  public  getWebStarterDesc(): Observable<WebStarterDesc> {
    const url = 'http://localhost:8080/admin/get-web-starter';
    return this.http.get<WebStarterDesc>(url);
  }
  public addWebStarterDesc(webStarterDesc: WebStarterDesc): Observable<any> {
    const url = 'http://localhost:8080/admin/add-web-starter';
    return this.http.post<any>(url, webStarterDesc, { observe: 'response'});
  }
  public editWebStarterDesc(webStarterDesc: WebStarterDesc): Observable<WebStarterDesc> {
    const url = 'http://localhost:8080/admin/edit-web-starter';
    return this.http.put<WebStarterDesc>(url, webStarterDesc);
  }
  public deleteWebStarterDesc(): Observable<any> {
    const url = 'http://localhost:8080/admin/delete-web-starter';
    return this.http.delete(url);
  }

  public changePassword(password: string): Observable<any> {
    const url = 'http://localhost:8080/admin/change-password';
    return this.http.post<any>(url, password, { observe: 'response'});
  }

}
