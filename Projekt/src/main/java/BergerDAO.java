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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



@Named
@ApplicationScoped

public class BergerDAO {
    
    
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectnet");
   
    public String test(){
        return "test";
    }
    
    public void saveBerger(Berger neuerBerger)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        t.begin();
        em.persist(neuerBerger);
        t.commit();
        
        em.close();
    }
}
    