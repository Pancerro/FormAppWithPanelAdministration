import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {DirectionOfEducation} from '../../../model/member/direction-of-education';
import {DegreeOfStudy} from '../../../model/enumPack/degree-of-study.enum';
import {UniversityDepartments} from '../../../model/university-departments';
import {UniversityCourses} from '../../../model/university-courses';
import {Subject, Subscription} from 'rxjs';

@Component({
  selector: 'app-direction-of-education-form',
  templateUrl: './direction-of-education-form.component.html',
  styleUrls: ['./direction-of-education-form.component.css']
})
export class DirectionOfEducationFormComponent implements OnInit, OnDestroy {
  @Input() directionOfEducationInput: DirectionOfEducation;
  @Input() departments: UniversityDepartments[];
  @Input() courser: UniversityCourses[];
  @Input() editSubject: Subject<void>;
  @Input() editMode: boolean;
  @Output() directionOfEducationOutput =  new EventEmitter<DirectionOfEducation>();
  @Output() nextStep = new EventEmitter<number>();
  private step = 4;
  private sub: Subscription = new Subscription();
  public degreeOfStudy = DegreeOfStudy;
  public directionOfEducationForm: FormGroup;
  ngOnInit() {
    if (this.editMode) { this.sub = this.editSubject.subscribe(() => this.sendForm()); }
    this.directionOfEducationForm = new FormGroup({
      idDirectionOfEducation: new FormControl(this.directionOfEducationInput.idDirectionOfEducation),
      nameUniversity: new FormControl(this.directionOfEducationInput.nameUniversity, Validators.required),
      department: new FormControl(this.directionOfEducationInput.department, Validators.required),
      fieldOfStudy: new FormControl(this.directionOfEducationInput.fieldOfStudy, Validators.required),
      profile: new FormControl(this.directionOfEducationInput.profile, Validators.required),
      degreeOfStudies: new FormControl(this.directionOfEducationInput.degreeOfStudies, Validators.required),
      yearStartStudy: new FormControl(this.directionOfEducationInput.yearStartStudy, Validators.required)
    });
  }
  public sendForm(): void {
    this.directionOfEducationOutput.emit(this.directionOfEducationForm.value);
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
