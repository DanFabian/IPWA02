/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danie
 */

import jakarta.inject.Inject;
import java.io.Serializable;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped

public class MeldenController implements Serializable{
   private String beschreibung;
   private int nord;
   private int sued;
   private int groesse;
   private String status = "gemeldet";

    

   

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public int getNord() {
        return nord;
    }

    public void setNord(int nord) {
        this.nord = nord;
    }

    public int getSued() {
        return sued;
    }

    public void setSued(int sued) {
        this.sued = sued;
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
    
    
    @Inject
    private NetzDAO netzDAO;
    @Inject  
    private Netz netz;
    @Inject
    private person person;
    @Inject
    private Melder melder;
    @Inject
    private MelderDAO melderDAO;
    
    
    
    
    
    public String saveNetzMelder(){
        
        
        netz.setBeschreibung(this.beschreibung);
        netz.setNord(this.nord);
        netz.setSued(this.sued);
        netz.setGroesse(this.groesse);
        netz.setStatus(this.status);
        
        
        melder.setNachname(person.getNachname());
        melder.setVorname(person.getVorname());
        melder.setTelefon(person.getTelefon());
       
        
        
        netzDAO.saveNetzMelder(netz, melder);
        
        
        
        return "test";
    }
}
