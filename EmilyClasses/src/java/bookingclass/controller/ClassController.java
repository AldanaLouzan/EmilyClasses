package bookingclass.controller;

import bookingclass.entity.Classes;
import dao.ClassesDaoImpl;
import java.util.ArrayList;


/**
 *
 * @author Eoin
 */
public class ClassController {
    ClassesDaoImpl data = new ClassesDaoImpl();
    
    //Store time available for the type of class and date selected
    public ArrayList<Classes> classType(Classes c){
        
        ArrayList <Classes> timeAvailable = new ArrayList();
        String classType = c.getType();
        
        if (classType == "private" || classType == "in-group"){
            timeAvailable = data.selectEmptyClass(c.getDate()); //Select depending on the type of class
            
        }else{
            timeAvailable = data.selectSemiprivateClass(c.getDate());   //Select if class = semiprivate
        }
        return timeAvailable;
        
    }
    
    public void bookClass (Classes c){
        data.book(c);
        System.out.println("Your class has been booked");
        System.out.println("And your booking ID is: ");
    }
    
    public void quantityStudents(Classes c){
        if(c.getType()== "private"){
            data.insertQuantityStudents(c, 1);
        }else if (c.getType() == "semiprivate"){
            int previousQuantity = c.getQuantityStudents();
            data.insertQuantityStudents(c, previousQuantity++);
        }else{
            
        }
        
    }
    
}
