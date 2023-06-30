/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import jakarta.inject.Named;

/**
 *
 * @author danie
 */
@Named
@Entity
public class Melder implements Serializable {

@javax.persistence.Id
private int nr;
private String nachname;
private String vorname;
private String telefon;

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
