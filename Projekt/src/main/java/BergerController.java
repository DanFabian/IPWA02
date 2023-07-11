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

public class BergerController  implements Serializable{



 
    @Inject
    private Berger berger;
    @Inject
    private BergerDAO bergerDAO;
    @Inject person person;
    
    
    public void saveBerger(){
        berger.setNachname(person.getNachname());
        berger.setVorname(person.getVorname());
        bergerDAO.saveBerger(berger);
    }
}    

