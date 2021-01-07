import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {AdditionalInformation} from '../../../model/member/additional-information';
import {UniversityDepartments} from '../../../model/university-departments';
import {UniversityCourses} from '../../../model/university-courses';
import {Subject, Subscription} from 'rxjs';

@Component({
  selector: 'app-additional-information-form',
  templateUrl: './additional-information-form.component.html',
  styleUrls: ['./additional-information-form.component.css']
})
export class AdditionalInformationFormComponent implements OnInit, OnDestroy {
  constructor() { }
  @Input() additionalInformationInput: AdditionalInformation;
  @Input() departments: UniversityDepartments[];
  @Input() courser: UniversityCourses[];
  @Input() editSubject: Subject<void>;
  @Input() editMode: boolean;
  @Output() additionalInformationOutput =  new EventEmitter<AdditionalInformation>();
  @Output() nextStep = new EventEmitter<number>();
  private step = 5;
  private sub: Subscription = new Subscription();
  public additionalInformationForm: FormGroup;
  ngOnInit() {
    if (this.editMode) { this.sub = this.editSubject.subscribe(() => this.sendForm()); }
    this.additionalInformationForm = new FormGroup({
      idAdditional: new FormControl(this.additionalInformationInput.idAdditional),
      repeatYear: new FormControl(this.additionalInformationInput.repeatYear),
      studyingAnotherDirection: new FormControl(this.additionalInformationInput.studyingAnotherDirection),
      nameUniversity: new FormControl(this.additionalInformationInput.nameUniversity),
      department: new FormControl(this.additionalInformationInput.department),
      fieldOfStudy: new FormControl(this.additionalInformationInput.fieldOfStudy),
      profile: new FormControl(this.additionalInformationInput.profile),
      yearStartStudy: new FormControl(this.additionalInformationInput.yearStartStudy),
      workPlacementAndYear: new FormControl(this.additionalInformationInput.workPlacementAndYear),
      studiedAnotherUniversity: new FormControl(this.additionalInformationInput.studiedAnotherUniversity),
      nameAnotherUniversity: new FormControl(this.additionalInformationInput.nameAnotherUniversity),
      departmentAnother: new FormControl(this.additionalInformationInput.departmentAnother),
      fieldOfStudyAnother: new FormControl(this.additionalInformationInput.fieldOfStudyAnother),
      profileAnother: new FormControl(this.additionalInformationInput.profileAnother),
      yearStartAndEndStudyAnother: new FormControl(this.additionalInformationInput.yearStartAndEndStudyAnother),
      workPlacementAndYearAnother: new FormControl(this.additionalInformationInput.workPlacementAndYearAnother)
    });
  }
  public sendForm(): void {
    this.additionalInformationOutput.emit(this.additionalInformationForm.value);
  }
  public next(): void {
    this.sendForm();
    this.nextStep.emit(this.step + 1);
  }
  public previous(): void {
    this.sendForm();
    this.nextStep.emit(this.step - 1);
  }
  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}
