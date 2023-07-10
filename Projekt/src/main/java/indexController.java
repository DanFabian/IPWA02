/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danie
 */
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;


@Named
@ApplicationScoped
public class indexController {
    
    private String auswahl;
    
  
    @Inject   
    private person person;   

    public String getAuswahl() {
        return auswahl;
    }

    public void setAuswahl(String auswahl) {
        this.auswahl = auswahl;
    }

    public String geheSeite2() {
        if (person.getTelefon().equalsIgnoreCase("")){
           person.setBerger(false);}
        else {person.setBerger(true);}
        return "auswahl";
      
        
        }      
}
