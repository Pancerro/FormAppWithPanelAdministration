package pl.pancerro.backend.model;


import pl.pancerro.backend.model.member.*;

import javax.persistence.*;

@Entity
@Table(name = "Uczestnicy")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Uczestnika")
    private long idMember;
    @OneToOne
    @JoinColumn(name = "id_Podstawowych_Informacji")
    private BasicInformation basicInformation;
    @OneToOne
    @JoinColumn(name = "id_Kontatku")
    private
    ContactDetails contactDetails;
    @OneToOne
    @JoinColumn(name = "id_Statusu_Pracy")
    private LaborMarketStatus laborMarketStatus;
    @OneToOne
    @JoinColumn(name = "id_Edukacji_Studii")
    private DirectionOfEducation directionOfEducation;
    @OneToOne
    @JoinColumn(name = "id_Informacji_Dodatkowych")
    private AdditionalInformation additionalInformation;
    @OneToOne
    @JoinColumn(name = "id_Oswiadczenia")
    private Statement statement;

    public Member() {
    }

    public Member(BasicInformation basicInformation, ContactDetails contactDetails, LaborMarketStatus laborMarketStatus, DirectionOfEducation directionOfEducation, AdditionalInformation additionalInformation, Statement statement) {
        this.basicInformation = basicInformation;
        this.contactDetails = contactDetails;
        this.laborMarketStatus = laborMarketStatus;
        this.directionOfEducation = directionOfEducation;
        this.additionalInformation = additionalInformation;
        this.statement = statement;
    }

    public long getIdMember() {
        return idMember;
    }

    public void setIdMember(long idMember) {
        this.idMember = idMember;
    }

    public BasicInformation getBasicInformation() {
        return basicInformation;
    }

    public void setBasicInformation(BasicInformation basicInformation) {
        this.basicInformation = basicInformation;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public LaborMarketStatus getLaborMarketStatus() {
        return laborMarketStatus;
    }

    public void setLaborMarketStatus(LaborMarketStatus laborMarketStatus) {
        this.laborMarketStatus = laborMarketStatus;
    }

    public DirectionOfEducation getDirectionOfEducation() {
        return directionOfEducation;
    }

    public void setDirectionOfEducation(DirectionOfEducation directionOfEducation) {
        this.directionOfEducation = directionOfEducation;
    }

    public AdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(AdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    @Override
    public String toString() {
        return "Member{" +
                "idMember=" + idMember +
                ", basicInformation=" + basicInformation +
                ", contactDetails=" + contactDetails +
                ", laborMarketStatus=" + laborMarketStatus +
                ", directionOfEducation=" + directionOfEducation +
                ", additionalInformation=" + additionalInformation +
                ", statement=" + statement +
                '}';
    }
}
