package com.sa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class OneToMany {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myPU");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Customer customer=new Customer();
        customer.setName("Sajal Mondal");
        customer.setEmail("sajal134@gmail.com");
        entityManager.persist(customer);

        Order order=new Order();
        order.setAmount(12000);
        order.setCustomer(customer);
        order.setLocalDate(LocalDate.now());
        entityManager.persist(order);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();




    }
}
