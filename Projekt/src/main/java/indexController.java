
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
 
  
    @Inject   
    private person person;  



    public String geheSeite() {
      
     
        if (person.getTelefon().equalsIgnoreCase("")){
          person.setMelder(true);
        }
        else {person.setMelder(false);
           }
        return "auswahl";
      
        
        }      
}
