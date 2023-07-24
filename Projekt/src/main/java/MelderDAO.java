

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danie
 */
@Named
@ApplicationScoped


public class MelderDAO {
    
    @Inject
    person person;
   
    
    
    
    
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectnet");
   
    public String test(){
        return "test";
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
    
    public void aktualisiereMelder(Melder neuerMelder)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t= em.getTransaction();
       
        
        t.begin();
        em.merge(neuerMelder);
        t.commit();
        
        em.close();
    }
    public List alleMelder()
            
    {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        Query abfrage = em.createQuery("SELECT Distinct a FROM Melder a");
        List<Melder> alleMelder = abfrage.getResultList();
        em.close();
        
        return alleMelder;
        
    }
    
     public List letzterMelder()
            
    {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        Query abfrage = em.createQuery("select t from Melder t order by t.id desc", Melder.class).setMaxResults(1);
        
        List<Melder> letzterMelder = abfrage.getResultList();
        em.close();
        
        return letzterMelder;
        
    }
     
     public void erzeugeMelderId()
    {   Melder neuerMelder = new Melder();
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t= em.getTransaction();
       
        
        t.begin();
        em.persist(neuerMelder);
        
        person.setPersonMelderId(neuerMelder.getId());
        t.commit();
       
        em.close();
    }
      public void pruefeMelder(person person)
            
    {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        Query abfrage = em.createQuery("SELECT Distinct a FROM Melder a");
        List<Melder> alleMelder = abfrage.getResultList();
       
        
        for (Melder m : alleMelder) {
            if (m.getNachname().equals(person.getNachname()) &&
                   m.getVorname().equals(person.getVorname())){
            
        
            person.setPersonMelderId(m.getId()); 
                }}
        em.close();
        
        
    }
}
    
    
  
