/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danie
 */

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.NamedQuery;
import javax.persistence.EntityTransaction;



@Named
@ApplicationScoped




public class Controller {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectnet");
   
    public List<Netz> getFindall() 
        { 
            EntityManager em = emf.createEntityManager();
            Query abfrage = em.createQuery("SELECT a FROM Netz a");
            List<Netz> alleNetze = abfrage.getResultList();
            em.close();
            return alleNetze;
        
    }
    
    public String getName() 
        { 
            EntityManager em = emf.createEntityManager();
            Query abfrage = em.createQuery("select a from Melder a");
            String NameMelder = abfrage.toString();
            em.close();
            return NameMelder;
        
    }
    
   
    public void saveMelder(Melder neuerMelder)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t= em.getTransaction();
        
        t.begin();
        em.persist(neuerMelder);
        t.commit();
        
        em.close();
        
        
    }
    
    public void saveBerger(Berger neuerBerger)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t= em.getTransaction();
        
        t.begin();
        em.persist(neuerBerger);
        t.commit();
        
        em.close();
        
        
    }
}
