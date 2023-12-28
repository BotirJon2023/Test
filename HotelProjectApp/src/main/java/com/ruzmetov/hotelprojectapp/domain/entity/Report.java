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
@Table (name = "report")
@Entity

public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private UUID reportId;

    @Column(name = "report_start_date")
    private Date startDate;

    @Column(name = "report_end_date")
    private Date endDate;

    @Column(name = "report_revenue_by_rooms")
    private String revenueByRooms;

    @Column(name = "report_revenue_by_event")
    private String revenueByEvent;

    @Column(name = "report_revenue_by_service")
    private String revenueByService;

    @Column(name = "report_occupied_rooms")
    private String occupiedRooms;

    @Column(name = "report_vacant_rooms")
    private String vacantRooms;

    @Column(name = "review_scores_and_feedback")
    private String reviewScoresAndFeedback;

    @ManyToMany
    @JoinColumn(name = "cancellation_rates", referencedColumnName = "reservation_cancelled_info")
    @Column(name = "cancellation_rates")
    private String cancellationRates;

    @ManyToMany
    @JoinColumn (name = "report_access_employee_id", referencedColumnName = "employee_id")
    @Column(name = "report_access_employee_id")
    private UUID accessEmployeeId;

    @ManyToMany
    @JoinColumn (name = "report_access_administrator_id", referencedColumnName = "administrator_id")
    @Column(name = "report_access_administrator_id")
    private UUID accessAdministratorId;

    @Column(name = "report_create")
    private Date reportTabCreate;

    @Column(name = "report_update")
    private Date reportTabUpdate;

    public Report(Date startDate, Date endDate, String revenueByRooms, String revenueByEvent, String revenueByService, String occupiedRooms, String vacantRooms, String reviewScoresAndFeedback, String cancellationRates, UUID accessEmployeeId, UUID accessAdministratorId, Date reportTabCreate, Date reportTabUpdate) {
        this.reportId = UUID.randomUUID();
        this.startDate = startDate;
        this.endDate = endDate;
        this.revenueByRooms = revenueByRooms;
        this.revenueByEvent = revenueByEvent;
        this.revenueByService = revenueByService;
        this.occupiedRooms = occupiedRooms;
        this.vacantRooms = vacantRooms;
        this.reviewScoresAndFeedback = reviewScoresAndFeedback;
        this.cancellationRates = cancellationRates;
        this.accessEmployeeId = accessEmployeeId;
        this.accessAdministratorId = accessAdministratorId;
        this.reportTabCreate = reportTabCreate;
        this.reportTabUpdate = reportTabUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report that = (Report) o;
        return Objects.equals(reportId, that.reportId) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(revenueByRooms, that.revenueByRooms) && Objects.equals(revenueByEvent, that.revenueByEvent) && Objects.equals(revenueByService, that.revenueByService) && Objects.equals(occupiedRooms, that.occupiedRooms) && Objects.equals(vacantRooms, that.vacantRooms) && Objects.equals(reviewScoresAndFeedback, that.reviewScoresAndFeedback) && Objects.equals(cancellationRates, that.cancellationRates) && Objects.equals(accessEmployeeId, that.accessEmployeeId) && Objects.equals(accessAdministratorId, that.accessAdministratorId) && Objects.equals(reportTabCreate, that.reportTabCreate) && Objects.equals(reportTabUpdate, that.reportTabUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, startDate, endDate, revenueByRooms, revenueByEvent, revenueByService, occupiedRooms, vacantRooms, reviewScoresAndFeedback, cancellationRates, accessEmployeeId, accessAdministratorId, reportTabCreate, reportTabUpdate);
    }

    @Override
    public String toString() {
        return "CommonReport{" +
                "reportId=" + reportId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", revenueByRooms='" + revenueByRooms + '\'' +
                ", revenueByEvent='" + revenueByEvent + '\'' +
                ", revenueByService='" + revenueByService + '\'' +
                ", occupiedRooms='" + occupiedRooms + '\'' +
                ", vacantRooms='" + vacantRooms + '\'' +
                ", reviewScoresAndFeedback='" + reviewScoresAndFeedback + '\'' +
                ", cancellationRates='" + cancellationRates + '\'' +
                ", accessEmployeeId=" + accessEmployeeId +
                ", accessAdministratorId=" + accessAdministratorId +
                ", reportTabCreate=" + reportTabCreate +
                ", reportTabUpdate=" + reportTabUpdate +
                '}';
    }
}
