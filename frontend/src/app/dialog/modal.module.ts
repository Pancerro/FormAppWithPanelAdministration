import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { YesOrNotModalComponent } from './yes-or-not-modal/yes-or-not-modal.component';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AddOrEditMemberModalComponent } from './add-or-edit-member-modal/add-or-edit-member-modal.component';
import {BasicInformationFormComponent} from './form/basic-information-form/basic-information-form.component';
import {ContactDetailsFormComponent} from './form/contact-details-form/contact-details-form.component';
import {LaborMarketStatusFormComponent} from './form/labor-market-status-form/labor-market-status-form.component';
import {DirectionOfEducationFormComponent} from './form/direction-of-education-form/direction-of-education-form.component';
import {AdditionalInformationFormComponent} from './form/additional-information-form/additional-information-form.component';
import {StatementFormComponent} from './form/statement-form/statement-form.component';
import {GroupFormComponent} from './form/group-form/group-form.component';
import { StartFormComponent } from './form/start-form/start-form.component';
import { AddOrEditUniversityDepartmentsModalComponent } from './add-or-edit-university-departments-modal/add-or-edit-university-departments-modal.component';
import { AddOrEditUniversityCoursesModalComponent } from './add-or-edit-university-courses-modal/add-or-edit-university-courses-modal.component';
import { AddOrEditProjectComponent } from './add-or-edit-project/add-or-edit-project.component';
import { EditSaveToProjectComponent } from './edit-save-to-project/edit-save-to-project.component';
import { PreviewComponent } from './preview/preview.component';
import {SafeHtmlPipe} from '../pipe/safe-html.pipe';
import { ChangePasswordComponent } from './change-password/change-password.component';



@NgModule({
  // tslint:disable-next-line:max-line-length
  declarations: [SafeHtmlPipe, YesOrNotModalComponent, AddOrEditMemberModalComponent, BasicInformationFormComponent, ContactDetailsFormComponent, LaborMarketStatusFormComponent, DirectionOfEducationFormComponent, AdditionalInformationFormComponent, StatementFormComponent, GroupFormComponent, StartFormComponent, AddOrEditUniversityDepartmentsModalComponent, AddOrEditUniversityCoursesModalComponent, AddOrEditProjectComponent, EditSaveToProjectComponent, PreviewComponent, PreviewComponent, ChangePasswordComponent],
  exports: [
    YesOrNotModalComponent,
    AddOrEditMemberModalComponent,
    GroupFormComponent,
    AddOrEditUniversityDepartmentsModalComponent,
    AddOrEditUniversityCoursesModalComponent,
    AddOrEditProjectComponent,
    EditSaveToProjectComponent,
    PreviewComponent,
    SafeHtmlPipe,
    ChangePasswordComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class ModalModule { }
