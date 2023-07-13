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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



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
        netz.getMelderList().add(melder);
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        t.begin();
        em.persist(neuesNetz);
        t.commit();
        
        em.close();
    }
    
    public void saveNetzMelder(Netz neuesNetz, Melder neuerMelder)
    {
        neuesNetz.getMelderList().add(neuerMelder);
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        t.begin();
        em.persist(neuesNetz);
        em.persist(neuerMelder);
        t.commit();
        
        em.close();
    }
    
}
