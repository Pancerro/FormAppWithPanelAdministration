import { Component, OnDestroy, OnInit} from '@angular/core';
import { AdminService } from '../../service/admin.service';
import {Member} from '../../../model/member';
import {Subject, Subscription} from 'rxjs';
import {ExportAsConfig, ExportAsService} from 'ngx-export-as';
import {first} from 'rxjs/operators';
import {Project} from '../../../model/project';
import {Charts} from '../../../model/charts';

@Component({
  selector: 'app-user',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent implements OnInit, OnDestroy {
  constructor(private adminService: AdminService, private exportAsService: ExportAsService ) {}
  private activeProject: Project[];
  private subject = new Subject<void>();
  private sub: Subscription = new Subscription();
  public deleteMember: number[] = [];
  public removeMember: Member;
  public editMember: Member;
  public error: string;
  public editMode: boolean;
  public searchText: string;
  public filter: string;
  public filtrateTable: string[] = [];
  public viewTable = true;
  public viewAgeChart = true;
  public viewSexChart = true;
  public viewEducationChart = true;
  public viewAreaChart = true;
  public viewChart = true;
  public viewExportColumn = false;
  public checked = false;
  public select = false;
  public member: Member[];
  public viewForm = [true, false, false, false, false, false, false];
  public chartsAgeToPeople: Charts[] = [];
  public chartsSexInMember: Charts[] = [];
  public chartsEducationInMember: Charts[] = [];
  public chartsAreaInMember: Charts[] = [];
  public extendMember: boolean[] = [];
  public extendAllOrNot = true;
  public exportType = null;
  public colorType = null;
  private copyMember: Member[];
  public hideColumn = [];
  ngOnInit() {
    this.adminService.getActiveProject().pipe(first()).subscribe((project: Project[]) => {
      this.activeProject = project;
    });
    this.setMember();
    this.sub = this.subject.subscribe(() => {
      this.getChartsAge();
      this.getChartsSex();
      this.getChartsEducation();
      this.getChartsArea();
      this.getMember();
    });
    this.subject.next();
  }

  public export(type: any, id): void {
    const exportAsConfig: ExportAsConfig = {
      type,
      elementIdOrContent: id
    };
    this.exportAsService.save(exportAsConfig, 'member').subscribe(() => {},
      () => this.error = 'Nie udalo sie wyeksportowac');
  }

  public extend(idMember: number): void {
    this.extendMember[idMember] = !this.extendMember[idMember];
  }
  public extendAll(): void {
    if (this.extendAllOrNot) {
      for (let i = 1; i <= this.member.length; i++) {
        this.extendMember[i] = true;
      }
    }
    if (!this.extendAllOrNot) {
      for (let i = 1; i <= this.member.length; i++) {
        this.extendMember[i] = false;
      }
    }
    this.extendAllOrNot = !this.extendAllOrNot;
  }
  public extendCharts(): void {
    this.viewChart = !this.viewChart;
  }
  public filterTable(filter: string): void {
    this.extendAll();
    if (this.filter === 'tak') {this.filter = 'true'; }
    if (this.filter === 'nie') {this.filter = 'false'; }
    if (this.filter === '-') {this.filter = ''; }
    const splitProperty = filter.toString().split('.');
    // tslint:disable-next-line:max-line-length
    this.member = this.member.filter(member => member[splitProperty[0]][splitProperty[1]].toString().toLocaleUpperCase() === this.filter.toLocaleUpperCase());
    this.filtrateTable.push(filter + ':' + this.filter);
  }
  public removeFilter(id: number): void {
    this.filtrateTable = this.filtrateTable.filter(filter => filter !== this.filtrateTable[id]);
    this.member = this.copyMember;
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.filtrateTable.length; i++) {
      const splitFilter =  this.filtrateTable[i].split(':');
      this.filter = splitFilter[1];
      const splitProperty = splitFilter[0].split('.');
      // tslint:disable-next-line:max-line-length
      this.member = this.member.filter(member => member[splitProperty[0]][splitProperty[1]].toString().toLocaleUpperCase() === this.filter.toLocaleUpperCase());
    }
  }
  public clearAllFilter(): void {
    this.member = this.copyMember;
    this.filtrateTable = [];
  }
  public filterExtendAll(): void {
    this.extendAllOrNot = true;
    this.extendAll();
  }
  public addMode(): void {
    this.viewForm = Object.create(this.viewForm);
    this.editMode = false;
    this.setMember();
  }
  private changeView(): void {
    this.viewTable = !this.viewTable;
    this.viewAgeChart = !this.viewAgeChart;
    this.viewSexChart = !this.viewSexChart;
    this.viewEducationChart = !this.viewEducationChart;
    this.viewAreaChart = !this.viewAreaChart;
  }
  public addOrEdit(): void {
    this.changeView();
    if (this.editMode) {
      this.adminService.editMember(this.editMember).subscribe(() => {
        this.subject.next();
      }, err => {
        this.error = err.status;
        this.changeView();
      });
    } else {
      this.adminService.addMember(this.editMember, this.activeProject[0].idProject).subscribe(() => {
        this.subject.next();
      }, err => {
        this.error = err.status;
        this.changeView();

      });
    }
  }
  public editItem(member: Member): void {
    this.editMode = true;
    this.editMember = Object.create(member);
    this.viewForm = Object.create(this.viewForm);
  }
  public remove(id: number): void {
    this.deleteFromDeleteMember(id);
    this.changeView();
    this.adminService.deleteMember(id).subscribe(
      () => this.subject.next(),
      err => {
        this.error = err.status;
        this.changeView();
      }
    );
  }
  public removeItem(member: Member): void {
    this.removeMember = member;
  }
  public deleteAll(): void {
    while (this.deleteMember.length > 0) {
      this.remove(this.deleteMember[0]);
    }
    this.select = false;
    this.deleteMember = [];
  }
  public addDeleteMember(member: Member): void {
    // tslint:disable-next-line:max-line-length
    if (this.deleteMember.includes(member.idMember)) { this.deleteFromDeleteMember(member.idMember); } else { this.deleteMember.push(member.idMember); }
  }
  private deleteFromDeleteMember(idMember: number): void {
    // tslint:disable-next-line:triple-equals
    this.deleteMember = this.deleteMember.filter(id => id != idMember);
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
  public selectAllToDelete(): void {
    if (this.select) {
      this.checked = false;
      this.deleteMember = [];
    } else {
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < this.member.length; i++) {
        this.deleteMember.push(this.member[i].idMember);
      }
      this.checked = true;
    }
  }
  public clearError(): void {
    this.error = null;
  }
  ngOnDestroy() {
    this.sub.unsubscribe();
  }
  private getChartsAge(): void {
    this.adminService.getChartsAge().subscribe((chart: Charts[]) => {
      this.chartsAgeToPeople = chart;
      this.viewAgeChart = false;
    }, err => {
      this.error = err.response;
      this.viewAgeChart = false;
    }, () => this.viewAgeChart = false);
  }
  private getChartsSex(): void {
    this.adminService.getChartsSex().subscribe((chart: Charts[]) => {
      this.chartsSexInMember = chart;
      this.viewSexChart = false;
    }, err => {
      this.error = err.response;
      this.viewSexChart = false;
    }, () => this.viewSexChart = false);
  }
  private getChartsEducation(): void {
    this.adminService.getChartsEducation().subscribe((chart: Charts[]) => {
      this.chartsEducationInMember = chart;
      this.viewEducationChart = false;
    }, err => {
      this.error = err.response;
      this.viewEducationChart = false;
    }, () => this.viewEducationChart = false);
  }
  private getChartsArea(): void {
    this.adminService.getChartsArea().subscribe((chart: Charts[]) => {
      this.chartsAreaInMember = chart;
      this.viewAreaChart = false;
    }, err => {
      this.error = err.response;
      this.viewEducationChart = false;
    }, () => this.viewEducationChart = false);
  }
  private getMember(): void {
    this.adminService.getMember().subscribe((member: Member[]) => {
        this.member = member;
        this.copyMember = member;
        if (this.select) {
          this.deleteMember.push(member[member.length - 1].idMember);
        }
        this.viewTable = false;
      },
      err => {
        this.error = err.response;
        this.viewTable = false;
      }, () => this.viewTable = false);
  }
  private setMember(): void {
    this.editMember = {
      basicInformation: {
        name: null,
        surname: null,
        pesel: null,
        idNumber: null,
        age: null,
        education: null
      },
      contactDetails: {
        street: null,
        houseNumber: null,
        township: null,
        postOffice: null,
        postalCode: null,
        community: null,
        district: null,
        voivodeship: null,
        area: null,
        phoneNumber: null,
        email: null,
      },
      laborMarketStatus: {
        unemployedPerson: null,
        longTermUnemployed: null,
        professionallyInactive: null,
        learningPerson: null,
        notLearningPerson: null,
        other: null,
        working: null,
        selfEmployed: null,
        employedInMicroSmallMediumEnterprise: null,
        employedInBigEnterprise: null,
        employedInGovernmentAdministration: null,
        employedInLocalGovernmentAdministration: null,
        employedInNonGovernmentalOrganization: null,
        nameOfWorkplace: null,
        occupationPerformed: null,
        nationalMinority: null,
        emigrant: null,
        disabledPerson: null
      },
      directionOfEducation: {
        nameUniversity: null,
        department: null,
        fieldOfStudy: null,
        profile: null,
        degreeOfStudies: null,
        yearStartStudy: null
      },
      additionalInformation: {
        repeatYear: null,
        studyingAnotherDirection: null,
        nameUniversity: null,
        department: null,
        fieldOfStudy: null,
        profile: null,
        yearStartStudy: null,
        workPlacementAndYear: null,
        studiedAnotherUniversity: null,
        nameAnotherUniversity: null,
        departmentAnother: null,
        fieldOfStudyAnother: null,
        profileAnother: null,
        yearStartAndEndStudyAnother: null,
        workPlacementAndYearAnother: null
      },
      statement: {
        homelessPerson: null,
        anotherUnfavorablePersonSocialSituation: null,
        statement: null
      }
    };
  }
}


