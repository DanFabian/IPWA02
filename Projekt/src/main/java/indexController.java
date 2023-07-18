
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;


@Named
@ApplicationScoped

public class indexController {
    
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
