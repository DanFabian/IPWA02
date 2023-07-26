

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


@Named
@RequestScoped


public class MelderDAO {
    
    @Inject
    person person;
   
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectnet");
   
  
    
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
    
    // eine Liste aller Melder wird abgefragt
    public List alleMelder()
            
    {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        Query abfrage = em.createQuery("SELECT Distinct a FROM Melder a");
        List<Melder> alleMelder = abfrage.getResultList();
        em.close();
        
        return alleMelder;
        
    }
    
    /* public List letzterMelder()
            
    {
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        Query abfrage = em.createQuery("select t from Melder t order by t.id desc", Melder.class).setMaxResults(1);
        
        List<Melder> letzterMelder = abfrage.getResultList();
        em.close();
        
        return letzterMelder;
        
    } */
     
    // Ein neuer Melder ohne Inhalt wird angelegt und die ID in person zwischengespeichert
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
     
     // Es wird geprüft ob die neu angelegte Person in der DB vorhanden ist,wenn ja dann ID in person
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
    
    
  
