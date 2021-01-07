import {Component, Input, OnInit} from '@angular/core';
import {AcceptEmail} from '../../model/message/accept-email';

@Component({
  selector: 'app-preview',
  templateUrl: './preview.component.html',
  styleUrls: ['./preview.component.css']
})
export class PreviewComponent implements OnInit {
  @Input() htmlText: string;
  @Input() isHtml: boolean;
  @Input() id: string;
  public blocked = true;
  constructor() { }

  ngOnInit() {
    if (window.innerWidth <= 1000) {
      this.blocked = false;
    }
  }

}
