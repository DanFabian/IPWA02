
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.io.Serializable;

@Named
@SessionScoped

public class AuswahlController implements Serializable{
    
    private String auswahl;

    public String getAuswahl() {
        return auswahl;
    }

    public void setAuswahl(String auswahl) {
        this.auswahl = auswahl;
    }
    
    public String geheSeite(){
        switch (auswahl) {
            case "Melden":
                return "melden";
            case "Bergen":
                return "bergen";
            case "Geborgen":
                return "geborgen";
            case "Anzeigen":
                return "anzeigen";
            default:
                break;
        }
        
        return "auswahl";
    }
    
}
