

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.List;
import java.util.Objects;
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
    
    public List alleMelder()
            
    {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        Query abfrage = em.createQuery("SELECT Distinct a FROM Melder a");
        List<Melder> alleMelder = abfrage.getResultList();
        em.close();
        
        return alleMelder;
        
    }
    
    
}
    
    
  
