
import jakarta.inject.Inject;
import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@SessionScoped

public class MeldenController implements Serializable{
   private String beschreibung;
   private String breite;
   private String laenge;
   private int groesse;
   private String status = "gemeldet";

      
    @Inject
    private NetzDAO netzDAO;
    @Inject  
    private Netz netz;
    @Inject
    private person person;
    @Inject
    private Melder melder;
    @Inject
    private LetztesNetz letztesNetz;
    @Inject
    private MelderDAO melderDAO;

   

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
    
  // melder und netz werden in DB gespeichert, es wird geprueft ob melder schon vorhanden, ggf neuer erstellt wegen ID
    public String saveNetzMelder(){
        
        
        
        melderDAO.pruefeMelder(person);
        int check = person.getPersonMelderId();
        if (check == 0)
            {melderDAO.erzeugeMelderId();}
       
        
        letztesNetz.setBeschreibung(this.beschreibung);
        letztesNetz.setBreite(this.breite);
        letztesNetz.setLaenge(this.laenge);
        letztesNetz.setGroesse(this.groesse);
        letztesNetz.setStatus(this.status);
   
        netz.setBeschreibung(this.beschreibung);
        netz.setBreite(this.breite);
        netz.setLaenge(this.laenge);
        netz.setGroesse(this.groesse);
        netz.setStatus(this.status);
       
        melder.setId(person.getPersonMelderId());
        melder.setNachname(person.getNachname());
        melder.setVorname(person.getVorname());
        melder.setTelefon(person.getTelefon());
        
        netzDAO.saveNetzMelder(netz, melder);
       
        
        return "zusammenfassung";
        
       
    }
}
