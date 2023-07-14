/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import jakarta.enterprise.context.ApplicationScoped;
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

@javax.persistence.Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int nr;
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

public int getNr()
{
return nr;
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

public void setNr (int nr)
{
    this.nr=nr;
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
