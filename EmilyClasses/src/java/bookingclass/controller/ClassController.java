package bookingclass.controller;

import bookingclass.entity.Classes;
import dao.ClassesDaoImpl;
import java.util.ArrayList;
import viewInterface.IClass;


/**
 *
 * @author Eoin
 */
public class ClassController implements IClass {
    ClassesDaoImpl data = new ClassesDaoImpl();
    
    //Store time available for the type of class and date selected
    public ArrayList<Classes> checkClassAvailable(Classes c){
        
        ArrayList <Classes> classAvailable = new ArrayList();
        String classType = c.getType();
        
        if (classType == "private" || classType == "ingroup"){
            classAvailable = data.selectEmptyClass(c.getDate()); //Select depending on the type of class
            
        }else{
            classAvailable = data.selectSemiprivateClass(c.getDate());   //Select if class = semiprivate
        }
        return classAvailable;
        
    }
    
    
    public int previousQuantityStudents (int classID){
        int previousQuantityStudents = data.checkQuantityStudents (classID);
        return previousQuantityStudents; 
    }
    
    public void bookClass (Classes c, int previousQS){
        data.insertQuantityStudents(c, (previousQS + c.getQuantityStudents()));
        data.book(c);
        
    }
    
}
