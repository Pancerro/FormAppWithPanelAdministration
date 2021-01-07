import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {Project} from '../../model/project';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {SaveMemberToProject} from '../../model/save-member-to-project';

@Component({
  selector: 'app-edit-save-to-project',
  templateUrl: './edit-save-to-project.component.html',
  styleUrls: ['./edit-save-to-project.component.css']
})
export class EditSaveToProjectComponent implements OnInit, OnChanges {
  @Input() saveMemberToProject: SaveMemberToProject;
  @Input() editMode: boolean;
  @Input() projectList: Project[];
  @Output() newSaveMemberToProject = new EventEmitter<SaveMemberToProject>();
  public saveMemberToProjectForm: FormGroup;
  constructor() { }
  ngOnInit() {
    this.setSaveMemberToProject();
  }
  ngOnChanges(changes: SimpleChanges) {
    this.setSaveMemberToProject();
  }
  private sendForm(): void {
      const editValue: SaveMemberToProject = {
        idSave: this.saveMemberToProject.idSave,
        member: this.saveMemberToProject.member,
        project: this.projectList[this.saveMemberToProjectForm.getRawValue().project - 1]
      };
      document.getElementById('closeModalButtonSaveMemberToProject').click();
      this.newSaveMemberToProject.emit(editValue);
  }
  private setSaveMemberToProject() {
    this.saveMemberToProjectForm = new FormGroup({
      idSave: new FormControl(this.saveMemberToProject.idSave ),
      project: new FormControl(this.saveMemberToProject.project.idProject, Validators.required),
    });
  }
}
