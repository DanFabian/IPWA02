
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
      
       /*melderDAO.erzeugeMelderId();*/
        if (person.getTelefon().equalsIgnoreCase("")){
           /*person.setBerger(false);*/
            person.setMelder(true);
        }
        else {/*person.setBerger(true);*/
              person.setMelder(false);
           }
        return "auswahl";
      
        
        }      
}
