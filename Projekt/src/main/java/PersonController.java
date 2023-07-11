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

public class PersonController {
    
    @Inject
    private Melder melder;
    @Inject
    private person person;
    @Inject
    private Berger berger;
    
    
    
        public void erzeugeMelder(){
       
        melder.setNachname(person.getNachname());
        melder.setVorname(person.getVorname());
        melder.setTelefon(person.getTelefon());
    }
    
        public void erzeugeBerger(){
       
        berger.setNachname(person.getNachname());
        berger.setVorname(person.getVorname());
       
    }
}
