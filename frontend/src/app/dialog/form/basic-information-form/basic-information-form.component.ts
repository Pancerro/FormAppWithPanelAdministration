import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Education} from '../../../model/enumPack/education.enum';
import {BasicInformation} from '../../../model/member/basic-information';
import {Subject, Subscription} from 'rxjs';

@Component({
  selector: 'app-basic-information-form',
  templateUrl: './basic-information-form.component.html',
  styleUrls: ['./basic-information-form.component.css']
})
export class BasicInformationFormComponent implements OnInit, OnDestroy {
  constructor() { }
  @Input() basicInformationInput: BasicInformation;
  @Input() editSubject: Subject<void>;
  @Input() editMode: boolean;
  @Output() basicInformationOutput =  new EventEmitter<BasicInformation>();
  @Output() nextStep = new EventEmitter<number>();
  private step = 1;
  private sub: Subscription = new Subscription();
  public enumEducation = Education;
  public basicInformationForm: FormGroup;
  ngOnInit() {
    if (this.editMode) { this.sub = this.editSubject.subscribe(() => this.sendForm()); }
    this.basicInformationForm = new FormGroup({
      idBasic: new FormControl(this.basicInformationInput.idBasic),
      name: new FormControl(this.basicInformationInput.name, Validators.required),
      surname: new FormControl(this.basicInformationInput.surname, Validators.required),
      // tslint:disable-next-line:max-line-length
      pesel: new FormControl(this.basicInformationInput.pesel, [ Validators.required, Validators.minLength(11), Validators.maxLength(11), Validators.pattern('[0-9]+')]),
      idNumber: new FormControl(this.basicInformationInput.idNumber, Validators.required),
      age: new FormControl(this.basicInformationInput.age, [ Validators.min(0), Validators.max(130)]),
      education: new FormControl(this.basicInformationInput.education, Validators.required)
    });
  }

  public sendForm(): void {
    this.basicInformationOutput.emit(this.basicInformationForm.value);
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
