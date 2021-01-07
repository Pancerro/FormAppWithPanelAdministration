import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-yes-or-not-modal',
  templateUrl: './yes-or-not-modal.component.html',
  styleUrls: ['./yes-or-not-modal.component.css']
})
export class YesOrNotModalComponent implements OnInit {
  @Input() title: string;
  @Input() description: string;
  @Input() background: string;
  @Input() id: string;
  @Output() clickYes = new EventEmitter<void>();
  constructor() { }
  ngOnInit() {
  }

  sendForm() {
    this.clickYes.emit();
  }
}
