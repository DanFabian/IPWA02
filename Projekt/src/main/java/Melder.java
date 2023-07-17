/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import jakarta.inject.Inject;
import java.io.Serializable;
import javax.persistence.Entity;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

/**
 *
 * @author danie
 */
@Named
@Entity


public class Melder implements Serializable {
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Melder) {
            Melder m = (Melder) obj;
            if (m.getNachname().equals(this.nachname) &&
                    m.getVorname().equals(this.vorname) &&
                    m.getTelefon().equals(this.telefon))
                return true;
        }
        return false;
    }
    


@javax.persistence.Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String nachname;
private String vorname;
private String telefon;

@OneToMany
private List<Netz> netzList = new ArrayList<>(0);

    public List<Netz> getNetzList() {
        return netzList;
    }

    public void setNetzList(List<Netz> netzList) {
        this.netzList = netzList;
    }

public int getId()
{
return id;
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

public void setId (int id)
{
    this.id=id;
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
