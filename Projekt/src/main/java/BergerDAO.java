import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityTransaction;



@Named
@ApplicationScoped

public class BergerDAO {
    
   @Inject
   person person;
   
   private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectnet");
   
    public List<Netz> zeigeNetzeGemeldet() 
        { 
            EntityManager em = emf.createEntityManager();
            Query abfrage = em.createQuery("SELECT a FROM Netz a where a.status='gemeldet'");
            
            List<Netz> alleNetze = abfrage.getResultList();
            em.close();
            return alleNetze;
        
    }
    
    public List<Berger> zeigeBergerNetze() 
        { 
            EntityManager em = emf.createEntityManager();
            Query abfrage = em.createQuery("SELECT DISTINCT a from Berger a JOIN a.netzList b WHERE b.status='bergungbevorstehend'");
            
            List<Berger> alleBerger = abfrage.getResultList();
            em.close();
            return alleBerger;
        
    }
    
    public void erzeugeBergerId()
    {   Berger neuerBerger = new Berger();
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t= em.getTransaction();
       
        
        t.begin();
        em.persist(neuerBerger);
        
        person.setPersonBergerId(neuerBerger.getId());
        t.commit();
       
        em.close();
    }
    
    public void pruefeBerger(person person)
            
    {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        Query abfrage = em.createQuery("SELECT a FROM Berger a");
        List<Berger> alleBerger = abfrage.getResultList();
       
        
        for (Berger b : alleBerger) {
            if (b.getNachname().equals(person.getNachname()) &&
                   b.getVorname().equals(person.getVorname())){
            
        
            person.setPersonBergerId(b.getId()); 
                }}
        em.close();
        
        
    }
    
}
    