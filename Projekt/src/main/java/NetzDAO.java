/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danie
 */
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



@Named
@ApplicationScoped


public class NetzDAO {
    @Inject
    private Netz netz;
    @Inject
    private Melder melder;
   
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectnet");
    
    
    public void saveNetz(Netz neuesNetz)
    {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        t.begin();
        em.persist(neuesNetz);
        t.commit();
        
        em.close();
    }
    
    public void saveNetzMelder(Netz neuesNetz, Melder neuerMelder)
    {
      
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        t.begin();
        em.persist(neuesNetz);
        em.persist(neuerMelder);
        t.commit();
        
        em.close();
    }
    
    public void saveNetzBerger(Netz gemeldetesNetz, Berger neuerBerger)
    {
        neuerBerger.getNetzList().add(gemeldetesNetz);
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        t.begin();
        em.merge(gemeldetesNetz);
        em.persist(neuerBerger);
        t.commit();
        
        em.close();
    }
    
   public List<Netz> zeigeNetzeBergungBevorstehend() 
        { 
            EntityManager em = emf.createEntityManager();
            Query abfrage = em.createQuery("SELECT a FROM Netz a where a.status='bergungbevorstehend'");
            
            List<Netz> alleNetze = abfrage.getResultList();
            em.close();
            return alleNetze;
        
    }
    
   public void aktualisiereNetz(Netz gemeldetesNetz)
    {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        t.begin();
        em.merge(gemeldetesNetz);
        
        t.commit();
        
        em.close();
    }
   
   public List<Netz> zeigeLetztesNetz()
    {
        
         EntityManager em = emf.createEntityManager();
            Query abfrage = em.createQuery("SELECT a FROM Netz a where a.status='bergungbevorstehend'");
            
            List<Netz> alleNetze = abfrage.getResultList();
            em.close();
            int lastIndex = alleNetze.size() -1;
         
            return alleNetze;
    }
}
