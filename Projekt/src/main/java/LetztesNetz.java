
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped

// Speichert letztes bearbeitetes Netz für Zusammenfassung zwischen

public class LetztesNetz implements Serializable{
    
    private int id;
    private String  beschreibung;
    private String breite;
    private String laenge;
    private int groesse;
    private String status;
    
   
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getBreite() {
        return breite;
    }

    public void setBreite(String breite) {
        this.breite = breite;
    }

    public String getLaenge() {
        return laenge;
    }

    public void setLaenge(String laenge) {
        this.laenge = laenge;
    }

    public int getGroesse() {
        return groesse;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
