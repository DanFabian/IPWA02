
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


@Named
@ApplicationScoped

public class indexController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectnet");
    private String auswahl;
    
  
    @Inject   
    private person person;  
    @Inject   
    private MelderDAO melderDAO;  
   @Inject   
    private Melder melder; 
    public String getAuswahl() {
        return auswahl;
    }

    public void setAuswahl(String auswahl) {
        this.auswahl = auswahl;
    }

    public String geheSeite() {
        
       /*melderDAO.erzeugeMelderId();*/
        if (person.getTelefon().equalsIgnoreCase("")){
           person.setBerger(false);
            person.setMelder(true);
        }
        else {person.setBerger(true);
              person.setMelder(false);
           }
        return "auswahl";
      
        
        }      
}
