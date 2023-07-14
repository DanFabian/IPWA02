

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
    private Netz netz;
    @Inject
    private person person;
    @Inject
    private Berger berger;
    @Inject
    private BergerDAO bergerDAO;
    
    public String NetzGeborgen(Netz auswahlNetz) {
         
         auswahlNetz.setStatus("geborgen");
         netzDAO.aktualisiereNetz(auswahlNetz);
       return "test"; 
    }
}
