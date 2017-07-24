package Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "occupancies")
public class Occupancies {

    private Long id;
    private Date dateOccupied;
    private String accountNumber;
    private int roomNumber;
    private String rateApplied;
    private String phoneCharge;
    private String notes;

    public Occupancies() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "date_occupied")
    public Date getDateOccupied() {
        return dateOccupied;
    }

    public void setDateOccupied(Date dateOccupied) {
        this.dateOccupied = dateOccupied;
    }

    @Column(name = "account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column(name = "room_number")
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Column(name = "rate_applied")
    public String getRateApplied() {
        return rateApplied;
    }

    public void setRateApplied(String rateApplied) {
        this.rateApplied = rateApplied;
    }

    @Column(name = "phone_charge")
    public String getPhoneCharge() {
        return phoneCharge;
    }

    public void setPhoneCharge(String phoneCharge) {
        this.phoneCharge = phoneCharge;
    }

    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
