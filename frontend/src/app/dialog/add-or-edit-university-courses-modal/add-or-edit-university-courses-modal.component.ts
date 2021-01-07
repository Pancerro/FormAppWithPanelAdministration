import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {UniversityDepartments} from '../../model/university-departments';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {UniversityCourses} from '../../model/university-courses';

@Component({
  selector: 'app-add-or-edit-university-courses-modal',
  templateUrl: './add-or-edit-university-courses-modal.component.html',
  styleUrls: ['./add-or-edit-university-courses-modal.component.css']
})
export class AddOrEditUniversityCoursesModalComponent implements OnInit, OnChanges {
  @Input() universityCourses: UniversityCourses;
  @Input() editMode: boolean;
  @Input() universityDepartments: UniversityDepartments[];
  @Output() newCourses = new EventEmitter<UniversityCourses>();
  public coursesForm: FormGroup;
  constructor() { }
  ngOnInit() {
    this.coursesForm = new FormGroup({
      idCourses: new FormControl(this.universityCourses.idCourses),
      nameCourses: new FormControl(this.universityCourses.nameCourses, Validators.required),
      universityDepartments: new FormControl(this.universityCourses.universityDepartments.idDepartments, Validators.required),
    });
  }
  ngOnChanges(changes: SimpleChanges) {
    this.coursesForm = new FormGroup({
      idCourses: new FormControl(this.universityCourses.idCourses),
      nameCourses: new FormControl(this.universityCourses.nameCourses, Validators.required),
      universityDepartments: new FormControl(this.universityCourses.universityDepartments.idDepartments, Validators.required),
    });
  }

  private sendForm(): void {
    document.getElementById('closeModalCoursesButton').click();
    this.newCourses.emit(this.coursesForm.getRawValue());
  }

}
