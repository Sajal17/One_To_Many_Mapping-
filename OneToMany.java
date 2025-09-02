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

        //Insertion
        Customer customer=new Customer();
        customer.setName("Ram Roy");
        customer.setEmail("ram134@gmail.com");
        entityManager.persist(customer);

        Order order=new Order();
        order.setAmount(12000);
        order.setCustomer(customer);
        order.setLocalDate(LocalDate.now());
        entityManager.persist(order);

        //Fetch
        Order order1=entityManager.find(Order.class,2);
        if(order1 !=null){
            System.out.println(order1);
            System.out.println(order1.getCustomer());
        }else {
            System.out.println("Order not found !!");
        }

        // Update
        Order order2=entityManager.find(Order.class,2);
        if (order2!=null){
            Customer customer=order2.getCustomer();
            customer.setEmail("ramroyl123@gmail.com");
            System.out.println("Updated ");
        }else {
            System.out.println("User not found..");
        } 

        // Delete
        Order order3=entityManager.find(Order.class,1);
        if (order3 !=null){
            entityManager.remove(order3);
            System.out.println("Deleted User and UserProfile");
        } else {
            System.out.println("User not found !!");
        }

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();




    }
}

