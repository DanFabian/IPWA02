

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

    
    public String NetzBergen(Netz auswahlNetz) {
         berger.setNachname(person.getNachname());
         berger.setVorname(person.getVorname());
         berger.setTelefon(person.getTelefon());
         auswahlNetz.setStatus("bergungbevorstehend");
         netzDAO.saveNetzBerger(auswahlNetz, berger);
       return "test"; 
    }
    
}
