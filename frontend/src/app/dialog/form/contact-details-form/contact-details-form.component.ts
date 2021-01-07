import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';

import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ContactDetails} from '../../../model/member/contact-details';
import {Voivodeship} from '../../../model/enumPack/voivodeship.enum';
import {Area} from '../../../model/enumPack/area.enum';
import {Subject, Subscription} from 'rxjs';

@Component({
  selector: 'app-contact-details-form',
  templateUrl: './contact-details-form.component.html',
  styleUrls: ['./contact-details-form.component.css']
})
export class ContactDetailsFormComponent implements OnInit, OnDestroy {
  @Input() contactDetailsInput: ContactDetails;
  @Input() editSubject: Subject<void>;
  @Input() editMode: boolean;
  @Output() contactDetailsOutput =  new EventEmitter<ContactDetails>();
  @Output() nextStep = new EventEmitter<number>();
  private step = 2;
  private sub: Subscription = new Subscription();
  public enumVoivodeship = Voivodeship;
  public enumArea = Area;
  public contactDetailsForm: FormGroup;
  ngOnInit() {
    if (this.editMode) { this.sub = this.editSubject.subscribe(() => this.sendForm()); }
    this.contactDetailsForm = new FormGroup({
      idContact: new FormControl(this.contactDetailsInput.idContact),
      street: new FormControl(this.contactDetailsInput.street, Validators.required),
      houseNumber: new FormControl(this.contactDetailsInput.houseNumber, Validators.required),
      township: new FormControl(this.contactDetailsInput.township, Validators.required),
      postOffice: new FormControl(this.contactDetailsInput.postOffice, Validators.required),
      postalCode: new FormControl(this.contactDetailsInput.postalCode, [ Validators.required, Validators.pattern('[0-9]{2}\-[0-9]{3}')]),
      community: new FormControl(this.contactDetailsInput.community, Validators.required),
      district: new FormControl(this.contactDetailsInput.district, Validators.required),
      voivodeship: new FormControl(this.contactDetailsInput.voivodeship, Validators.required),
      area: new FormControl(this.contactDetailsInput.area, Validators.required),
      phoneNumber: new FormControl(this.contactDetailsInput.phoneNumber, [Validators.required, Validators.min(0)]),
      email: new FormControl(this.contactDetailsInput.email,[Validators.required, Validators.email])
    });
  }
  public sendForm(): void {
    this.contactDetailsOutput.emit(this.contactDetailsForm.value);
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
