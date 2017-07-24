package Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payments {

    private Long id;
    private Date paymentDate;
    private String accountNumber;
    private Date firstDateOccupied;
    private Date lastDateOccupied;
    private int totalDays;
    private Double amountCharged;
    private Double taxRate;
    private Double taxAmount;
    private Double paymentTotal;
    private String notes;

    public Payments() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "payment_date")
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Column(name = "account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column(name = "first_date_occupied")
    public Date getFirstDateOccupied() {
        return firstDateOccupied;
    }

    public void setFirstDateOccupied(Date firstDateOccupied) {
        this.firstDateOccupied = firstDateOccupied;
    }

    @Column(name = "last_date_occupied")
    public Date getLastDateOccupied() {
        return lastDateOccupied;
    }

    public void setLastDateOccupied(Date lastDateOccupied) {
        this.lastDateOccupied = lastDateOccupied;
    }

    @Column(name = "total_days")
    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    @Column(name = "amount_charged")
    public Double getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(Double amountCharged) {
        this.amountCharged = amountCharged;
    }

    @Column(name = "tax_rate")
    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    @Column(name = "tax_amount")
    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    @Column(name = "payment_total")
    public Double getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(Double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
