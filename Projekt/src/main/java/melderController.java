/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danie
 */


import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Named

public class melderController {
    private String auswahl;

    public String getAuswahl() {
        return auswahl;
    }

    public void setAuswahl(String auswahl) {
        this.auswahl = auswahl;
    }
    
    public String geheSeite() {
        if (auswahl.equalsIgnoreCase("Melden"))
        return "netzMelden";
        else return "netzVerschollen";}
}
