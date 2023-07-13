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

public class BergerDAO {
    
   
   
   private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectnet");
   
    public List<Netz> zeigeNetzeGemeldet() 
        { 
            EntityManager em = emf.createEntityManager();
            Query abfrage = em.createQuery("SELECT a FROM Netz a where a.status='gemeldet'");
            
            List<Netz> alleNetze = abfrage.getResultList();
            em.close();
            return alleNetze;
        
    }
}
    