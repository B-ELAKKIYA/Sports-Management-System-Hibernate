package com.ground.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "SLOT_USAGE_TBL")
public class SlotUsage {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usage_seq_gen")
	@SequenceGenerator(
	    name = "usage_seq_gen",
	    sequenceName = "USAGE_SEQ",
	    allocationSize = 1
	)
	@Column(name = "USAGE_ID")
	private int usageID;

    @Column(name = "BOOKING_ID")
    private String bookingID;

    @Column(name = "ACTUAL_SPORT_PLAYED")
    private String actualSportPlayed;

    @Column(name = "ACTUAL_PLAYERS_COUNT")
    private int actualPlayersCount;

    @Column(name = "ACTUAL_START_TIME")
    private Timestamp actualStartTime;

    @Column(name = "ACTUAL_END_TIME")
    private Timestamp actualEndTime;

    @Column(name = "OVERTIME_MINUTES")
    private int overtimeMinutes;

    @Column(name = "OVERTIME_CHARGE_AMOUNT")
    private double overtimeChargeAmount;

    @Column(name = "GROUND_CONDITION_RATING")
    private String groundConditionRating;

    @Column(name = "CLEANLINESS_RATING")
    private String cleanlinessRating;

    @Column(name = "CARETAKER_REMARKS")
    private String caretakerRemarks;

    @Column(name = "USAGE_STATUS")
    private String usageStatus;

    public SlotUsage() {
    }

   public int getUsageID() {
        return usageID;
    }

    public void setUsageID(int usageID) {
        this.usageID = usageID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getActualSportPlayed() {
        return actualSportPlayed;
    }

    public void setActualSportPlayed(String actualSportPlayed) {
        this.actualSportPlayed = actualSportPlayed;
    }

    public int getActualPlayersCount() {
        return actualPlayersCount;
    }

    public void setActualPlayersCount(int actualPlayersCount) {
        this.actualPlayersCount = actualPlayersCount;
    }

    public Timestamp getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(Timestamp actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public Timestamp getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(Timestamp actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public int getOvertimeMinutes() {
        return overtimeMinutes;
    }

    public void setOvertimeMinutes(int overtimeMinutes) {
        this.overtimeMinutes = overtimeMinutes;
    }

    public double getOvertimeChargeAmount() {
        return overtimeChargeAmount;
    }

    public void setOvertimeChargeAmount(double overtimeChargeAmount) {
        this.overtimeChargeAmount = overtimeChargeAmount;
    }

    public String getGroundConditionRating() {
        return groundConditionRating;
    }

    public void setGroundConditionRating(String groundConditionRating) {
        this.groundConditionRating = groundConditionRating;
    }

    public String getCleanlinessRating() {
        return cleanlinessRating;
    }

    public void setCleanlinessRating(String cleanlinessRating) {
        this.cleanlinessRating = cleanlinessRating;
    }

    public String getCaretakerRemarks() {
        return caretakerRemarks;
    }

    public void setCaretakerRemarks(String caretakerRemarks) {
        this.caretakerRemarks = caretakerRemarks;
    }

    public String getUsageStatus() {
        return usageStatus;
    }

    public void setUsageStatus(String usageStatus) {
        this.usageStatus = usageStatus;
    }

	public String getActualSport() {
		return null;
	}

	public int getActualPlayers() {
		return 0;
	}

	public double getOvertimeRatePerMinute() {
		return 0;
	}

	public String getGroundCondition() {
		return null;
	}

	public String getCleanliness() {
		return null;
	}

	public void setActualSport(String string) {
		
	}

	public String getRemarks() {
		return null;
	}

	public double getOvertimeRatePerMinute1() {
		return 0;
	}
}
