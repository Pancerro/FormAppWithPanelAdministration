import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';

import {FormControl, FormGroup, Validators} from '@angular/forms';
import {UniversityDepartments} from '../../model/university-departments';

@Component({
  selector: 'app-add-or-edit-university-departments-modal',
  templateUrl: './add-or-edit-university-departments-modal.component.html',
  styleUrls: ['./add-or-edit-university-departments-modal.component.css']
})
export class AddOrEditUniversityDepartmentsModalComponent implements OnInit, OnChanges {
  @Input() universityDepartments: UniversityDepartments;
  @Input() editMode: boolean;
  @Output() newDepartment = new EventEmitter<UniversityDepartments>();
  public departmentsForm: FormGroup;
  constructor() { }
  ngOnInit() {
    this.setDepartmentForm();
  }
  ngOnChanges(changes: SimpleChanges) {
    this.setDepartmentForm();
  }
  private sendForm(): void {
    document.getElementById('closeModalButton').click();
    this.newDepartment.emit(this.departmentsForm.getRawValue());
  }
  private setDepartmentForm(): void {
    this.departmentsForm = new FormGroup({
      idDepartments: new FormControl(this.universityDepartments.idDepartments),
      nameDepartments: new FormControl(this.universityDepartments.nameDepartments, Validators.required),
      shortcut: new FormControl(this.universityDepartments.shortcut, Validators.required),
    });
  }
}
