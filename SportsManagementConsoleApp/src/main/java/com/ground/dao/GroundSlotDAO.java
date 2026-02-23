package com.ground.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ground.entity.GroundSlot;
import com.ground.util.HibernateUtil;

public class GroundSlotDAO {

    public GroundSlot findBooking(String bookingID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(GroundSlot.class, bookingID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<GroundSlot> viewBookingsByDateAndStatus(Date bookingDate, String status) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            StringBuilder hql = new StringBuilder("FROM GroundSlot WHERE 1=1 ");

            if (bookingDate != null) {
                hql.append("AND bookingDate = :bookingDate ");
            }

            if (status != null && !status.isBlank()) {
                hql.append("AND bookingStatus = :status ");
            }

            Query<GroundSlot> query = session.createQuery(hql.toString(), GroundSlot.class);

            if (bookingDate != null) {
                query.setParameter("bookingDate", bookingDate);
            }

            if (status != null && !status.isBlank()) {
                query.setParameter("status", status);
            }

            return query.getResultList();
        }
    }

    public String insertBooking(GroundSlot slot) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            String id = (String) session.createNativeQuery(
                    "SELECT 'GB' || TO_CHAR(BOOKING_SEQ.NEXTVAL,'FM0000') FROM DUAL")
                    .getSingleResult();

            slot.setBookingID(id);
            slot.setBookingDate(new Date(System.currentTimeMillis()));
            slot.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));

            session.persist(slot);

            tx.commit();
            return id;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateBookingStatusAndCancellation(String bookingID, String status, String reason) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            GroundSlot slot = session.get(GroundSlot.class, bookingID);

            if (slot == null) {
                return false;
            }

            slot.setBookingStatus(status);
            slot.setCancellationReason(reason);

            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCalculatedBookingAmount(String bookingID, double amount) {

        if (amount < 0) return false;

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            GroundSlot slot = session.get(GroundSlot.class, bookingID);

            if (slot == null) {
                return false;
            }

            slot.setCalculatedBookingAmount(amount);

            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public List<GroundSlot> findConfirmedBookingsForDateAndSlot(Date bookingDate, String timeSlot) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            String hql = "FROM GroundSlot WHERE bookingDate = :date "
                       + "AND timeSlot = :slot "
                       + "AND bookingStatus = 'CONFIRMED'";

            return session.createQuery(hql, GroundSlot.class)
                    .setParameter("date", bookingDate)
                    .setParameter("slot", timeSlot)
                    .getResultList();
        }
    }
}
