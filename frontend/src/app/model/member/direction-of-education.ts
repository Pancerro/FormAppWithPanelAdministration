import {DegreeOfStudy} from '../enumPack/degree-of-study.enum';

export interface DirectionOfEducation {
  idDirectionOfEducation?: number;
  nameUniversity?: string;
  department?: string;
  fieldOfStudy?: string;
  profile?: string;
  degreeOfStudies?: DegreeOfStudy;
  yearStartStudy?: string;
}
