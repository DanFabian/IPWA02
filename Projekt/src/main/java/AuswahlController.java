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
import java.io.Serializable;

@Named
@ApplicationScoped

public class AuswahlController implements Serializable{
    
   
    @Inject
    private PersonController personController;
  
    
    private String auswahl;

    public String getAuswahl() {
        return auswahl;
    }

    public void setAuswahl(String auswahl) {
        this.auswahl = auswahl;
    }
    
    public String geheSeite(){
        personController.erzeugeMelder();
       
        return "melden";
    }
    
}
