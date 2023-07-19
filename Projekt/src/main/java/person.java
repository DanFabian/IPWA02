import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ApplicationScoped


public class person implements Serializable {
    
  
    private int personMelderId =0;
    private int personBergerId=0;

    
    
    private int nr;
    private String nachname;
    private String vorname;
    private String telefon;
    private boolean berger;
    private boolean melder;
    
    public int getPersonBergerId() {
        return personBergerId;
    }

    public void setPersonBergerId(int personBergerId) {
        this.personBergerId = personBergerId;
    }

    public int getPersonMelderId() {
        return personMelderId;
    }

    public void setPersonMelderId(int personMelderId) {
        this.personMelderId = personMelderId;    
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;}

    public boolean getMelder() {
        return melder;
    }

    public void setMelder(boolean melder) {
        this.melder = melder;
    }

    public boolean getBerger() {
        return berger;
    }

    public void setBerger(boolean berger) {
        this.berger = berger;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    
}

