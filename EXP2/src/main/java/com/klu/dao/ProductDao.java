package com.klu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.entity.Products;
import com.klu.util.ProductUtil;

public class ProductDao {

    // Insert
    public void saveProduct(Products p) {
        Transaction tx = null;
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(p);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Select all
    public List<Products> getAllProducts() {
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            return session.createQuery("from products", Products.class).list();
        }
    }

    // Select by ID
    public Products getId(int pid) {
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            return session.get(Products.class, pid);
        }
    }

    // Update
    public void updateProduct(Products p) {
        Transaction tx = null;
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(p);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteProduct(int pid) {
        Transaction tx = null;
        try (Session session = ProductUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Products p = session.get(Products.class, pid);
            if (p != null) {
                session.delete(p);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}