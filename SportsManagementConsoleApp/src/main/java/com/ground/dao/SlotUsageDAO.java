package com.ground.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ground.entity.SlotUsage;
import com.ground.util.HibernateUtil;

public class SlotUsageDAO {

    public SlotUsage findUsageById(int usageID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(SlotUsage.class, usageID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public SlotUsage findUsageByBookingId(String bookingID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            String hql = "FROM SlotUsage WHERE bookingID = :bookingID";

            return session.createQuery(hql, SlotUsage.class)
                    .setParameter("bookingID", bookingID)
                    .uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertSlotUsage(SlotUsage usage) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.persist(usage);

            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSlotUsage(SlotUsage usage) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.merge(usage);

            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSlotUsage(int usageID) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            SlotUsage usage = session.get(SlotUsage.class, usageID);

            if (usage == null) {
                return false;
            }

            session.remove(usage);

            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public List<SlotUsage> getAllSlotUsage() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            String hql = "FROM SlotUsage ORDER BY usageID DESC";

            Query<SlotUsage> query = session.createQuery(hql, SlotUsage.class);

            return query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<SlotUsage> getUsageByStatus(String status) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            String hql = "FROM SlotUsage WHERE usageStatus = :status";

            return session.createQuery(hql, SlotUsage.class)
                    .setParameter("status", status)
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
