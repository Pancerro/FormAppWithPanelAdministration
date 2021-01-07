import {Component, OnDestroy, OnInit} from '@angular/core';
import { Charts } from 'src/app/model/charts';
import { AdminService } from '../../service/admin.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit, OnDestroy {
  constructor(private adminService: AdminService) { }
  private sub: Subscription[] = [];
  public countUniqueUser: string;
  public countUser: string;
  public countProject: string;
  public countDepartments: string;
  public countCourses: string;
  ngOnInit() {
    this.sub.push(this.adminService.getMember().subscribe(member =>{
      this.countUser = member.length.toString();
      const unique = [...new Set(member.map(item => item.basicInformation.pesel))];
      this.countUniqueUser = unique.length.toString();
    }));
    this.sub.push(this.adminService.getProject().subscribe(project =>
      this.countProject = project.length.toString()));
    this.sub.push(this.adminService.getUniversityDepartments().subscribe(departments =>
      this.countDepartments = departments.length.toString()));
    this.sub.push(this.adminService.getUniversityCourses().subscribe(courses =>
      this.countCourses = courses.length.toString()));
  }
  ngOnDestroy() {
    this.sub.forEach(sub => sub.unsubscribe());
  }
}
