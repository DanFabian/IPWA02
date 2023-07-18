

import jakarta.inject.Inject;
import java.io.Serializable;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Named
@ApplicationScoped

public class BergenController implements Serializable{
   
  
    @Inject
    private NetzDAO netzDAO;
    @Inject
    private person person;
    @Inject
    private Berger berger;
    @Inject
    private LetztesNetz letztesNetz;
    
    
    public String NetzBergen(Netz auswahlNetz) {
   
        berger.setId(1);
        berger.setNachname(person.getNachname());
        berger.setVorname(person.getVorname());
        berger.setTelefon(person.getTelefon());
        auswahlNetz.setStatus("bergungbevorstehend");
        
        letztesNetz.setBeschreibung(auswahlNetz.getBeschreibung());
        letztesNetz.setBreite(auswahlNetz.getBreite());
        letztesNetz.setLaenge(auswahlNetz.getLaenge());
        letztesNetz.setGroesse(auswahlNetz.getGroesse());
        letztesNetz.setStatus(auswahlNetz.getStatus());
        
         netzDAO.saveNetzBerger(auswahlNetz, berger);
         
       return "zusammenfassung"; 
    }
    
}
