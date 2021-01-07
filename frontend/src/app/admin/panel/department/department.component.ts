import {Component, OnDestroy, OnInit} from '@angular/core';
import { AdminService } from '../../service/admin.service';
import {UniversityCourses} from '../../../model/university-courses';
import {UniversityDepartments} from '../../../model/university-departments';
import {ExportAsConfig, ExportAsService} from 'ngx-export-as';
import {Subject, Subscription} from 'rxjs';
import {Charts} from '../../../model/charts';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit, OnDestroy {

  constructor(private adminService: AdminService, private exportAsService: ExportAsService ) { }
  private subject = new Subject<void>();
  private sub: Subscription = new Subscription();
  public universityDepartments: UniversityDepartments[] = [];
  public deleteAllUniversityDepartment: number[] = [];
  public removeOneUniversityDepartment: UniversityDepartments;
  public editUniversityDepartment: UniversityDepartments;
  public editModeUniversityDepartments: boolean;
  public viewUniversityDepartments = true;
  public checkedDepartment = [false];
  public selectDepartment = false;
  public extendDepartment: boolean[] = [];
  public extendAllOrNot = true;
  public universityCourses: UniversityCourses[] = [];
  public deleteAllUniversityCourses: number[] = [];
  public removeOneUniversityCourses: UniversityCourses;
  public editUniversityCourses: UniversityCourses;
  public editModeUniversityCourses: boolean;
  public checkedCourses = [false];
  public selectCourses = [false];
  public searchInCourses: string;
  public searchText: string;
  public hideColumn = [];
  public error: string;
  public chartsCoursesInDepartments: Charts[] = [];
  public viewChartCoursesInDepartments = true;
  public viewChart = true;
  public viewExportColumn = false;
  public checked = false;
  public exportType = null;
  public colorType = null;
  ngOnInit() {
    this.setCourses();
    this.setDepartment();
    this.sub = this.subject.subscribe(() => {
      this.viewChartCoursesInDepartments = true;
      this.viewUniversityDepartments = true;
      this.getCharts();
      this.getUniversityCourses();
      this.getUniversityDepartments();
  });
    this.subject.next();
  }
  public export(type: any, id): void {
    const exportAsConfig: ExportAsConfig = {
      type,
      elementIdOrContent: id
    };
    this.exportAsService.save(exportAsConfig, 'departmentAndCourses').subscribe(() => {},
      () => this.error = 'Nie udalo sie wyeksportowac');
  }

  public clearError(): void {
    this.error = null;
  }

  public addModeUniversityDepartment(): void {
    this.editModeUniversityDepartments = false;
    this.setDepartment();
  }

  public editItemDepartments(department: UniversityDepartments): void {
    this.editModeUniversityDepartments = true;
    this.editUniversityDepartment = department;
    // tslint:disable-next-line:new-parens
    this.editUniversityDepartment = {
      idDepartments : department.idDepartments,
      nameDepartments: department.nameDepartments,
      shortcut: department.shortcut
    };
  }

  public addOrEditDepartment(event): void {
    if (this.editModeUniversityDepartments) {
      this.adminService.editUniversityDepartment(event).subscribe(() => {
        this.subject.next();
      }, err => {
        this.error = err.status;
      });
    } else {
      this.adminService.addUniversityDepartment(event).subscribe(() => {
        this.subject.next();
      }, err => {
        this.error = err.status;
      });
    }
  }
  public selectAllToDeleteDepartments(): void {
    if (this.selectDepartment) {
      for (let i = 0; i < this.checkedCourses.length; i++) {
        this.checkedCourses[i] = false;
      }
      for (let i = 0; i < this.selectCourses.length; i++) {
        this.selectCourses[i] = false;
      }
      for (let i = 0; i < this.checkedDepartment.length; i++) {
        this.checkedDepartment[i] = false;
      }
      this.deleteAllUniversityDepartment = [];
      this.deleteAllUniversityCourses = [];
    } else {
      for (let i = 0; i < this.checkedCourses.length; i++) {
        this.checkedCourses[i] = true;
      }
      for (let i = 0; i < this.selectCourses.length; i++) {
        this.selectCourses[i] = true;
      }
      for ( let i = 0; i < this.checkedDepartment.length; i++) {
        this.checkedDepartment[i] = true;
      }
      this.universityCourses.forEach((courses) => this.deleteAllUniversityCourses.push(courses.idCourses));
      this.universityDepartments.forEach((department) => this.deleteAllUniversityDepartment.push(department.idDepartments));
    }
  }
  public addDeleteDepartments(idDepartments: number): void {
    if (this.checkedDepartment[idDepartments]) {
      this.deleteFromDeleteDepartment(idDepartments);
      this.checkedDepartment[idDepartments] = false;
      this.checkedCourses[idDepartments] = false;
      this.selectDepartment = false;
      this.selectAllToDeleteCourses(idDepartments);
    } else {
      this.checkedDepartment[idDepartments] = true;
      this.checkedCourses[idDepartments] = true;
      this.deleteAllUniversityDepartment.push(idDepartments);
      this.selectAllToDeleteCourses(idDepartments);
    }
  }

  private deleteFromDeleteDepartment(idDepartment: number): void {
    this.deleteAllUniversityDepartment = this.deleteAllUniversityDepartment.filter(id => id !== idDepartment);
  }

  public removeItemDepartment(department: UniversityDepartments): void {
    this.removeOneUniversityDepartment = department;
  }
  public removeDepartment(id: number): void {
    this.deleteFromDeleteDepartment(id);
    this.universityCourses.forEach((courses) => {
      if (courses.universityDepartments.idDepartments === id) {
        this.adminService.deleteUniversityCourses(courses.idCourses).subscribe(
          () => this.subject.next(),
          err => {
            this.error = err.status;
          }
        );
      }
    });
    this.adminService.deleteUniversityDepartment(id).subscribe(
      () => this.subject.next(),
      err => {
        this.error = err.status;
      }
    );
  }
  public deleteAllDepartments(): void {
    this.deleteAllUniversityDepartment.forEach(id => this.removeDepartment(id));
  }
  public addModeUniversityCourses(): void {
    this.editModeUniversityCourses = false;
    this.setCourses();
  }
  public editItemCourses(courses: UniversityCourses): void {
    this.editModeUniversityCourses = true;
    this.editUniversityCourses = Object.create(courses);
  }

  public addOrEditCourses(newCourses: UniversityCourses): void {
    // tslint:disable-next-line:max-line-length
    newCourses.universityDepartments = this.universityDepartments.filter((department) => department.idDepartments === newCourses.universityDepartments)[0];
    if (this.editModeUniversityCourses) {
      this.adminService.editUniversityCourses(newCourses).subscribe(() => {
        this.subject.next();
      }, err => {
        this.error = err.status;
      });
    } else {
      this.adminService.addUniversityCourses(newCourses).subscribe(() => {
        this.subject.next();
      }, err => {
        this.error = err.status;
      });
    }
  }
  public selectAllToDeleteCourses(idDepartment: number): void {
    if (this.selectCourses[idDepartment]) {
      this.selectCourses[idDepartment] = false;
      this.checkedDepartment[idDepartment] = false;
      this.selectDepartment = false;
      this.deleteAllUniversityCourses = [];
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < this.universityCourses.length; i++) {
        if (this.universityCourses[i].universityDepartments.idDepartments === idDepartment) {
          this.checkedCourses[this.universityCourses[i].idCourses] = false;
        }
      }
    } else {
      this.selectCourses[idDepartment] = true;
      this.checkedDepartment[idDepartment] = true;
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < this.universityCourses.length; i++) {
          if (this.universityCourses[i].universityDepartments.idDepartments === idDepartment) {
            this.checkedCourses[this.universityCourses[i].idCourses] = true;
            this.deleteAllUniversityCourses.push(this.universityCourses[i].idCourses);
          }
        }
      }
  }
  public addDeleteCourses(idCourses: number, idDepartment: number): void {
    if (this.deleteAllUniversityCourses.includes(idCourses)) {
      this.checkedCourses[idCourses] = false;
      this.selectCourses[idDepartment] = false;
      this.checkedDepartment[idDepartment] = false;
      this.selectDepartment = false;
      this.deleteFromDeleteDepartment(idDepartment);
      this.deleteFromDeleteCourses(idCourses);
    } else {
      this.deleteAllUniversityCourses.push(idCourses);
      this.checkedCourses[idCourses] = true;

    }
  }

  private deleteFromDeleteCourses(idCourses: number): void {
    this.deleteAllUniversityCourses = this.deleteAllUniversityCourses.filter(id => id !== idCourses);
  }

  public removeItemCourses(courses: UniversityCourses): void {
    this.removeOneUniversityCourses = courses;
  }
  public removeCourses(id: number): void {
    this.deleteFromDeleteCourses(id);
    this.adminService.deleteUniversityCourses(id).subscribe(
      () => this.subject.next(),
      err => {
        this.error = err.status;
      }
    );
  }
  public deleteAllCourses(): void {
    this.deleteAllUniversityCourses.forEach(id => this.removeCourses(id));
  }

  public extend(idDepartment: number): void {
    this.extendDepartment[idDepartment] = !this.extendDepartment[idDepartment];
  }
  public extendAll(): void {
    if (this.extendAllOrNot) {
      for (let i = 1; i <= this.universityDepartments.length; i++) {
        this.extendDepartment[i] = true;
      }
    }
    if (!this.extendAllOrNot) {
      for (let i = 1; i <= this.universityDepartments.length; i++) {
        this.extendDepartment[i] = false;
      }
    }
    this.extendAllOrNot = !this.extendAllOrNot;
  }

  public hideExportColumn(id: number) {
    this.hideColumn[id] = !this.hideColumn[id];
  }
  public extendExportColumn() {
    this.viewExportColumn = !this.viewExportColumn;
  }
  public hideAllExportColumn() {
    for (let i = 0; i < 66; i++) {
      this.hideColumn[i] = true;
    }
  }
  public showAllExportColumn() {
    for (let i = 0; i < 66; i++) {
      this.hideColumn[i] = false;
    }
  }
  public extendCharts(): void {
    this.viewChart = !this.viewChart;
  }
  private getCharts(): void {
    this.adminService.getChartsCourses().subscribe((chart: Charts[]) => {
      this.chartsCoursesInDepartments = chart;
      this.viewChartCoursesInDepartments = false;
    }, err => {
      this.error = err.response;
      this.viewChartCoursesInDepartments = false;
    }, () => this.viewChartCoursesInDepartments = false);
  }
  private getUniversityCourses(): void {
    this.adminService.getUniversityCourses().subscribe((universityCourses: UniversityCourses[]) => {
      this.universityCourses = universityCourses;
      // tslint:disable-next-line:no-shadowed-variable
      universityCourses.forEach((universityCourses: UniversityCourses) => {
        this.checkedCourses[universityCourses.idCourses] = false;
      });
    }, err => {
      this.error = err.response;
    });
  }
  private getUniversityDepartments(): void {
    this.adminService.getUniversityDepartments().subscribe((universityDepartments: UniversityDepartments[]) => {
      this.universityDepartments = universityDepartments;
      this.viewUniversityDepartments = false;
      // tslint:disable-next-line:no-shadowed-variable
      universityDepartments.forEach(universityDepartments => {
        this.checkedDepartment[universityDepartments.idDepartments] = false;
        this.selectCourses[universityDepartments.idDepartments] = false;
      });
    }, err => {
      this.error = err.response;
      this.viewUniversityDepartments = false;
    }, () => this.viewUniversityDepartments = false);
  }
  private setDepartment(): void {
    this.editUniversityDepartment = {
      idDepartments: null,
      nameDepartments: null,
      shortcut: null
    };
  }
  private setCourses(): void {
    this.editUniversityCourses = {
      nameCourses: null,
      universityDepartments: {
        nameDepartments: null,
        shortcut: null
      }
    };
  }
  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
