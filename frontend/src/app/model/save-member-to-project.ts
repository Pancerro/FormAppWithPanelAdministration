import {Member} from './member';
import {Project} from './project';

export interface SaveMemberToProject {
  idSave?: number;
  member?: Member;
  project?: Project;
}
