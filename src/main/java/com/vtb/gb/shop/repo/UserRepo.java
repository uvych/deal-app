package com.vtb.gb.shop.repo;

import com.vtb.gb.shop.domain.Customer;
import com.vtb.gb.shop.domain.Deal;
import com.vtb.gb.shop.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserRepo {
    private SessionFactory factory;

    public UserRepo() {
        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }


    public String showProductsByConsume(String element){
        Session session = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Long> customerList = session.createQuery("SELECT c.id FROM Customer  c WHERE c.name = " + "'" +element + "'").getResultList();
            Customer customer = session.get(Customer.class, customerList.get(0));
            for (Product b : customer.getProducts()) {
                stringBuilder.append(b + "\n");
            }
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
        return stringBuilder.toString();
    }

    public String showConsumersByProductTitle(String element){
        Session session = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Long> customerList = session.createQuery("SELECT p.id FROM Product  p WHERE p.title = "  + "'" +element + "'").getResultList();
            Product product = session.get(Product.class, customerList.get(0));
            for (Customer b : product.getCustomers()) {
                stringBuilder.append(b + "\n");
            }
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
        return stringBuilder.toString();
    }

    public String deleteConsumer(String element){
        Session session = null;
        String result = "Done!";
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Long> customerList = session.createQuery("SELECT c.id FROM Customer  c WHERE c.name = " + "'" +element + "'").getResultList();
            session.createQuery("DELETE FROM Customer c WHERE c.id = " + customerList.get(0)).executeUpdate();
            session.getTransaction().commit();

        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public String deleteProduct(String element){
        Session session = null;
        String result = "Done!";
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Long> productList = session.createQuery("SELECT p.id FROM Product  p WHERE p.title = " + "'" +element + "'").getResultList();
            session.createQuery("DELETE FROM Customer c WHERE c.id = " + productList.get(0)).executeUpdate();
            session.getTransaction().commit();

        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public String buy(String element){
        String [] id = element.split(" ");
        String id_customer = id[0].strip();
        String id_product = id[1].strip();
        Long id_cus = Long.parseLong(id_customer);
        Long id_prod = Long.parseLong(id_product);
        Session session = null;
        String result = "Done!";
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id_cus);
            Product product = session.get(Product.class, id_prod);
            Deal deal = new Deal();
            deal.setCustomer(customer);
            deal.setProduct(product);
            deal.setPrice(product.getPrice());
            session.save(deal);
            session.getTransaction().commit();

        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }

        return result;
    }
}
