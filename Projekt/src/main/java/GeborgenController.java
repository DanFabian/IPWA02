

import jakarta.inject.Inject;
import java.io.Serializable;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Named
@ApplicationScoped

public class GeborgenController implements Serializable{
    
    @Inject
    private NetzDAO netzDAO;
    @Inject
    private LetztesNetz letztesNetz;

    public String NetzGeborgen(Netz auswahlNetz) {
        
        letztesNetz.setBeschreibung(auswahlNetz.getBeschreibung());
        letztesNetz.setBreite(auswahlNetz.getBreite());
        letztesNetz.setLaenge(auswahlNetz.getLaenge());
        letztesNetz.setGroesse(auswahlNetz.getGroesse());
        letztesNetz.setStatus(auswahlNetz.getStatus());
         
         auswahlNetz.setStatus("geborgen");
         netzDAO.aktualisiereNetz(auswahlNetz);
       return "zusammenfassung"; 
    }
}
