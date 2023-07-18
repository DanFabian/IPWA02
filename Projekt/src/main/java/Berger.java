


import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Named
@Entity
public class Berger implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nachname;
    private String vorname;
    private String telefon;

    @OneToMany
    private List<Netz> netzList = new ArrayList<>(0);

    
    

    
    

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Netz> getNetzList() {
        return netzList;
    }

    public void setNetzList(List<Netz> netzList) {
        this.netzList = netzList;
    
    }
    
}
