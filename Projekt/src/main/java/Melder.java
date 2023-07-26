


import jakarta.inject.Named;
import java.io.Serializable;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Named
@Entity

public class Melder implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nachname;
    private String vorname;
    private String telefon;
    
    
    @OneToMany (fetch = FetchType.LAZY, mappedBy = "melder")
    private List<Netz> netzList = new ArrayList<>(0);

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId()
    {
    return id;
    }
    //wird nicht gebraucht
    /*@Override
    public boolean equals(Object obj){
        if(obj instanceof Melder) {
            Melder m = (Melder) obj;
            if (m.getNachname().equals(this.nachname) &&
                    m.getVorname().equals(this.vorname)
                   )
                return true;
        }
        return false;
    } */
    
    public List<Netz> getNetzList() {
        return netzList;
    }

    public void setNetzList(List<Netz> netzList) {
        this.netzList = netzList;
    }
      
    public String getNachname()
    {
        return nachname;
    }

    public String getVorname()
    {
        return vorname;
    }

    public String getTelefon()
    {
        return telefon;
    }

    public void setNachname(String nachname)
    {
        this.nachname=nachname;
    }

    public void setVorname(String vorname)
    {
        this.vorname=vorname;
    }

    public void setTelefon(String telefon)
    {
        this.telefon=telefon;
    }


}
