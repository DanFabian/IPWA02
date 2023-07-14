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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Named
@ApplicationScoped

public class BergenController implements Serializable{
   
  
    @Inject
    private NetzDAO netzDAO;
    @Inject  
    private Netz netz;
    @Inject
    private person person;
    @Inject
    private Berger berger;
    @Inject
    private BergerDAO bergerDAO;
    
    public String NetzBergen(Netz auswahlNetz) {
         berger.setNachname(person.getNachname());
         berger.setVorname(person.getVorname());
         berger.setTelefon(person.getTelefon());
         auswahlNetz.setStatus("bergungbevorstehend");
         netzDAO.saveNetzBerger(auswahlNetz, berger);
       return "test"; 
    }
    
}
