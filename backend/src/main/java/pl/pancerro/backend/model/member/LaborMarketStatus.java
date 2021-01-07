package pl.pancerro.backend.model.member;

import javax.persistence.*;

@Entity
@Table(name = "Rynek_Pracy")
public class LaborMarketStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Statusu_Pracy")
    private long idLaborMarketStatus;
    @Column(name = "Bezrobotny")
    private boolean unemployedPerson; //bezroobtny
    @Column(name = "Dlugotrwale_bezrobotny")
    private boolean longTermUnemployed; //dlugo trwale bezrobotny
    @Column(name = "Bierny_zawodowo")
    private boolean professionallyInactive; // bierny zawodowo
    @Column(name = "Osoba_uczaca_sie")
    private boolean learningPerson; //osoba uczaca sie lub ksztalcaca
    @Column(name = "Osoba_nie_uczaca_sie")
    private boolean notLearningPerson; //osoba nieuczestniczaca w ksztalceniu lub szkoleniu
    @Column(name = "Inne")
    private boolean other; //inne
    @Column(name = "Pracujacy")
    private boolean working; //pracujacy
    @Column(name = "Dzialnosc_na_wlasny_rachunek")
    private boolean selfEmployed; //dzialanosc na wlasny rachunek
    @Column(name = "Zatrudniony_w_mikro_malym_lub_srednim_przedsiebiorstwie")
    private boolean employedInMicroSmallMediumEnterprise; //zatrudniony w mirko malym lub srednim przedsiebiorstwie
    @Column(name = "Zatrudniony_w_duzym_przedsiebiorstwie")
    private boolean employedInBigEnterprise; //zatrudniony w duzym przedsiobiorstwie
    @Column(name = "Zatrudniony_w_administracji_rzadowej")
    private boolean employedInGovernmentAdministration; //zatrudniony w administracji rzadowej
    @Column(name = "Zatrudniony_w_administracji_samorzadowej")
    private boolean employedInLocalGovernmentAdministration; //zatrudniony w administracji samorzadowej
    @Column(name = "Zatrudnoiony_w_organizacji_pozarzodowej")
    private boolean employedInNonGovernmentalOrganization; // zatrudniony w oragnizacji pozarzadowej
    @Column(name = "Nazwa_Zakladu_Pracy")
    private String nameOfWorkplace; //nazwa zakladu pracy
    @Column(name = "Wykonywany_zawod")
    private String occupationPerformed; // wykonywany zawod
    @Column(name = "Mniejszosc_narodowa")
    private boolean nationalMinority; // mniejszosc narodowa
    @Column(name = "Emigrant")
    private boolean emigrant;
    @Column(name = "Osoba_Niepelnosprawna")
    private boolean disabledPerson; //osoba niepelnosprawna

    public LaborMarketStatus() {
    }

    public LaborMarketStatus(boolean unemployedPerson, boolean longTermUnemployed, boolean professionallyInactive, boolean learningPerson, boolean notLearningPerson, boolean other, boolean working, boolean selfEmployed, boolean employedInMicroSmallMediumEnterprise, boolean employedInBigEnterprise, boolean employedInGovernmentAdministration, boolean employedInLocalGovernmentAdministration, boolean employedInNonGovernmentalOrganization, String nameOfWorkplace, String occupationPerformed, boolean nationalMinority, boolean emigrant, boolean disabledPerson) {
        this.unemployedPerson = unemployedPerson;
        this.longTermUnemployed = longTermUnemployed;
        this.professionallyInactive = professionallyInactive;
        this.learningPerson = learningPerson;
        this.notLearningPerson = notLearningPerson;
        this.other = other;
        this.working = working;
        this.selfEmployed = selfEmployed;
        this.employedInMicroSmallMediumEnterprise = employedInMicroSmallMediumEnterprise;
        this.employedInBigEnterprise = employedInBigEnterprise;
        this.employedInGovernmentAdministration = employedInGovernmentAdministration;
        this.employedInLocalGovernmentAdministration = employedInLocalGovernmentAdministration;
        this.employedInNonGovernmentalOrganization = employedInNonGovernmentalOrganization;
        this.nameOfWorkplace = nameOfWorkplace;
        this.occupationPerformed = occupationPerformed;
        this.nationalMinority = nationalMinority;
        this.emigrant = emigrant;
        this.disabledPerson = disabledPerson;
    }

    public long getIdLaborMarketStatus() {
        return idLaborMarketStatus;
    }

    public void setIdLaborMarketStatus(long idLaborMarketStatus) {
        this.idLaborMarketStatus = idLaborMarketStatus;
    }

    public boolean isUnemployedPerson() {
        return unemployedPerson;
    }

    public void setUnemployedPerson(boolean unemployedPerson) {
        this.unemployedPerson = unemployedPerson;
    }

    public boolean isLongTermUnemployed() {
        return longTermUnemployed;
    }

    public void setLongTermUnemployed(boolean longTermUnemployed) {
        this.longTermUnemployed = longTermUnemployed;
    }

    public boolean isProfessionallyInactive() {
        return professionallyInactive;
    }

    public void setProfessionallyInactive(boolean professionallyInactive) {
        this.professionallyInactive = professionallyInactive;
    }

    public boolean isLearningPerson() {
        return learningPerson;
    }

    public void setLearningPerson(boolean learningPeson) {
        this.learningPerson = learningPeson;
    }

    public boolean isNotLearningPerson() {
        return notLearningPerson;
    }

    public void setNotLearningPerson(boolean notLearningPerson) {
        this.notLearningPerson = notLearningPerson;
    }

    public boolean isOther() {
        return other;
    }

    public void setOther(boolean other) {
        this.other = other;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public boolean isSelfEmployed() {
        return selfEmployed;
    }

    public void setSelfEmployed(boolean selfEmployed) {
        this.selfEmployed = selfEmployed;
    }

    public boolean isEmployedInMicroSmallMediumEnterprise() {
        return employedInMicroSmallMediumEnterprise;
    }

    public void setEmployedInMicroSmallMediumEnterprise(boolean employedInMicroSmallMediumEnterprise) {
        this.employedInMicroSmallMediumEnterprise = employedInMicroSmallMediumEnterprise;
    }

    public boolean isEmployedInBigEnterprise() {
        return employedInBigEnterprise;
    }

    public void setEmployedInBigEnterprise(boolean employedInBigEnterprise) {
        this.employedInBigEnterprise = employedInBigEnterprise;
    }

    public boolean isEmployedInGovernmentAdministration() {
        return employedInGovernmentAdministration;
    }

    public void setEmployedInGovernmentAdministration(boolean employedInGovernmentAdministration) {
        this.employedInGovernmentAdministration = employedInGovernmentAdministration;
    }

    public boolean isEmployedInLocalGovernmentAdministration() {
        return employedInLocalGovernmentAdministration;
    }

    public void setEmployedInLocalGovernmentAdministration(boolean employedInLocalGovernmentAdministration) {
        this.employedInLocalGovernmentAdministration = employedInLocalGovernmentAdministration;
    }

    public boolean isEmployedInNonGovernmentalOrganization() {
        return employedInNonGovernmentalOrganization;
    }

    public void setEmployedInNonGovernmentalOrganization(boolean employedInNonGevernmentalOrganization) {
        this.employedInNonGovernmentalOrganization = employedInNonGevernmentalOrganization;
    }

    public String getNameOfWorkplace() {
        return nameOfWorkplace;
    }

    public void setNameOfWorkplace(String nameOfWorkplace) {
        this.nameOfWorkplace = nameOfWorkplace;
    }

    public String getOccupationPerformed() {
        return occupationPerformed;
    }

    public void setOccupationPerformed(String occupationPerformed) {
        this.occupationPerformed = occupationPerformed;
    }

    public boolean isNationalMinority() {
        return nationalMinority;
    }

    public void setNationalMinority(boolean nationalMinority) {
        this.nationalMinority = nationalMinority;
    }

    public boolean isEmigrant() {
        return emigrant;
    }

    public void setEmigrant(boolean emigrant) {
        this.emigrant = emigrant;
    }

    public boolean isDisabledPerson() {
        return disabledPerson;
    }

    public void setDisabledPerson(boolean disabledPerson) {
        this.disabledPerson = disabledPerson;
    }

}
