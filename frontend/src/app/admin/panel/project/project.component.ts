import {Component, OnDestroy, OnInit} from '@angular/core';
import {AdminService} from '../../service/admin.service';
import {ExportAsConfig, ExportAsService} from 'ngx-export-as';
import {Subject, Subscription} from 'rxjs';
import {Charts} from '../../../model/charts';
import {SaveMemberToProject} from '../../../model/save-member-to-project';
import {Project} from '../../../model/project';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit, OnDestroy {
  constructor(private adminService: AdminService, private exportAsService: ExportAsService ) { }
  private subject = new Subject<void>();
  private sub: Subscription = new Subscription();
  public deleteAllProject: number[] = [];
  public removeOneProject: Project;
  public editProject: Project;
  public editModeProject: boolean;
  public viewProject = true;
  public checkedProject = [false];
  public selectProject = false;
  public extendProject: boolean[] = [];
  public extendAllOrNot = true;
  public deleteAllMember: number[] = [];
  public removeOneMember: SaveMemberToProject;
  public editMember: SaveMemberToProject;
  public editModeMember: boolean;
  public checkedMember = [false];
  public selectMember = [false];
  public searchInProject: string;
  public searchText: string;
  public hideColumn = [];
  public error: string;
  public chartsCountMemberInProject: Charts[] = [];
  public viewChartCountMemberInProject = true;
  public viewChart = true;
  public viewExportColumn = false;
  public checked = false;
  public exportType = null;
  public colorType = null;
  public saveToProject: SaveMemberToProject[] = [];
  public projectList: Project[] = [];

  ngOnInit() {
    this.setSaveMemberToProject();
    this.setProject();
    this.sub = this.subject.subscribe(() => {
      this.viewChartCountMemberInProject = true;
      this.viewProject = true;
      this.getCharts();
      this.getSaveMemberToProject();
      this.getProject();
    });
    this.subject.next();
  }
  public export(type: any, id): void {
    const exportAsConfig: ExportAsConfig = {
      type,
      elementIdOrContent: id
    };
    this.exportAsService.save(exportAsConfig, 'project').subscribe(() => {},
      () => this.error = 'Nie udalo sie wyeksportowac');
  }

  public clearError(): void {
    this.error = null;
  }

  public addModeProject(): void {
    this.editModeProject = false;
    this.setProject();
  }

  public editItemProject(project: Project): void {
    this.editModeProject = true;
    this.editProject = project;
    this.editProject = Object.create(project);
  }

  public addOrEditProject(project: Project): void {
      if (this.editModeProject) {
        this.adminService.editProject(project).subscribe(() => {
          this.subject.next();
        }, err => {
          this.error = err.status;
        });
      } else {
        this.adminService.addProject(project).subscribe(() => {
          this.subject.next();
        }, err => {
          this.error = err.status;
        });
      }

  }
  public selectAllToDeleteProject(): void {
    if (this.selectProject) {
      for (let i = 0; i < this.checkedMember.length; i++) {
        this.checkedMember[i] = false;
      }
      for (let i = 0; i < this.selectMember.length; i++) {
        this.selectMember[i] = false;
      }
      for (let i = 0; i < this.checkedProject.length; i++) {
        this.checkedProject[i] = false;
      }
      this.deleteAllProject = [];
      this.deleteAllMember = [];
    } else {
      for (let i = 0; i < this.checkedMember.length; i++) {
        this.checkedMember[i] = true;
      }
      for (let i = 0; i < this.selectMember.length; i++) {
        this.selectMember[i] = true;
      }
      for (let i = 0; i < this.checkedProject.length; i++) {
        this.checkedProject[i] = true;
      }
      this.saveToProject.forEach((member) => this.deleteAllMember.push(member.member.idMember));
      this.projectList.forEach((project) => this.deleteAllProject.push(project.idProject));
    }
  }
  public addDeleteProject(idProject: number): void {
    if (this.checkedProject[idProject]) {
      this.deleteFromDeleteProject(idProject);
      this.checkedProject[idProject] = false;
      this.checkedMember[idProject] = false;
      this.selectProject = false;
      this.selectAllToDeleteMember(idProject);
    } else {
      this.checkedProject[idProject] = true;
      this.checkedMember[idProject] = true;
      this.deleteAllProject.push(idProject);
      this.selectAllToDeleteMember(idProject);
    }
  }

  private deleteFromDeleteProject(idProject: number): void {
    this.deleteAllProject = this.deleteAllProject.filter(id => id !== idProject);
  }

  public removeItemProject(project: Project): void {
    this.removeOneProject = project;
  }
  public removeProject(id: number): void {
    this.deleteFromDeleteProject(id);
    this.saveToProject.forEach((member) => {
      if (member.project.idProject === id) {
        this.adminService.deleteMember(member.member.idMember).subscribe( // see to
          () => this.subject.next(),
          err => {
            this.error = err.status;
          }
        );
      }
    });
    this.adminService.deleteProject(id).subscribe(
      () => this.subject.next(),
      err => {
        this.error = err.status;
      }
    );
  }
  public deleteAllProjects(): void {
    this.deleteAllProject.forEach(id => this.removeProject(id));
  }
  public addModeUniversityCourses(): void {
    this.editModeMember = false;
    this.setSaveMemberToProject();
  }
  public editItemMember(saveToProject: SaveMemberToProject): void {
    this.editModeMember = true;
    this.editMember = Object.create(saveToProject);
  }

  public addOrEditMember(newSave: SaveMemberToProject): void {
    // tslint:disable-next-line:max-line-length
    if (this.editModeMember) {
      this.adminService.editSaveToProject(newSave).subscribe(() => {
        this.subject.next();
      }, err => {
        this.error = err.status;
      });
    } else {
      this.adminService.addSaveToProject(newSave).subscribe(() => {
        this.subject.next();
      }, err => {
        this.error = err.status;
      });
    }
  }
  public selectAllToDeleteMember(idProject: number): void {
    if (this.selectMember[idProject]) {
      this.selectMember[idProject] = false;
      this.checkedProject[idProject] = false;
      this.selectProject = false;
      this.deleteAllMember = [];
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < this.saveToProject.length; i++) {
        if (this.saveToProject[i].project.idProject === idProject) {
          this.checkedMember[this.saveToProject[i].member.idMember] = false;
        }
      }
    } else {
      this.selectMember[idProject] = true;
      this.checkedProject[idProject] = true;
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < this.saveToProject.length; i++) {
        if (this.saveToProject[i].project.idProject === idProject) {
          this.checkedMember[this.saveToProject[i].member.idMember] = true;
          this.deleteAllMember.push(this.saveToProject[i].member.idMember);
        }
      }
    }
  }
  public addDeleteMember(idMember: number, idProject: number): void {
    if (this.deleteAllMember.includes(idMember)) {
      this.checkedMember[idMember] = false;
      this.selectMember[idProject] = false;
      this.checkedProject[idProject] = false;
      this.selectProject = false;
      this.deleteFromDeleteProject(idProject);
      this.deleteFromDeleteMember(idMember);
    } else {
      this.deleteAllMember.push(idMember);
      this.checkedMember[idMember] = true;

    }
  }

  private deleteFromDeleteMember(idCourses: number): void {
    this.deleteAllMember = this.deleteAllMember.filter(id => id !== idCourses);
  }

  public removeItemMember(member: SaveMemberToProject): void {
    this.removeOneMember = member;
  }
  public removeMember(id: number): void { // see to
    this.deleteFromDeleteMember(id);
    this.adminService.deleteMember(id).subscribe(
      () => this.subject.next(),
      err => {
        this.error = err.status;
      }
    );
  }
  public deleteAllMembers(): void {
    this.deleteAllMember.forEach(id => this.removeMember(id));
  }

  public extend(idDepartment: number): void {
    this.extendProject[idDepartment] = !this.extendProject[idDepartment];
  }
  public extendAll(): void {
    if (this.extendAllOrNot) {
      for (let i = 1; i <= this.projectList.length; i++) {
        this.extendProject[i] = true;
      }
    }
    if (!this.extendAllOrNot) {
      for (let i = 1; i <= this.projectList.length; i++) {
        this.extendProject[i] = false;
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
    this.adminService.getChartsCountMemberInProject().subscribe((chart: Charts[]) => {
      this.chartsCountMemberInProject = chart;
      this.viewChartCountMemberInProject = false;
    }, err => {
      this.error = err.response;
      this.viewChartCountMemberInProject = false;
    }, () => this.viewChartCountMemberInProject = false);
  }
  private getSaveMemberToProject(): void {
    this.adminService.getSaveToProject().subscribe((member: SaveMemberToProject[]) => {
      this.saveToProject = member;
      member.forEach((save: SaveMemberToProject) => {
        this.checkedMember[save.member.idMember] = false;
      });
    }, err => {
      this.error = err.response;
    });
  }
  private getProject(): void {
    this.adminService.getProject().subscribe((project: Project[]) => {
      this.projectList = project;
      this.viewProject = false;
      // tslint:disable-next-line:no-shadowed-variable
      project.forEach((project: Project) => {
        this.checkedProject[project.idProject] = false;
        this.selectMember[project.idProject] = false;
      });
    }, err => {
      this.error = err.response;
      this.viewProject = false;
    }, () => this.viewProject = false);
  }
  private setProject(): void {
    this.editProject = {
      idProject: null,
      nameProject: null,
      descriptionProject: null,
      dataStart: null,
      dataEnd: null,
      active: null
    };
  }
  private setSaveMemberToProject(): void {
    this.editMember = {
      idSave: null,
      project: {
        idProject: null,
        nameProject: null,
        descriptionProject: null,
        dataStart: null,
        dataEnd: null,
        active: null
      },
      member: null
    };
  }
  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
