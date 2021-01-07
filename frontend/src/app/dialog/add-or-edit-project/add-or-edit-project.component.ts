import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {UniversityDepartments} from '../../model/university-departments';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Project} from '../../model/project';

@Component({
  selector: 'app-add-or-edit-project',
  templateUrl: './add-or-edit-project.component.html',
  styleUrls: ['./add-or-edit-project.component.css']
})
export class AddOrEditProjectComponent implements OnInit, OnChanges {
  @Input() project: Project;
  @Input() editMode: boolean;
  @Output() newProject = new EventEmitter<Project>();
  public projectForm: FormGroup;
  constructor() { }
  ngOnInit() {
    this.setProjectForm();
  }
  ngOnChanges(changes: SimpleChanges) {
    this.setProjectForm();
  }
  private sendForm(): void {
    const dataStart = new Date(this.projectForm.getRawValue().dataStart);
    const dataEnd = new Date(this.projectForm.getRawValue().dataEnd);
    if (dataStart.getTime() > dataEnd.getTime() && dataEnd.getTime() < dataStart.getTime()){
      window.alert('Nieprawidlowy zakres czasu');
    } else {
      document.getElementById('closeModalButton').click();
      this.newProject.emit(this.projectForm.getRawValue());
    }
  }
  private setProjectForm() {
    this.projectForm = new FormGroup({
      idProject: new FormControl(this.project.idProject),
      nameProject: new FormControl(this.project.nameProject, Validators.required),
      descriptionProject: new FormControl(this.project.descriptionProject, Validators.required),
      dataStart: new FormControl(this.project.dataStart, Validators.required),
      dataEnd: new FormControl(this.project.dataEnd, Validators.required),
      active: new FormControl(this.project.active, Validators.required),
    });
  }
}
