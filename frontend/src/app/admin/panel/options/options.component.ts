import {Component, OnDestroy, OnInit} from '@angular/core';
import {AdminService} from '../../service/admin.service';
import {Subject, Subscription} from 'rxjs';
import {AcceptEmail} from '../../../model/message/accept-email';
import {WebStarterDesc} from '../../../model/message/web-starter-desc';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-options',
  templateUrl: './options.component.html',
  styleUrls: ['./options.component.css']
})
export class OptionsComponent implements OnInit, OnDestroy {

  constructor(private adminService: AdminService) { }
  private sub: Subscription[] = [];
  private subjectWebStarterDesc = new Subject<void>();
  private subjectAcceptEmail = new Subject<void>();
  public viewWebStarterDesc = true;
  public viewAcceptEmail = true;
  public acceptEmail: AcceptEmail;
  public webStarterDesc: WebStarterDesc;
  public acceptEmailForm: FormGroup;
  public webStartDescForm: FormGroup;
  public error: string;
  public disabledEmail = true;
  public disabledWeb = true;
  ngOnInit() {
    this.sub.push(this.subjectWebStarterDesc.subscribe(() => {
      this.viewWebStarterDesc = true;
      this.getWebStarterDesc();
    }));
    this.sub.push(this.subjectAcceptEmail.subscribe(() => {
      this.viewAcceptEmail = true;
      this.getAcceptEmail();
    }));
    this.subjectWebStarterDesc.next();
    this.subjectAcceptEmail.next();
  }
  private getWebStarterDesc(): void {
    this.adminService.getWebStarterDesc().subscribe((webStarterDesc: WebStarterDesc) => {
      this.webStarterDesc = webStarterDesc;
      this.setWebStarterDescForm(webStarterDesc);
      this.viewWebStarterDesc = false;
      }, err => {
      this.error = err.response;
      this.viewWebStarterDesc = false;
      }, () => this.viewWebStarterDesc = false
    );
  }
  private getAcceptEmail(): void {
    this.adminService.getAcceptEmail().subscribe((acceptEmail: AcceptEmail) => {
        this.acceptEmail = acceptEmail;
        this.setAcceptEmailForm(acceptEmail);
        this.viewAcceptEmail = false;
      }, err => {
        this.error = err.response;
        this.viewAcceptEmail = false;
      }, () => this.viewAcceptEmail = false
    );
  }
  public editAcceptEmail(): void {
    this.disabledEmail = !this.disabledEmail;
  }
  public saveAcceptEmail(): void {
    this.adminService.editAcceptEmail(this.acceptEmailForm.getRawValue()).subscribe(() =>
    this.subjectAcceptEmail.next(),err => {
      this.error = err.response;
    });
  }

  public editWeb(): void {
    this.disabledWeb = !this.disabledWeb;
  }
  public saveWeb(): void {
    this.adminService.editWebStarterDesc(this.webStartDescForm.getRawValue()).subscribe(() =>
      this.subjectWebStarterDesc.next(),err => {
      this.error = err.response;
    } );
  }
  public newPassword(password): void {
    this.adminService.changePassword(password.password).subscribe( () => {}, err => {
      this.error = err.response;
    });
  }
  public clearError(): void {
    this.error = null;
  }
  private setAcceptEmailForm(acceptEmail: AcceptEmail): void {
    this.acceptEmailForm = new FormGroup({
      idEmail: new FormControl(acceptEmail.idEmail) ,
      subjectEmail: new FormControl(acceptEmail.subjectEmail, Validators.required),
      textEmail: new FormControl(acceptEmail.textEmail, Validators.required),
      html: new FormControl(acceptEmail.html, Validators.required),
    });
  }
  private setWebStarterDescForm(webStarterDesc: WebStarterDesc): void {
    this.webStartDescForm = new FormGroup({
      id: new FormControl(webStarterDesc.id) ,
      subject: new FormControl(webStarterDesc.subject, Validators.required),
      text: new FormControl(webStarterDesc.text, Validators.required),
      html: new FormControl(webStarterDesc.html, Validators.required),
    });
  }
  ngOnDestroy() {
      this.sub.forEach((sub: Subscription) => sub.unsubscribe());
  }
}
