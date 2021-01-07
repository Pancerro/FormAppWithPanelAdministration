export interface LaborMarketStatus {
  idLaborMarketStatus?: number;
  unemployedPerson?: boolean;
  longTermUnemployed?: boolean;
  professionallyInactive?: boolean;
  learningPerson?: boolean;
  notLearningPerson?: boolean;
  other?: boolean;
  working?: boolean;
  selfEmployed?: boolean;
  employedInMicroSmallMediumEnterprise?: boolean;
  employedInBigEnterprise?: boolean;
  employedInGovernmentAdministration?: boolean;
  employedInLocalGovernmentAdministration?: boolean;
  employedInNonGovernmentalOrganization?: boolean;
  nameOfWorkplace?: string;
  occupationPerformed?: string;
  nationalMinority?: boolean;
  emigrant?: boolean;
  disabledPerson?: boolean;
}
