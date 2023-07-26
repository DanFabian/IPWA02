

import jakarta.inject.Inject;
import java.io.Serializable;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;


@Named
@ApplicationScoped

public class GeborgenController implements Serializable{
    
    @Inject
    private NetzDAO netzDAO;
    @Inject
    private LetztesNetz letztesNetz;
    
    // speichert ausgewähltes Netz mit status "geborgen" in DB

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
