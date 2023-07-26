import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped



public class AnzeigenController implements Serializable {
    @Inject
    private NetzDAO netzDAO;
     @Inject
    private BergerDAO bergerDAO;
    
    public List<Netz> NetzzuBergerBergung(Berger berger){
    return netzDAO.NetzzuBergerBergung(berger);
   
    }
    
    public List<Berger> zeigeBergerNetze(){
        return bergerDAO.zeigeBergerNetze();
    }
}
