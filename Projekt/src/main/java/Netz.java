/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danie
 */

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity

public class Netz implements Serializable{
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Netz) {
            Netz n = (Netz) obj;
            if (n.getBeschreibung().equals(this.beschreibung) &&
                    n.getBreite().equals(this.breite) &&
                    n.getLaenge().equals(this.laenge))
                return true;
        }
        return false;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String  beschreibung;
    private String breite;
    private String laenge;
    private int groesse;
    private String status;
    
    
    @ManyToOne
    /*@JoinColumn(name = "melder_id")*/
    private Melder melder;
    
    @ManyToOne
    /*@JoinColumn(name = "berger_id")*/
    private Berger berger;
   

    public Melder getMelder() {
        return melder;
    }

    public void setMelder(Melder melder) {
        this.melder = melder;
    }

    public Berger getBerger() {
        return berger;
    }

    public void setBerger(Berger berger) {
        this.berger = berger;
    }
   
    
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
