import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-panel',
  templateUrl: './panel.component.html',
  styleUrls: ['./panel.component.css']
})
export class PanelComponent implements OnInit {
  select: boolean[] = [true];
  constructor() { }
  ngOnInit() { }

  public viewSummary(): void {
    this.select = [];
    this.select[0] = true;
  }
  public viewDepartment(): void {
    this.select = [];
    this.select[1] = true;
  }

  public viewUser(): void {
    this.select = [];
    this.select[2] = true;
  }
  public viewProject(): void {
    this.select = [];
    this.select[3] = true;
  }
  public viewOptions(): void {
    this.select = [];
    this.select[4] = true;
  }

   scroll(id: string) {
    const htmlElement = document.getElementById(id);
    htmlElement.scrollIntoView({behavior: 'smooth'});
   }
}
