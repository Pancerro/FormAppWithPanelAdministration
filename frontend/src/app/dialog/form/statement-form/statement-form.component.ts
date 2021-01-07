import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Statement} from '../../../model/member/statement';
import {Subject, Subscription} from 'rxjs';

@Component({
  selector: 'app-statement-form',
  templateUrl: './statement-form.component.html',
  styleUrls: ['./statement-form.component.css']
})
export class StatementFormComponent implements OnInit, OnDestroy {
  constructor() { }
  @Input() statementInput: Statement;
  @Input() editMode: boolean;
  @Input() editSubject: Subject<void>;
  @Output() statementOutput =  new EventEmitter<Statement>();
  @Output() nextStep = new EventEmitter<number>();
  @Output() send = new EventEmitter<boolean>();
  private step = 6;
  private sub: Subscription = new Subscription();
  public statementForm: FormGroup;
  ngOnInit() {
    if (this.editMode) { this.sub = this.editSubject.subscribe(() => this.sendForm()); }
    this.statementForm = new FormGroup({
      idStatement: new FormControl(this.statementInput.idStatement),
      homelessPerson: new FormControl(this.statementInput.homelessPerson, Validators.required),
      // tslint:disable-next-line:max-line-length
      anotherUnfavorablePersonSocialSituation: new FormControl(this.statementInput.anotherUnfavorablePersonSocialSituation, Validators.required),
      statement: new FormControl(this.statementInput.statement, Validators.required),
    });
  }
  public sendForm(): void {
    this.statementOutput.emit(this.statementForm.value);
  }
  public previous(): void {
    this.sendForm();
    this.nextStep.emit(this.step - 1);
  }
  public endForm(): void {
    this.sendForm();
    this.send.emit(true);
  }
  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}
