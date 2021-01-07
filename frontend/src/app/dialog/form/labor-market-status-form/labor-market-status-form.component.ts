import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {LaborMarketStatus} from '../../../model/member/labor-market-status';
import {Subject, Subscription} from 'rxjs';

@Component({
  selector: 'app-labor-market-status-form',
  templateUrl: './labor-market-status-form.component.html',
  styleUrls: ['./labor-market-status-form.component.css']
})
export class LaborMarketStatusFormComponent implements OnInit, OnDestroy {
  constructor() { }
  @Input() laborMarketStatusInput: LaborMarketStatus;
  @Input() editSubject: Subject<void>;
  @Input() editMode: boolean;
  @Output() laborMarketStatusOutput =  new EventEmitter<LaborMarketStatus>();
  @Output() nextStep = new EventEmitter<number>();
  private step = 3;
  private sub: Subscription = new Subscription();
  public laborMarketStatusForm: FormGroup;
  ngOnInit() {
    if (this.editMode) { this.sub = this.editSubject.subscribe(() => this.sendForm()); }
    this.laborMarketStatusForm = new FormGroup({
      idLaborMarketStatus: new FormControl(this.laborMarketStatusInput.idLaborMarketStatus),
      unemployedPerson: new FormControl(this.laborMarketStatusInput.unemployedPerson),
      longTermUnemployed: new FormControl(this.laborMarketStatusInput.longTermUnemployed),
      professionallyInactive: new FormControl(this.laborMarketStatusInput.professionallyInactive),
      learningPerson: new FormControl(this.laborMarketStatusInput.learningPerson),
      notLearningPerson: new FormControl(this.laborMarketStatusInput.notLearningPerson),
      other: new FormControl(this.laborMarketStatusInput.other),
      working: new FormControl(this.laborMarketStatusInput.working),
      selfEmployed: new FormControl(this.laborMarketStatusInput.selfEmployed),
      // tslint:disable-next-line:max-line-length
      employedInMicroSmallMediumEnterprise: new FormControl(this.laborMarketStatusInput.employedInMicroSmallMediumEnterprise),
      employedInBigEnterprise: new FormControl(this.laborMarketStatusInput.employedInBigEnterprise),
      // tslint:disable-next-line:max-line-length
      employedInGovernmentAdministration: new FormControl(this.laborMarketStatusInput.employedInGovernmentAdministration),
      // tslint:disable-next-line:max-line-length
      employedInLocalGovernmentAdministration: new FormControl(this.laborMarketStatusInput.employedInLocalGovernmentAdministration),
      // tslint:disable-next-line:max-line-length
      employedInNonGovernmentalOrganization: new FormControl(this.laborMarketStatusInput.employedInNonGovernmentalOrganization),
      nameOfWorkplace: new FormControl(this.laborMarketStatusInput.nameOfWorkplace),
      occupationPerformed: new FormControl(this.laborMarketStatusInput.occupationPerformed),
      nationalMinority: new FormControl(this.laborMarketStatusInput.nationalMinority),
      emigrant: new FormControl(this.laborMarketStatusInput.emigrant),
      disabledPerson: new FormControl(this.laborMarketStatusInput.disabledPerson),
    });
  }
  public sendForm(): void {
    this.laborMarketStatusOutput.emit(this.laborMarketStatusForm.value);
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
