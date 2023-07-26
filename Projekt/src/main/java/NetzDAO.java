
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



@Named
@RequestScoped


public class NetzDAO {


   
    
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
    
    public List<Netz> zeigeNetzeGemeldet() 
        { 
            EntityManager em = emf.createEntityManager();
            Query abfrage = em.createQuery("SELECT a FROM Netz a where a.status='gemeldet'");
            
            List<Netz> alleNetze = abfrage.getResultList();
            em.close();
            return alleNetze;
        
    }
    /*
    public void saveNetzMelder(Netz neuesNetz, Melder neuerMelder)
    {
        
        EntityManager em = emf.createEntityManager();
        
        
        
        EntityTransaction t = em.getTransaction();
        
        
        
            neuerMelder.getNetzList().add(neuesNetz);
            neuesNetz.setMelder(neuerMelder);
                t.begin();
                em.merge(neuerMelder);
                em.merge(neuesNetz);
                t.commit();
            em.close();
        }
    */
        public void saveNetzMelder(Netz neuesNetz, Melder neuerMelder)
    {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        neuesNetz.setMelder(neuerMelder);
        neuerMelder.getNetzList().add(neuesNetz);
        t.begin();
        em.merge(neuesNetz);
        em.merge(neuerMelder);
        t.commit();
        
        em.close();
       
                
    }
    
    public void saveNetzBerger(Netz gemeldetesNetz, Berger neuerBerger)
    {
        neuerBerger.getNetzList().add(gemeldetesNetz);
        gemeldetesNetz.setBerger(neuerBerger);
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        t.begin();
        em.merge(gemeldetesNetz);
        em.merge(neuerBerger);
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
   /*
   public List<Netz> zeigeNetzeBergungBevorstehendMitBerger() 
        { 
            EntityManager em = emf.createEntityManager();
            Query abfrage = em.createQuery("SELECT a FROM Netz a JOIN a.berger b where a.status='bergungbevorstehend'");
            
            List<Netz> alleNetze = abfrage.getResultList();
            em.close();
            return alleNetze;
        
    }
    */
   public void aktualisiereNetz(Netz gemeldetesNetz)
    {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        t.begin();
        em.merge(gemeldetesNetz);
        
        t.commit();
        
        em.close();
    }
   

   // liefert Netze mit status bergungbevorstehen zu einem Berger aus
   public List<Netz> NetzzuBergerBergung(Berger berger)
    {   
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
       int id = berger.getId();
        Query abfrage = em.createQuery("select n from Netz n JOIN n.berger b WHERE b.id = :id AND n.status ='bergungbevorstehend'").setParameter("id", id);
        
        List<Netz> NetzBerger = abfrage.getResultList();
        
        em.close();
        
        return NetzBerger;
    }
   
   // Liest die Netze in Melder aus
 
  
   
  
   
   // Speichert das zulestzt eingegebene oder bearbeitete Netz
   /*public List letzteNetz()
            
    {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        Query abfrage = em.createQuery("select n from Netz n order by n.id desc", Netz.class).setMaxResults(1);
        
        List<Melder> letzterMelder = abfrage.getResultList();
        
        em.close();
        
        return letzterMelder;
        
    }*/
}
