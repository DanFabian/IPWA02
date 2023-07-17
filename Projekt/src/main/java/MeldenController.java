
import jakarta.inject.Inject;
import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

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
    
  
    public String saveNetzMelder(){
        
        
        netz.setBeschreibung(this.beschreibung);
        netz.setBreite(this.breite);
        netz.setLaenge(this.laenge);
        netz.setGroesse(this.groesse);
        netz.setStatus(this.status);
        
        
        melder.setNachname(person.getNachname());
        melder.setVorname(person.getVorname());
        melder.setTelefon(person.getTelefon());
       
        
        
        netzDAO.saveNetzMelder(netz, melder);
        
        
        
        return "test.xhtml";
                
    }
}
