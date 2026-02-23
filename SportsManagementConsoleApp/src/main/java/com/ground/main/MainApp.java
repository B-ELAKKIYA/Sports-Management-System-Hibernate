package com.ground.main;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.ground.dao.GroundSlotDAO;
import com.ground.dao.SlotUsageDAO;
import com.ground.entity.GroundSlot;
import com.ground.entity.SlotUsage;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("  COMMUNITY SPORTS GROUND MANAGEMENT");

        GroundSlotDAO groundDAO = new GroundSlotDAO();
        SlotUsageDAO usageDAO = new SlotUsageDAO();

        try {

            GroundSlot slot = new GroundSlot();

            slot.setTimeSlot("06:00-08:00");
            slot.setTeamOrGroupName("Sunrise FC");
            slot.setContactPersonName("Meenakshi Rao");
            slot.setContactMobile("9998887771");
            slot.setUserType("RESIDENT");
            slot.setPlannedSport("FOOTBALL");
            slot.setEstimatedPlayersCount(14);
            slot.setBaseSlotFee(300.0);
            slot.setCalculatedBookingAmount(390.0);
            slot.setBookingStatus("PENDING");

            String bookingID = groundDAO.insertBooking(slot);

            if (bookingID != null) {
                System.out.println("Booking Registered Successfully");
                System.out.println("Generated Booking ID: " + bookingID);
            } else {
                System.out.println("Booking Registration Failed");
                return;
            }
            boolean confirmed = groundDAO
                    .updateBookingStatusAndCancellation(bookingID, "CONFIRMED", null);

            System.out.println(
                    confirmed ? "Booking Confirmed"
                              : "Booking Confirmation Failed");


            SlotUsage usage = new SlotUsage();

            usage.setBookingID(bookingID);
            usage.setActualSportPlayed("FOOTBALL");
            usage.setActualPlayersCount(15);
            usage.setActualStartTime(new Timestamp(System.currentTimeMillis()));
            usage.setActualEndTime(
                    new Timestamp(System.currentTimeMillis() + (2 * 60 * 60 * 1000))
            );
            usage.setOvertimeMinutes(10);
            usage.setOvertimeChargeAmount(50.0);
            usage.setGroundConditionRating("GOOD");
            usage.setCleanlinessRating("GOOD");
            usage.setCaretakerRemarks("Smooth match, no issues");
            usage.setUsageStatus("COMPLETED");

            boolean usageInserted = usageDAO.insertSlotUsage(usage);

            System.out.println(
                    usageInserted ? "Slot Usage Recorded"
                                  : "Slot Usage Recording Failed");

            System.out.println("\n--- All Bookings ---");

            List<GroundSlot> bookings =
                    groundDAO.viewBookingsByDateAndStatus(
                            new Date(System.currentTimeMillis()), null);

            for (GroundSlot b : bookings) {
                System.out.println(
                        "ID: " + b.getBookingID() +
                        " | Team: " + b.getTeamOrGroupName() +
                        " | Status: " + b.getBookingStatus()
                );
            }

            System.out.println("\n--- All Slot Usage Records ---");

            List<SlotUsage> usages = usageDAO.getAllSlotUsage();

            for (SlotUsage u : usages) {
                System.out.println(
                        "UsageID: " + u.getUsageID() +
                        " | BookingID: " + u.getBookingID() +
                        " | Status: " + u.getUsageStatus()
                );
            }

        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
