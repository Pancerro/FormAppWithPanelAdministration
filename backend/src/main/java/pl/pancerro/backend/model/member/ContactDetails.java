package pl.pancerro.backend.model.member;

import pl.pancerro.backend.model.enumPack.Area;
import pl.pancerro.backend.model.enumPack.Voivodeship;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "Dane_kontatkowe")
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Kontatku")
    private long idContact;
    @Column(name = "Ulica")
    private String street; //ulica
    @Column(name = "Numer_domu")
    private String houseNumber; //numer domu
    @Column(name = "Miejscowosc")
    private String township; //miejscowosc
    @Column(name = "Poczta")
    private String postOffice; //poczta
    @Column(name = "Kod_Pocztowy")
    private String postalCode; // kod pocztowy
    @Column(name = "Gmina")
    private String community; //gmina
    @Column(name = "Powiat")
    private String district; //powiat
    @Enumerated(EnumType.STRING)
    @Column(name = "Wojewodztwo")
    private Voivodeship voivodeship;//wojewodztwo
    @Enumerated(EnumType.STRING)
    @Column(name = "Obszar")
    private Area area; // obszar - miejski czy wiejski
    @Column(name = "Numer_Telefonu")
    private String phoneNumber;//telefon
    @Email
    @Column(name = "Email")
    private String email;
    public ContactDetails() {
    }

    public ContactDetails(String street, String houseNumber, String township, String postOffice, String postalCode, String community, String district, Voivodeship voivodeship, Area area, String phoneNumber, String email) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.township = township;
        this.postOffice = postOffice;
        this.postalCode = postalCode;
        this.community = community;
        this.district = district;
        this.voivodeship = voivodeship;
        this.area = area;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public long getIdContact() {
        return idContact;
    }

    public void setIdContact(long idContact) {
        this.idContact = idContact;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Voivodeship getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(Voivodeship voivodeship) {
        this.voivodeship = voivodeship;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
