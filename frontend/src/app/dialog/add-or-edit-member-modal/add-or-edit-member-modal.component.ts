import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Member} from '../../model/member';
import {Subject} from 'rxjs';

@Component({
  selector: 'app-edit-member-modal',
  templateUrl: './add-or-edit-member-modal.component.html',
  styleUrls: ['./add-or-edit-member-modal.component.css']
})
export class AddOrEditMemberModalComponent implements OnInit {
  @Input() editMember: Member;
  @Input() editMode: boolean;
  @Input() viewForm: boolean[];
  @Output() newMember = new EventEmitter<Member>();
  editMemberSubject = new Subject<string>();
  constructor() { }
  ngOnInit() {
  }

  private sendForm(): void {
    this.editMemberSubject.next();
    document.getElementById('closeModalCoursesButton').click();
    this.newMember.emit();
  }

}
