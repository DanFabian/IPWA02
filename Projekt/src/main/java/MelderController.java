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

public class MelderController implements Serializable {
    
    @Inject
    private Melder melder;
    @Inject
    private MelderDAO melderDAO;
    
    
    public void saveMelder(){
        melderDAO.saveMelder(melder);
    }
}
