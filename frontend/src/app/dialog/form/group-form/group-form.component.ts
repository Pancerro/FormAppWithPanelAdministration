import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {UniversityCourses} from '../../../model/university-courses';
import {UniversityDepartments} from '../../../model/university-departments';
import {Project} from '../../../model/project';
import {Member} from '../../../model/member';
import {FormService} from '../../../user/service/form.service';
import {first} from 'rxjs/operators';
import {BasicInformation} from '../../../model/member/basic-information';
import {ContactDetails} from '../../../model/member/contact-details';
import {LaborMarketStatus} from '../../../model/member/labor-market-status';
import {DirectionOfEducation} from '../../../model/member/direction-of-education';
import {AdditionalInformation} from '../../../model/member/additional-information';
import {Statement} from '../../../model/member/statement';
import {Subject} from 'rxjs';

@Component({
  selector: 'app-group-form',
  templateUrl: './group-form.component.html',
  styleUrls: ['./group-form.component.css']
})
export class GroupFormComponent implements OnInit {
  public universityCourses: UniversityCourses[];
  public universityDepartments: UniversityDepartments[];
  public loadProject = false;
  public activeProject: Project[];
  @Input() member: Member;
  @Input() editMode: boolean;
  @Input() form = [true, false, false, false, false, false, false];
  @Input() editSubject: Subject<void>;
  @Output() formOutput = new EventEmitter<Member>();
  constructor(private formService: FormService) { }

  ngOnInit() {
    this.formService.getActiveProject().pipe(first()).subscribe((project: Project[]) => {
        this.activeProject = project;
        this.loadProject = true;
      }, error => this.loadProject = false,
      () => this.loadProject = true);
    this.formService.getUniversityCourses().subscribe((universityCourses: UniversityCourses[]) =>
      this.universityCourses = universityCourses);
    this.formService.getUniversityDepartments().subscribe((universityDepartments: UniversityDepartments[]) =>
      this.universityDepartments = universityDepartments);
  }
  public sendForm(send: boolean): void {
    if (send) {
      this.formOutput.emit(this.member);
   //   this.formService.sendForm(this.member, this.activeProject[0].idProject).subscribe(res => this.status = res.status,
       // err => this.invalid = true);
    }
  }
  public addBasicInformation(basicInformation: BasicInformation): void {
    this.member.basicInformation = basicInformation;
  }
  public addContactDetails(contactDetails: ContactDetails): void {
    this.member.contactDetails = contactDetails;
  }
  public addLaborMarketStatusOutput(laborMarketStatus: LaborMarketStatus): void {
    this.member.laborMarketStatus = laborMarketStatus;
  }
  public addDirectionOfEducation(directionOfEducation: DirectionOfEducation): void {
    this.member.directionOfEducation = directionOfEducation;
  }
  public addAdditionalInformation(additionalInformation: AdditionalInformation): void {
    this.member.additionalInformation = additionalInformation;
  }
  public addStatement(statement: Statement): void {
    this.member.statement = statement;
  }
  public next(idStep: number): void {
    this.form = [false, false, false, false, false, false, false];
    this.form[idStep] = true;
  }
}
