package Entities;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customers {

    private Long id;
    private Long accountNumber;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String emergencyName;
    private int emergencyNumber;
    private String notes;

    public Customers() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "account_number")
    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone_number")
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "emergency_name")
    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    @Column(name = "emergency_number")
    public int getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(int emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}