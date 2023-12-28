package com.ruzmetov.hotelprojectapp.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
@Entity

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "reservation_payment_id")
    @JoinColumn(name = "payment_id", referencedColumnName = "customer_payment_id")
    @JoinColumn(name = "payment_id", referencedColumnName = "service_payment_id")
    @JoinColumn(name = "payment_id", referencedColumnName = "event_payment_id")
    @Column(name = "payment_id")
    private UUID paymentId;

    @ManyToMany
    @JoinColumn(name = "payment_room_number", referencedColumnName = "room_number")
    @Column(name = "payment_room_number")
    private int roomNumber;

    @ManyToMany
    @JoinColumn(name = "payment_service_id", referencedColumnName = "service_id")
    @Column(name = "payment_service_id")
    private UUID serviceId;

    @ManyToOne
    @JoinColumn(name = "payment_event_id", referencedColumnName = "event_id")
    @Column(name = "payment_event_id")
    private UUID eventId;

    @ManyToMany
    @JoinColumn (name = "payment_customer_first_name", referencedColumnName = "customer_first_name")
    @Column(name = "payment_customer_first_name")
    private String customerFirstName;

    @ManyToMany
    @JoinColumn (name = "payment_customer_last_name", referencedColumnName = "customer_last_name")
    @Column(name = "payment_customer_last_name")
    private String customerLastName;

    @Column(name = "payment_credit_card_number")
    private int creditCardNumber;

    @Column(name = "payment_credit_card_expiring_date")
    private Date creditCardExpiringDate;

    @Column(name = "payment_credit_card_CVV")
    private int creditCardCVV;

    @ManyToMany
    @JoinColumn(name = "payment_method", referencedColumnName = "reservation_payment_method")
    @JoinColumn(name = "payment_method", referencedColumnName = "customer_payment_method")
    @JoinColumn(name = "payment_method", referencedColumnName = "service_payment_method")
    @JoinColumn(name = "payment_method", referencedColumnName = "event_payment_method")
    @Column(name = "payment_method")
    private String paymentMethod;

    @ManyToMany
    @JoinColumn(name = "payment_total_amount", referencedColumnName = "reservation_total_amount")
    @JoinColumn(name = "payment_total_amount", referencedColumnName = "customer_total_amount")
    @JoinColumn(name = "payment_total_amount", referencedColumnName = "event_total_price")
    @JoinColumn(name = "payment_total_amount", referencedColumnName = "service_total_price")
    @JoinColumn(name = "payment_total_amount", referencedColumnName = "room_total_price")
    @Column(name = "payment_total_amount")
    private double totalAmount;

    @Column(name = "payment_transaction_id")
    private UUID transactionId;

    @Column(name = "payment_transaction_history")
    private String transactionHistory;

    @ManyToMany
    @JoinColumn (name = "payment_employee_id", referencedColumnName = "employee_id")
    @Column(name = "payment_employee_id")
    private UUID employeeId;

    @ManyToMany
    @JoinColumn (name = "payment_administrator_id", referencedColumnName = "administrator_id")
    @Column(name = "payment_administrator_id")
    private UUID administratorId;

    @Column(name = "payment_create")
    private Date paymentTabCreate;

    @Column(name = "payment_update")
    private Date paymentTabUpdate;

    public Payment(int roomNumber, UUID serviceId, UUID eventId, String customerFirstName, String customerLastName, int creditCardNumber, Date creditCardExpiringDate, int creditCardCVV, String paymentMethod, double totalAmount, UUID transactionId, String transactionHistory, UUID employeeId, UUID administratorId, Date paymentTabCreate, Date paymentTabUpdate) {
        this.paymentId = UUID.randomUUID();
        this.roomNumber = roomNumber;
        this.serviceId = serviceId;
        this.eventId = eventId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpiringDate = creditCardExpiringDate;
        this.creditCardCVV = creditCardCVV;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
        this.transactionId = transactionId;
        this.transactionHistory = transactionHistory;
        this.employeeId = employeeId;
        this.administratorId = administratorId;
        this.paymentTabCreate = paymentTabCreate;
        this.paymentTabUpdate = paymentTabUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment that = (Payment) o;
        return roomNumber == that.roomNumber && creditCardNumber == that.creditCardNumber && creditCardCVV == that.creditCardCVV && Double.compare(totalAmount, that.totalAmount) == 0 && Objects.equals(paymentId, that.paymentId) && Objects.equals(serviceId, that.serviceId) && Objects.equals(eventId, that.eventId) && Objects.equals(customerFirstName, that.customerFirstName) && Objects.equals(customerLastName, that.customerLastName) && Objects.equals(creditCardExpiringDate, that.creditCardExpiringDate) && Objects.equals(paymentMethod, that.paymentMethod) && Objects.equals(transactionId, that.transactionId) && Objects.equals(transactionHistory, that.transactionHistory) && Objects.equals(employeeId, that.employeeId) && Objects.equals(administratorId, that.administratorId) && Objects.equals(paymentTabCreate, that.paymentTabCreate) && Objects.equals(paymentTabUpdate, that.paymentTabUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, roomNumber, serviceId, eventId, customerFirstName, customerLastName, creditCardNumber, creditCardExpiringDate, creditCardCVV, paymentMethod, totalAmount, transactionId, transactionHistory, employeeId, administratorId, paymentTabCreate, paymentTabUpdate);
    }

    @Override
    public String toString() {
        return "CommonPayment{" +
                "paymentId=" + paymentId +
                ", roomNumber=" + roomNumber +
                ", serviceId=" + serviceId +
                ", eventId=" + eventId +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", creditCardNumber=" + creditCardNumber +
                ", creditCardExpiringDate=" + creditCardExpiringDate +
                ", creditCardCVV=" + creditCardCVV +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", totalAmount=" + totalAmount +
                ", transactionId=" + transactionId +
                ", transactionHistory='" + transactionHistory + '\'' +
                ", employeeId=" + employeeId +
                ", administratorId=" + administratorId +
                ", paymentTabCreate=" + paymentTabCreate +
                ", paymentTabUpdate=" + paymentTabUpdate +
                '}';
    }
}
