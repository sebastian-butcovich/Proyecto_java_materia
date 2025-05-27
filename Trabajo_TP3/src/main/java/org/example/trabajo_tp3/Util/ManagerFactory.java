package org.example.trabajo_tp3.Util;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class ManagerFactory {
        private static  EntityManager entityManager;
        private ManagerFactory() {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
            entityManager = emf.createEntityManager();
        }
        public static EntityManager getEntityManager() {
            if(entityManager==null || !entityManager.isOpen()){
                new ManagerFactory();
            }
            return entityManager;
        }
        public static void close(){
            entityManager.close();
        }
    }
