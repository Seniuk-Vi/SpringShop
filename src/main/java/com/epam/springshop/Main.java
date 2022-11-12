//package com.epam.springshop;
//
//import com.epam.springshop.model.User;
//import com.epam.springshop.model.enums.RoleEnum;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Main {
//    public static void main(String[] args) {
//        Map<String, String> cfg = new HashMap<>();
//        cfg.put("hibernate.connection.driver_class", "org.postgresql.Driver");
//        cfg.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/shop");
//        cfg.put("hibernate.connection.username", "postgres");
//        cfg.put("hibernate.connection.password", "1085");
//        cfg.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE_UNIT",cfg);
//        EntityManager entityManager=entityManagerFactory.createEntityManager();
//
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        entityTransaction.begin();
//        User user = User.builder().password("asd")
//                .email("email")
//                .enabled(true)
//                .locale("UK")
//                .login("login")
//                .name("name")
//                .surname("surname")
//                .role(RoleEnum.USER)
//                .phone_number("1234123412").build();
//        user.getRole().name();
//        entityManager.persist(user);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();
//    }
//}
