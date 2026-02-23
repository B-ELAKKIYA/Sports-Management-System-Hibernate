package com.ground.entity;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "GROUND_SLOT_TBL")
public class GroundSlot {

    @Id
    @Column(name = "BOOKING_ID")
    private String bookingID;

    @Column(name = "BOOKING_DATE")
    private Date bookingDate;

    @Column(name = "TIME_SLOT")
    private String timeSlot;

    @Column(name = "TEAM_OR_GROUP_NAME")
    private String teamOrGroupName;

    @Column(name = "CONTACT_PERSON_NAME")
    private String contactPersonName;

    @Column(name = "CONTACT_MOBILE")
    private String contactMobile;

    @Column(name = "USER_TYPE")
    private String userType;

    @Column(name = "PLANNED_SPORT")
    private String plannedSport;

    @Column(name = "ESTIMATED_PLAYERS_COUNT")
    private int estimatedPlayersCount;

    @Column(name = "BASE_SLOT_FEE")
    private double baseSlotFee;

    @Column(name = "CALCULATED_BOOKING_AMOUNT")
    private double calculatedBookingAmount;

    @Column(name = "BOOKING_STATUS")
    private String bookingStatus;

    @Column(name = "CREATED_TIMESTAMP")
    private Timestamp createdTimestamp;

    @Column(name = "CANCELLATION_REASON")
    private String cancellationReason;

    // Default Constructor (Required by Hibernate)
    public GroundSlot() {
    }

    // Getters and Setters

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getTeamOrGroupName() {
        return teamOrGroupName;
    }

    public void setTeamOrGroupName(String teamOrGroupName) {
        this.teamOrGroupName = teamOrGroupName;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPlannedSport() {
        return plannedSport;
    }

    public void setPlannedSport(String plannedSport) {
        this.plannedSport = plannedSport;
    }

    public int getEstimatedPlayersCount() {
        return estimatedPlayersCount;
    }

    public void setEstimatedPlayersCount(int estimatedPlayersCount) {
        this.estimatedPlayersCount = estimatedPlayersCount;
    }

    public double getBaseSlotFee() {
        return baseSlotFee;
    }

    public void setBaseSlotFee(double baseSlotFee) {
        this.baseSlotFee = baseSlotFee;
    }

    public double getCalculatedBookingAmount() {
        return calculatedBookingAmount;
    }

    public void setCalculatedBookingAmount(double calculatedBookingAmount) {
        this.calculatedBookingAmount = calculatedBookingAmount;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }
}
