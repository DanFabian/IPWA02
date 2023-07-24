

import jakarta.inject.Inject;
import java.io.Serializable;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;


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
    @Inject
    private BergerDAO bergerDAO;
    
    
    public String NetzBergen(Netz auswahlNetz) {
        bergerDAO.pruefeBerger(person);
        int check = person.getPersonBergerId();
        if (check == 0)
            {bergerDAO.erzeugeBergerId();}
   
        berger.setId(person.getPersonBergerId());
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
