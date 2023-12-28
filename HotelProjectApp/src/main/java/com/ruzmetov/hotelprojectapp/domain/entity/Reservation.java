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
@Table(name = "reservation")
@Entity

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToMany
    @JoinColumn (name = "reservation_id", referencedColumnName = "customer_reservation_id")
    @Column(name = "reservation_id")
    private UUID reservationId;


    @ManyToMany
    @JoinColumn (name = "reservation_customer_first_name", referencedColumnName = "customer_first_name")
    @Column(name = "reservation_customer_first_name")
    private String customerFirstName;

    @ManyToMany
    @JoinColumn (name = "reservation_customer_last_name", referencedColumnName = "customer_last_name")
    @Column(name = "reservation_customer_last_name")
    private String customerLastName;

    @ManyToOne
    @JoinColumn(name = "reservation_room_number", referencedColumnName = "room_number")
    @Column(name = "reservation_room_number")
    private int roomNumber;

    @ManyToOne
    @JoinColumn(name = "reservation_event_id", referencedColumnName = "event_id")
    @Column(name = "reservation_event_id")
    private UUID eventId;

    @ManyToOne
    @JoinColumn(name = "reservation_service_id", referencedColumnName = "service_id")
    @Column(name = "reservation_service_id")
    private UUID serviceId;

    @OneToOne
    @JoinColumn(name = "reservation_total_amount", referencedColumnName = "payment_total_amount")
    @Column(name = "reservation_total_amount")
    private double totalAmount;

    @OneToOne
    @JoinColumn(name = "reservation_payment_method", referencedColumnName = "payment_method")
    @Column(name = "reservation_payment_method")
    private String paymentMethod;

    @OneToOne
    @JoinColumn(name = "reservation_payment_id", referencedColumnName = "payment_id")
    @Column(name = "reservation_payment_id")
    private UUID paymentId;

    @ManyToMany
    @JoinColumn(name = "reservation_cancelled_info", referencedColumnName = "cancellation_rates")
    @Column(name = "reservation_cancelled_info")
    private String cancellationInfo;

    @Column(name = "reservation_create")
    private Date reservationCreate;

    @Column(name = "reservation_update")
    private Date reservationUpdate;

    @ManyToOne
    @JoinColumn (name = "reservation_employee_id", referencedColumnName = "employee_id")
    @Column(name = "reservation_employee_id")
    private UUID employeeId;

    @ManyToOne
    @JoinColumn (name = "reservation_administrator_id", referencedColumnName = "administrator_id")
    @Column(name = "reservation_administrator_id")
    private UUID administratorId;

    public Reservation(String customerFirstName, String customerLastName, int roomNumber, UUID eventId, UUID serviceId, double totalAmount, String paymentMethod, UUID paymentId, String cancellationInfo, Date reservationCreate, Date reservationUpdate, UUID employeeId, UUID administratorId) {
        this.reservationId = UUID.randomUUID();
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.roomNumber = roomNumber;
        this.eventId = eventId;
        this.serviceId = serviceId;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.paymentId = paymentId;
        this.cancellationInfo = cancellationInfo;
        this.reservationCreate = reservationCreate;
        this.reservationUpdate = reservationUpdate;
        this.employeeId = employeeId;
        this.administratorId = administratorId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return roomNumber == that.roomNumber && Double.compare(totalAmount, that.totalAmount) == 0 && Objects.equals(reservationId, that.reservationId) && Objects.equals(customerFirstName, that.customerFirstName) && Objects.equals(customerLastName, that.customerLastName) && Objects.equals(eventId, that.eventId) && Objects.equals(serviceId, that.serviceId) && Objects.equals(paymentMethod, that.paymentMethod) && Objects.equals(paymentId, that.paymentId) && Objects.equals(cancellationInfo, that.cancellationInfo) && Objects.equals(reservationCreate, that.reservationCreate) && Objects.equals(reservationUpdate, that.reservationUpdate) && Objects.equals(employeeId, that.employeeId) && Objects.equals(administratorId, that.administratorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, customerFirstName, customerLastName, roomNumber, eventId, serviceId, totalAmount, paymentMethod, paymentId, cancellationInfo, reservationCreate, reservationUpdate, employeeId, administratorId);
    }

    @Override
    public String toString() {
        return "CommonReservation{" +
                "reservationId=" + reservationId +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", roomNumber=" + roomNumber +
                ", eventId=" + eventId +
                ", serviceId=" + serviceId +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentId=" + paymentId +
                ", cancellationInfo='" + cancellationInfo + '\'' +
                ", reservationCreate=" + reservationCreate +
                ", reservationUpdate=" + reservationUpdate +
                ", employeeId=" + employeeId +
                ", administratorId=" + administratorId +
                '}';
    }
}
