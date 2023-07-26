

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped

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
