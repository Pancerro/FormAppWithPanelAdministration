import {Component, OnInit, ViewEncapsulation } from '@angular/core';
import { AuthenticationService } from 'src/app/admin/login/login-service/auth/auth.service';
import {Member} from '../../model/member';
import {FormService} from '../service/form.service';
import {first} from 'rxjs/operators';
import {Project} from '../../model/project';
import {WebStarterDesc} from '../../model/message/web-starter-desc';
@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class FormComponent implements OnInit {
  constructor(private auth: AuthenticationService,
              private formService: FormService) { }
  public member: Member;
  public status: string;
  public invalid = false;
  public activeProject: Project[];
  public webStarterDesc: WebStarterDesc;
  public loadingWebStarterDesc = false;
  public errorDesc: string;
  public formIsSend = true;
  ngOnInit() {
    this.formService.getActiveProject().pipe(first()).subscribe((project: Project[]) => {
        this.activeProject = project;
      });
    this.formService.getWebStarterDesc().pipe(first()).subscribe((webStarterDesc: WebStarterDesc) => {
      this.webStarterDesc = webStarterDesc;
      this.loadingWebStarterDesc = true;
    }, err => {
      this.errorDesc = err.response;
      this.loadingWebStarterDesc = true;
    }, () => this.loadingWebStarterDesc = true);
    this.setMember();
    this.auth.logout();
  }
  public sendForm(form): void {
    this.setMember();
    this.formIsSend = false;
    this.formService.sendForm(form, this.activeProject[0].idProject).subscribe(res => {
      this.status = res.status;
      this.formIsSend = true;
      },
      err => {
        this.invalid = true;
        this.formIsSend = true;
      }, () =>  this.formIsSend = true);
  }

  public clearError(): void {
    this.invalid = null;
    this.status = null;
  }
  private setMember(): void {
    this.member = {
      basicInformation: {
        name: null,
        surname: null,
        pesel: null,
        idNumber: null,
        age: null,
        education: null
      },
      contactDetails: {
        street: null,
        houseNumber: null,
        township: null,
        postOffice: null,
        postalCode: null,
        community: null,
        district: null,
        voivodeship: null,
        area: null,
        phoneNumber: null,
        email: null,
      },
      laborMarketStatus: {
        unemployedPerson: null,
        longTermUnemployed: null,
        professionallyInactive: null,
        learningPerson: null,
        notLearningPerson: null,
        other: null,
        working: null,
        selfEmployed: null,
        employedInMicroSmallMediumEnterprise: null,
        employedInBigEnterprise: null,
        employedInGovernmentAdministration: null,
        employedInLocalGovernmentAdministration: null,
        employedInNonGovernmentalOrganization: null,
        nameOfWorkplace: null,
        occupationPerformed: null,
        nationalMinority: null,
        emigrant: null,
        disabledPerson: null
      },
      directionOfEducation: {
        nameUniversity: null,
        department: null,
        fieldOfStudy: null,
        profile: null,
        degreeOfStudies: null,
        yearStartStudy: null
      },
      additionalInformation: {
        repeatYear: null,
        studyingAnotherDirection: null,
        nameUniversity: null,
        department: null,
        fieldOfStudy: null,
        profile: null,
        yearStartStudy: null,
        workPlacementAndYear: null,
        studiedAnotherUniversity: null,
        nameAnotherUniversity: null,
        departmentAnother: null,
        fieldOfStudyAnother: null,
        profileAnother: null,
        yearStartAndEndStudyAnother: null,
        workPlacementAndYearAnother: null
      },
      statement: {
        homelessPerson: null,
        anotherUnfavorablePersonSocialSituation: null,
        statement: null
      }
    };
  }
}
